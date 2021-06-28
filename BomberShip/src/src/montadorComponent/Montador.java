package montadorComponent;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

import conexaoComponent.Conexao;
import conexaoComponent.ConnectionError;
import conexaoComponent.InvalidServer;
import conexaoComponent.NullServer;
import controleComponent.*;
import marComponent.Celula.*;
import marComponent.Mar.Mar;
import viewComponent.TelaJogo;

public class Montador {

	Conexao conexao;
	private Mar marAliado;
	private Mar marInimigo;
	private Celula[][] celulasConstrutor;

	private TelaJogo telaJogo;

	private outController controleOut;
	private InController controleIn;

	private final String host = "Host";

	private String mapaCSV;
	private String Arq;

	private int nivelInimigo;
	private String nomeInimigo;
	private String arqInimigo;

	private Bomba bombaInimiga;
	private Bomba bombaAliada;

	public Montador(String ip, int porta, int nivel, String meuNome) {

		try {
			conexao = new Conexao(ip, porta);

			if (!conexao.conecta())
				conexao.iniciaServer();

			Arq = getResource(getMapa(conexao.getPlayer(), nivel));

			comunicaInimigo(nivel, meuNome, mapaCSV);

			bombaAliada = new Bomba(Time.Aliado, meuNome, nivel);
			bombaAliada.setTurno(conexao.getPlayer().equals(host));
			controleOut = new outController(conexao.getThis(), bombaAliada);

			marAliado = criaMar(marAliado, Time.Aliado);
			marAliado = leArquivo(Arq, marAliado, nivel);
			marAliado = montaMar(marAliado);

			marInimigo = criaMar(marInimigo, Time.Inimigo);
			marInimigo = leArquivo(getResource(arqInimigo), marInimigo, nivelInimigo);
			marInimigo = montaMar(marInimigo);

			telaJogo = new TelaJogo(marAliado, marInimigo, conexao.getPlayer(), meuNome);

			bombaAliada.setItensView(telaJogo.getItensPlayer1View(), telaJogo.getLogView());

			bombaInimiga = new Bomba(Time.Inimigo, nomeInimigo, nivelInimigo);
			bombaInimiga.setTurno(conexao.getPlayer().equals(host));
			bombaInimiga.setItensView(telaJogo.getItensPlayer2View(), telaJogo.getLogView());

			controleIn = new InController(conexao.getThis(), marAliado, bombaAliada, bombaInimiga);
			controleIn.setLogView(telaJogo.getLogView());

			controleOut.setMar(marInimigo);
			controleOut.setLogView(telaJogo.getLogView());
			controleOut.setBombaInimiga(bombaInimiga);

			Thread recebeInput = new Thread(controleIn);
			recebeInput.start();

		} catch (InvalidMapImport | NullServer | InvalidServer e) {
			e.printStackTrace();
		}

	}

	private void comunicaInimigo(int nivel, String meuNome, String mapaCSV) {

		try {
			// conexao de pegar nível do inimigo
			conexao.enviaDados(Integer.toString(nivel));
			nivelInimigo = Integer.parseInt(conexao.recebeDados());

			// conexao de pegar nome do inimigo
			conexao.enviaDados(meuNome);
			nomeInimigo = conexao.recebeDados();

			// conexao de criar tabuleiro inimigo
			conexao.enviaDados(mapaCSV);
			arqInimigo = conexao.recebeDados();
		} catch (ConnectionError e) {
			e.printStackTrace();
		}
	}

	public String getMapa(String Player, int nivel) {

		int numPlayer;

		numPlayer = (Player.equals(host)) ? 1 : 2;

		mapaCSV = "marPlayer" + numPlayer + "Level" + nivel + ".csv";

		return mapaCSV;

	}

	public String getResource(String mapaCSV) throws InvalidMapImport {
		URL res = Thread.currentThread().getContextClassLoader().getResource(mapaCSV);
		File file = null;
		try {
			file = Paths.get(res.toURI()).toFile();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		String arquivo1 = file.getAbsolutePath();
		return arquivo1;
	}

	public Mar criaMar(Mar mar, Time time) {
		mar = new Mar();
		celulasConstrutor = new Celula[10][10];
		mar.setMar(celulasConstrutor, time);

		return mar;
	}

	public Mar leArquivo(String Arq, Mar mar, int nivel) {

		try { // o try catch fala se estourou o limite ou se há conflito nos navios
			CSVHandling csv = new CSVHandling();
			csv.setDataSource(Arq);
			String comandos[][] = csv.requestCommands();

			for (int i = 0; i < 11 + nivel; i++) {
				int x = Integer.parseInt(comandos[i][0].substring(0, 1));
				int y = Integer.parseInt(comandos[i][0].substring(2, 3));
				String sentido = comandos[i][1];
				String tipo = comandos[i][2];

				boolean a = true;

				mar.insere(tipo, sentido, x, y);

				if (!a)
					throw new InvalidMapContent("Há conflitos entre navios");
			}
		} catch (InvalidMapContent erro) {
			System.err.println("Erro:" + erro.getMessage() + "\nInsira um csv válido!");
			erro.printStackTrace();
		}

		return mar;
	}

	// coloca Água em todas as células vazias.
	public Mar montaMar(Mar mar) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (mar.getTipoCelula(i, j) == '~') {
					Agua water = new Agua(i, j, '~');
					try {
						mar.insereCelula(water);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

				if (mar.time == Time.Inimigo) {
					mar.celulaMar[i][j].setControle(controleOut);
					mar.celulaMar[i][j].setCelulaRevelada(false);
				}
			}
		}
		return mar;
	}
}
