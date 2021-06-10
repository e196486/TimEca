package montadorComponent;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

import conexaoComponent.Conexao;
import controleComponent.InController;
import controleComponent.Time;
import controleComponent.outController;
import main.TelaJogo;
import marComponent.Celula.Agua;
import marComponent.Celula.Celula;
import marComponent.Mar.Mar;

public class Montador {

	Conexao conexao;
	private Mar marAliado;
	private Mar marInimigo;
	private Celula[][] celulasConstrutor;

	private outController controle;

	private String arqInimigo;
	private final String host = "Host";

	private final String marPlayer1Level1 = "marPlayer1Level1.csv";

	public Montador(String ip, int porta) {

		try {
			conexao = new Conexao(ip, porta);

			if (!conexao.conecta())
				conexao.iniciaServer();

			String Arq = getMapa(conexao.Player);

			marAliado = criaMar(marAliado, Time.Aliado);
			marAliado = leArquivo(Arq, marAliado);
			marAliado = montaMar(marAliado);

			// conexao de criar tabuleiro inimigo
			conexao.SetMar(Arq);
			arqInimigo = conexao.getMarInimigo();

			controle = new outController(conexao);

			marInimigo = criaMar(marInimigo, Time.Inimigo);
			marInimigo = leArquivo(arqInimigo, marInimigo);
			marInimigo = montaMar(marInimigo);

			new TelaJogo(marAliado, marInimigo, conexao.Player);

			Thread recebeInput = new Thread(new InController(conexao, marAliado));
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

	public Mar criaMar(Mar mar, Time time) {
		mar = new Mar();
		// está estourando o numero de celulas no teste
		celulasConstrutor = new Celula[11][11];
		mar.setMar(celulasConstrutor, time);

		return mar;
	}

	public Mar leArquivo(String Arq, Mar mar) {

		try {
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
					System.out.println("Há conflito entre os navios!");
			}
		} catch (Exception erro) {
			System.err.println("Erro:" + erro.getMessage());
			System.out.println("Insira um csv válido!");
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
					mar.insereCelula(water);
				}

				if (mar.time == Time.Inimigo)
					mar.celulaMar[i][j].setControle(controle);

			}
		}
		return mar;
	}
}
