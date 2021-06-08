package mar;

import comunicacao.*;
import celulas.*;
import main.*;
import mc322.lab06.CSVHandling;
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

	}
	
	public void criaMar() {
		marConstrutor = new Mar();
		Celula[][] celulas = new Celula[10][10];
		celulasConstrutor = celulas;
		marConstrutor.setMar(celulasConstrutor);
	}
	
	public void leArquivo(String Arq) {
		
		CSVHandling csv = new CSVHandling();
		csv.setDataSource(Arq);
		String comandos[][] = csv.requestCommands();
		
		for (int i = 0; i < 2; i++) {
			int x = Integer.parseInt(comandos[i][0].substring(0, 1));
			int y = Integer.parseInt(comandos[i][0].substring(2, 3));
			String sentido = comandos[i][1];
			if (comandos[i][2] == "S") {
				marConstrutor.insereSubmarino(x, y, sentido);
			/*if (comandos[i][1] == "h") {
				Navio n1 = new Navio(x, y);
				marConstrutor.inserePeca(n1);
				Navio n2 = new Navio(x, y+1);
				marConstrutor.inserePeca(n2);
				Submarino sub = new Submarino(n1, n2);
				marConstrutor.setSubmarino(sub);
			} else {
				Navio n1 = new Navio(x, y);
				marConstrutor.inserePeca(n1);
				Navio n2 = new Navio(x+1, y);
				marConstrutor.inserePeca(n2);
				Submarino sub = new Submarino(n1, n2);
				marConstrutor.setSubmarino(sub);
			}*/
		}
	}
}
