package pecas;

import celulas.Navio;

public class PortaAviao {
	protected Navio PortaAviao[] = new Navio[5];
	protected char sentido;
	protected int tamanho = 5;
	
	public PortaAviao (Navio peca1, Navio peca2, Navio peca3, Navio peca4, Navio peca5) {
		PortaAviao[0] = peca1;
		PortaAviao[1] = peca2;
		PortaAviao[2] = peca3;
		PortaAviao[3] = peca4;
		PortaAviao[4] = peca5;
	}
	public int getTamanho() {
		return tamanho; 
	}
}
