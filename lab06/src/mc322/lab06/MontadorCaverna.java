package mc322.lab06;

public class MontadorCaverna {
	
	
	public MontadorCaverna(String arq) {
		
		Componente movimentos[] = leArquivo(arq); 
		
		Caverna cav = new Caverna();
		
		for (int i=0; i<16; i++) 
			cav.insereComponente(movimentos[i]);
	}
	
	
	public Componente[] leArquivo(String arq) {
		
		Componente componentes[] = new Componente[16];
		
		CSVHandling csv = new CSVHandling();
		csv.setDataSource(arq);
		String comandos[][] = csv.requestCommands();
		
		for (int i=0; i<16; i++) 
				componentes[i] = new Componente (comandos[i]);
		
		
		return componentes ;
		
	}

}
