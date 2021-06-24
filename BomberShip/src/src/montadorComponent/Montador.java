package montadorComponent;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

import conexaoComponent.Conexao;
import conexaoComponent.IBuildConexao;
import controleComponent.*;
import marComponent.Celula.*;
import marComponent.Mar.Mar;
import viewComponent.TelaJogo;

public class Montador {

	IBuildConexao conexao;
	private Mar marAliado;
	private Mar marInimigo;
	private Celula[][] celulasConstrutor;

	private outController controle;

	private String arqInimigo;
	private final String host = "Host";

	String mapaCSV;

	public Montador(String ip, int porta, int nivel) {

		try {
			conexao = new Conexao(ip, porta);

			if (!conexao.conecta())
				conexao.iniciaServer();

			String Arq = getResource(getMapa(conexao.getPlayer(), nivel));

			marAliado = criaMar(marAliado, Time.Aliado);
			marAliado = leArquivo(Arq, marAliado);
			marAliado = montaMar(marAliado);

			// conexao de criar tabuleiro inimigo
			conexao.SetMar(mapaCSV);
			arqInimigo = conexao.getMarInimigo();

			Bomba bombaAliada = new Bomba(Time.Aliado);
			bombaAliada.setTurno(conexao.getPlayer().equals(host));

			controle = new outController(conexao.getThis(), bombaAliada);

			marInimigo = criaMar(marInimigo, Time.Inimigo);
			marInimigo = leArquivo(getResource(arqInimigo), marInimigo);
			marInimigo = montaMar(marInimigo);
			controle.setMar(marInimigo);

			TelaJogo telaJogo = new TelaJogo(marAliado, marInimigo, conexao.getPlayer());

			bombaAliada.setItensView(telaJogo.getItensPlayer1View(), telaJogo.getLogView());
			controle.setLogView(telaJogo.getLogView());

			Bomba bombaInimiga = new Bomba(Time.Inimigo);
			bombaInimiga.setTurno(conexao.getPlayer().equals(host));
			bombaInimiga.setItensView(telaJogo.getItensPlayer2View(), telaJogo.getLogView());

			InController controleIn = new InController(conexao.getThis(), marAliado, bombaAliada, bombaInimiga);
			controleIn.setLogView(telaJogo.getLogView());

			bombaAliada.setLogView(telaJogo.getLogView());
			bombaInimiga.setLogView(telaJogo.getLogView());

			Thread recebeInput = new Thread(controleIn);
			recebeInput.start();

		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

	}

	public String getMapa(String Player, int nivel) {

		int numPlayer;

		numPlayer = (Player.equals(host)) ? 1 : 2;

		mapaCSV = "marPlayer" + numPlayer + "Level" + nivel + ".csv";

		return mapaCSV;

	}

	public String getResource(String mapaCSV) throws URISyntaxException {
		URL res = Thread.currentThread().getContextClassLoader().getResource(mapaCSV);
		File file = Paths.get(res.toURI()).toFile();
		String arquivo1 = file.getAbsolutePath();
		return arquivo1;
	}

	public Mar criaMar(Mar mar, Time time) {
		mar = new Mar();
		celulasConstrutor = new Celula[10][10];
		mar.setMar(celulasConstrutor, time);

		return mar;
	}

	public Mar leArquivo(String Arq, Mar mar) {

		try { // o try catch fala se estourou o limite ou se há conflito nos navios
			CSVHandling csv = new CSVHandling();
			csv.setDataSource(Arq);
			String comandos[][] = csv.requestCommands();

			for (int i = 0; i < 10; i++) {
				int x = Integer.parseInt(comandos[i][0].substring(0, 1));
				int y = Integer.parseInt(comandos[i][0].substring(2, 3));
				String sentido = comandos[i][1];

				boolean a = true;

				if (comandos[i][2].equals("S")) {
					a = mar.insereSubmarino(x, y, sentido);
				} else if (comandos[i][2].equals("C")) {
					a = mar.insereCruzeiro(x, y, sentido);
				} else if (comandos[i][2].equals("N")) {
					a = mar.insereNavioTanque(x, y, sentido);
				} else if (comandos[i][2].equals("P")) {
					a = mar.inserePortaAviao(x, y, sentido);
				} else if (comandos[i][2].equals("A")) {
					a = mar.insereArmadilha(x, y);
				} else if (comandos[i][2].equals("B")) {
					a = mar.insereBauDoTesouro(x, y);
				}

				if (!a)
					throw new Exception("Há conflitos entre navios");
			}
		} catch (Exception erro) {
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
					mar.celulaMar[i][j].setControle(controle);
					mar.celulaMar[i][j].setCelulaRevelada(false);
				}
			}
		}
		return mar;
	}
}
