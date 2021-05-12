package mc322.lab06;

public class MontadorCaverna {
	
	
	public MontadorCaverna(String arq) {
		
		Componente vetorComponentes[] = leArquivo(arq); 
		
		Caverna cav = new Caverna();
		cav.criaCaverna();
		
		for (int i=0; i<16; i++) 
			cav.insereComponente(vetorComponentes[i]);
		
		System.out.println(cav.imprimeEstado());
	}
	
	
	public Componente[] leArquivo(String arq) {
		
		Componente componentes[] = new Componente[16];
		
		CSVHandling csv = new CSVHandling();
		csv.setDataSource(arq);
		String comandos[][] = csv.requestCommands();
		
		for (int i=0; i<16; i++) {
			if (comandos[i][1] == "P")
				componentes[i] = new Heroi (comandos[i]);
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
