package marComponent.Pecas;

import marComponent.Celula.Celula;
import marComponent.Celula.Peca;

public class PortaAviao extends Navio{
	protected Celula PortaAviao[] = new Peca[5];
	protected char sentido;
	protected int tamanho = 5;
	
	public PortaAviao (Celula peca1, Celula peca2, Celula peca3, Celula peca4, Celula peca5) {
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
