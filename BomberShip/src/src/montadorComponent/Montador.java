package montadorComponent;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

import conexaoComponent.Conexao;
import conexaoComponent.IBuildConexao;
import controleComponent.*;
import marComponent.Celula.*;
import marComponent.Mar.IBuildMar;
import marComponent.Mar.Mar;
import viewComponent.TelaJogo;

public class Montador {

	IBuildConexao conexao;
	private IBuildMar marAliado;
	private IBuildMar marInimigo;

	private outController controle;

	private String arqInimigo;
	private final String host = "Host";

	public Montador(String ip, int porta) {

		try {
			conexao = new Conexao(ip, porta);

			if (!conexao.conecta())
				conexao.iniciaServer();

			String Arq = getMapa(conexao.getPlayer());

			marAliado = criaMar(Time.Aliado);
			marAliado = leArquivo(Arq, marAliado.getThis());
			marAliado = montaMar(marAliado.getThis());

			// conexao de criar tabuleiro inimigo
			conexao.SetMar(Arq);
			arqInimigo = conexao.getMarInimigo();

			controle = new outController(conexao.getThis());

			marInimigo = criaMar(Time.Inimigo);
			marInimigo = leArquivo(arqInimigo, marInimigo.getThis());
			marInimigo = montaMar(marInimigo.getThis());

			new TelaJogo(marAliado.getThis(), marInimigo.getThis(), conexao.getPlayer());

			Thread recebeInput = new Thread(new InController(conexao.getThis(), marAliado.getThis()));
			recebeInput.start();

		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

	}

	public String getMapa(String Player) throws URISyntaxException {

		// TODO : transformar

		int numPlayer;
		int nivel = 1;

		numPlayer = (Player.equals(host)) ? 1 : 2;

		String mapaCSV = "marPlayer" + numPlayer + "Level" + nivel + ".csv";

		URL res = Thread.currentThread().getContextClassLoader().getResource(mapaCSV);
		File file = Paths.get(res.toURI()).toFile();
		String arquivo1 = file.getAbsolutePath();
		return arquivo1;

	}

	public Mar criaMar(Time time) {
		Mar mar = new Mar();
		// est� estourando o numero de celulas no teste
		// eu n�o entendi porque estava estourando antes, mas acredito que esteja certo agora
		Celula[][] celulas = new Celula[10][10];
		mar.setMar(celulas, time);

		return mar;
	}

	public Mar leArquivo(String Arq, Mar mar) {

		try { // o try catch fala se estourou o limite ou se h� conflito nos navios
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
					throw new Exception("H� conflitos entre navios");
			}
		} catch (Exception erro) {
			System.err.println("Erro:" + erro.getMessage() + "\nInsira um csv v�lido!");
			erro.printStackTrace();
		}

		return mar;
	}

	// coloca �gua em todas as c�lulas vazias.
	public Mar montaMar(Mar mar) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (mar.getTipoCelula(i, j) == '~') {
					Agua water = new Agua(i, j, '~');
					try {
						mar.insereCelula(water);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				if (mar.time == Time.Inimigo)
					mar.celulaMar[i][j].setControle(controle);

			}
		}
		return mar;
	}
}
