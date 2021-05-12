package mc322.lab06;

public class AppMundoWumpus {
	
	public static void main(String[] args) {
		String Arquivo = "C:\\Users\\henri\\Documents\\teste\\Arq001.csv"; //criei um arquivo teste, ainda não adicionei na pasta.
		MontadorCaverna M = new MontadorCaverna(Arquivo);
		M.cav.retiraOuro(4, 3);
		M.cav.imprimeEstado();
	}

}
