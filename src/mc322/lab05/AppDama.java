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
		
		 
		tab.solicitaMovimento("e6:d5");
		tab.imprimirTabuleiro();   
		tab.solicitaMovimento("d3:c4");
		tab.imprimirTabuleiro();    
		tab.solicitaMovimento("c4:e6");
		tab.imprimirTabuleiro(); 
		/*tab.solicitaMovimento("e2:f3");
		tab.imprimirTabuleiro();   
		tab.solicitaMovimento("f3:g4");
		tab.imprimirTabuleiro(); 
		tab.solicitaMovimento("f1:e2");
		tab.imprimirTabuleiro(); 
		tab.solicitaMovimento("e2:f3");
		tab.imprimirTabuleiro(); 
		tab.solicitaMovimento("c4:e2");
		tab.imprimirTabuleiro(); 
		tab.solicitaMovimento("e2:f1");
		tab.imprimirTabuleiro();
		tab.solicitaMovimento("b3:c4");
		tab.imprimirTabuleiro(); 
		tab.solicitaMovimento("d1:e2");
		tab.imprimirTabuleiro(); 
		tab.solicitaMovimento("f1:d3");
		tab.imprimirTabuleiro(); 
		tab.solicitaMovimento("d3:b5");
		tab.imprimirTabuleiro();
		tab.solicitaMovimento("d1:g4");
		tab.imprimirTabuleiro();*/
		
		
	}  
}