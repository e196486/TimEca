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
		Celula[][] celulas = new Celula[11][11];
		celulasConstrutor = celulas;
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
				boolean a;
				if (comandos[i][2] == "S") {
					a = marConstrutor.insereSubmarino(x, y, sentido);
					if (!a)
						System.out.println("Há conflito entre os navios!");
				}
				else if (comandos[i][2] == "C") {
					a = marConstrutor.insereCruzeiro(x, y, sentido);
					if (!a)
						System.out.println("Há conflito entre os navios!");
				}
				else if (comandos[i][2] == "N") {
					a = marConstrutor.insereNavioTanque(x, y, sentido);
					if (!a)
						System.out.println("Há conflito entre os navios!");
				}
				else if (comandos[i][2] == "P") {
					a = marConstrutor.inserePortaAviao(x, y, sentido);
					if (!a)
						System.out.println("Há conflito entre os navios!");
				}
				else if (comandos[i][2] == "A") {
					a = marConstrutor.insereArmadilha(x, y);
					if (!a)
						System.out.println("Há conflito entre os navios!");
				}
				else if (comandos[i][2] == "B") {
					a = marConstrutor.insereBauDoTesouro(x, y);
					if (!a)
						System.out.println("Há conflito entre os navios!");
				}
			}
		} catch (Exception erro) {
				System.err.println("Erro:"+erro.getMessage());
				System.out.println("Insira um csv válido!");
		}
	}
	
	// coloca Água em todas as células vazias.
	public void montaMar() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (celulasConstrutor[i][j] == null) {
					Agua water = new Agua(i, j);
					marConstrutor.insereCelula(water);
				}
			}
		}
	}
}
