package mc322.lab06;

public class MontadorCaverna {
	
	
	public MontadorCaverna(String arq) {
		
		Coordenada movimentos[] = leArquivo(arq); 
		
		new Caverna().criaCaverna(movimentos);
	}
	
	
	public Coordenada[] leArquivo(String arq) {
		
		Coordenada coordenadas[] = new Coordenada[16];
		
		CSVHandling csv = new CSVHandling();
		csv.setDataSource(arq);
		String comandos[][] = csv.requestCommands();
		
		for (int i=0; i<16; i++) 
				coordenadas[i] = new Coordenada (comandos[i]);
		
		
		return coordenadas ;
		
	}

}