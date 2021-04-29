package mc322.lab05;
 

public class AppDama {
	
	public static String executaJogo(String s) {
		String EstadoTabuleiro = "";

		CSVReader csv = new CSVReader();
		csv.setDataSource(s);
		String commands[] = csv.requestCommands(); 

		// declaro meu jogo aberto
		Tabuleiro Tab = new Tabuleiro();

		for (int i = 0; i < commands.length; i++) { 
			commands[i] = commands[i].replace("{","");
			commands[i] = commands[i].replace("}","");
			commands[i] = commands[i].replace(" ","");
			
			Tab.solicitaMovimento(commands[i]);
			
			//EstadoTabuleiro = Tab.imprimirTabuleiro();
		}

		return (EstadoTabuleiro);

	}
 
	public static void main(String[] args) {
		 
		
		Tabuleiro tab = new Tabuleiro();
		tab.setTabuleiro();
		tab.imprimirTabuleiro();
		
		
		tab.solicitaMovimento("c2:e4");
		tab.imprimirTabuleiro();

		
		
		
	}  
}