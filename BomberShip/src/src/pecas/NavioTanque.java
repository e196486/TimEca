package pecas;

import celulas.Navio;

public class NavioTanque {
	protected Navio[] NavioTanque = new Navio[4];
	protected char sentido;
	protected int tamanho = 4;
	
	public NavioTanque (Navio peca1, Navio peca2, Navio peca3, Navio peca4) {
		NavioTanque[0] = peca1;
		NavioTanque[1] = peca2;
		NavioTanque[2] = peca3;
		NavioTanque[3] = peca4;
	}
	public int getTamanho() {
		return tamanho; 
	}
}
