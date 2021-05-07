package mc322.lab06;

public class Caverna {
	
	Sala cav[][] = new Sala[4][4];
	
	public void criaCaverna() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				Sala sala = new Sala();
				cav[i][j] = sala;
			}
		}	
	}
	
	public String imprimeEstado() {
		String Estado = "";
		for (int i = 0; i < 4; i++) {
			Estado += i+1 + " ";
			for (int j = 0; j < 4; j++) {
				Estado += cav[i][j].P + " ";
			}
			Estado += "\n";
		}
		Estado += "  1 2 3 4";
		return Estado;
	}
	
	public void insereComponente(Componente C) {
		boolean erro = cav[C.linha][C.coluna].insereC(C);
		if (!erro)
			System.out.println("Erro");
	}
}