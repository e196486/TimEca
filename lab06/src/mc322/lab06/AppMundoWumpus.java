package mc322.lab06;

public class AppMundoWumpus {
	
	public static void main(String[] args) {
		String Arquivo = "C:\\Users\\henri\\Documents\\teste\\Arq001.csv";
		MontadorCaverna M = new MontadorCaverna(Arquivo);
		M.cave.retiraOuro(4, 3);
		M.cave.imprimeEstado();
		//System.out.println(M.cave.cave[1][1].Heroi.componente);
		M.cave.solicitaMovimento(M.cave.cave[1][1].Heroi, 2, 1);
		M.cave.solicitaMovimento(M.cave.cave[2][1].Heroi, 2, 2);
		M.cave.solicitaMovimento(M.cave.cave[2][2].Heroi, 2, 3);
		M.cave.solicitaMovimento(M.cave.cave[2][3].Heroi, 3, 3);
		M.cave.solicitaMovimento(M.cave.cave[3][3].Heroi, 3, 2);
		M.cave.imprimeEstado();
	}

}
