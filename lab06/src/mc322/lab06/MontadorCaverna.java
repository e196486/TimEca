package mc322.lab06;

public class MontadorCaverna {
	Caverna cave;
	StatusJogo status;
	
	public MontadorCaverna(String arq) {
		
		Componente vetorComponentes[] = leArquivo(arq); 
		
		status = new StatusJogo();
		cave = new Caverna(status);
	
		for (int i=0; i<vetorComponentes.length; i++) {
			cave.insereComponente(vetorComponentes[i]);
		}
		cave.imprimeEstado();
	}
	
	
	public Componente[] leArquivo(String arq) {
		
		Componente componentes[] = new Componente[16];
		
		CSVHandling csv = new CSVHandling();
		csv.setDataSource(arq);
		String comandos[][] = csv.requestCommands();
		
		
		//O montador instancia o componente na classe certa.
		for (int i=0; i<16; i++) {
			if (comandos[i][1] == "P")
				componentes[i] = new Heroi (comandos[i], status, cave);
			else if (comandos[i][1] == "B")
				componentes[i] = new Buraco (comandos[i]);
			else if (comandos[i][1] == "W")
				componentes[i] = new Wumpus (comandos[i]);
			else if (comandos[i][1] == "O")
				componentes[i] = new Ouro (comandos[i]);
			else
				componentes[i] = new Componente (comandos[i]);
		}
		
		return componentes ;
		
	}

}
