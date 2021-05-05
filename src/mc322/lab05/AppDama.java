package mc322.lab05;

public class AppDama{
	public static String[] executaJogo(String entrada, String saida) {
		CSVReader csv = new CSVReader();
		csv.setDataSource(entrada);
		String commands[] = csv.requestCommands();		
		
		Tabuleiro tab = new Tabuleiro();
		tab.setTabuleiro();
		
		String estados[] = new String[commands.length];
		
		System.out.println("Tabuleiro inicial:\n" + tab.imprimirTabuleiro());
		
		for (int k = 0; k < commands.length; k++) {
			tab.solicitaMovimento(commands[k]);
			estados[k] = tab.imprimirTabuleiro();
			System.out.println("Source: " + commands[k].substring(0, 2));
			System.out.println("Target: " + commands[k].substring(3, 5)+"\n");
			System.out.println(tab.imprimirTabuleiro());
		}
		
		CSVHandling hand = new CSVHandling();
		hand.setDataExport(saida);
		
		String ultimo[] = new String[64];
		int count = 0;
		
		for (int i = 1; i < 9; i++) {
			for (int j = 1; j < 9; j++) {
				ultimo[count] = tab.tabuleiro[j][i].leitura();
				count++;
			}
		}
		
		hand.exportState(ultimo);
		
		return estados;
	}
	
	public static void main(String[] args) {
		executaJogo("C:\\Users\\henri\\OneDrive\\Documentos\\Lab05\\src\\mc322\\lab05\\arq001.csv","C:\\Users\\henri\\OneDrive\\Documentos\\Lab05\\src\\mc322\\lab05\\arq002.csv");
	}
}