package mar;

import comunicacao.*;
import celulas.*;
import main.*;
import mar.CSVHandling;
import pecas.Submarino;

public class Construtor {

	Conexao conexao;
	private Mar marConstrutor;
	private Celula[][] celulasConstrutor;

	public Construtor(String ip, int porta, String Arq) {

		conexao = new Conexao(ip, porta);

		if (!conexao.conecta())
			conexao.iniciaServer();

		new TelaJogo();

		criaMar();

		leArquivo(Arq);

		montaMar();

	}

	public void criaMar() {
		marConstrutor = new Mar();
		// está estourando o numero de celulas no teste
		celulasConstrutor = new Celula[11][11];
		marConstrutor.setMar(celulasConstrutor);
	}

	public void leArquivo(String Arq) {

		try {
			CSVHandling csv = new CSVHandling();
			csv.setDataSource(Arq);
			String comandos[][] = csv.requestCommands();

			for (int i = 0; i < 10; i++) {
				int x = Integer.parseInt(comandos[i][0].substring(0, 1));
				int y = Integer.parseInt(comandos[i][0].substring(2, 3));
				String sentido = comandos[i][1];
				System.out.println(comandos[i][2]);
				boolean a = true;
				if (comandos[i][2].equals("S")) {
					a = marConstrutor.insereSubmarino(x, y, sentido);
				} else if (comandos[i][2].equals("C")) {
					a = marConstrutor.insereCruzeiro(x, y, sentido);
					System.out.println("entrou aq x: " + x + " y: " + y + " sentido: >" + sentido + "<");
				} else if (comandos[i][2].equals("N")) {
					a = marConstrutor.insereNavioTanque(x, y, sentido);
				} else if (comandos[i][2].equals("P")) {
					a = marConstrutor.inserePortaAviao(x, y, sentido);
				} else if (comandos[i][2].equals("A")) {
					a = marConstrutor.insereArmadilha(x, y);
				} else if (comandos[i][2].equals("B")) {
					a = marConstrutor.insereBauDoTesouro(x, y);
				}

				if (!a)
					System.out.println("Há conflito entre os navios!");
			}
		} catch (Exception erro) {
			System.err.println("Erro:" + erro.getMessage());
			System.out.println("Insira um csv válido!");
			erro.printStackTrace();
		}
	}

	// coloca Água em todas as células vazias.
	public void montaMar() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (marConstrutor.getTipoCelula(i, j) == '-') {
					Agua water = new Agua(i, j, '~');
					marConstrutor.insereCelula(water);
				}

				/* Teste de impressão EXCLUIR DEPOIS!! */
				System.out.print(marConstrutor.getTipoCelula(i, j) + " ");

			}

			System.out.println(" ");
			/* fim do teste de impressão EXCLUIR sem o fecha chaves do for */
		}
	}
}
