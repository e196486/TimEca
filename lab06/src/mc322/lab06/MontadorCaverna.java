package mc322.lab06;

public class MontadorCaverna {
	Caverna cave ;
	StatusJogo status; 
	
	
	public MontadorCaverna(String arq) {
		status = new StatusJogo();
		cave = new Caverna(status);
		Componente peca[] = leArquivo(arq); 
		
		
		for (int i=0; i<16; i++)  
			cave.insereComponente(peca[i]);
		
		
	}
	
	
	public Componente[] leArquivo(String arq) {
		
		Componente componentes[] = new Componente[16];
		
		CSVHandling csv = new CSVHandling();
		csv.setDataSource(arq);
		String comandos[][] = csv.requestCommands();
		
		
		componentes[0] = new Heroi(comandos[0], status, cave);
		
		for (int i=1; i<16; i++) 
				componentes[i] = new Componente (comandos[i]);
		
		
		return componentes ;
		
	}

}
