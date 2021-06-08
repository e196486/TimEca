package pecas;

import celulas.Navio;

public class Cruzeiro {
	protected Navio Cruzeiro[];
	protected char sentido;
	protected int tamanho = 3;
	
	public Cruzeiro (Navio peca1, Navio peca2, Navio peca3) {
		Cruzeiro[0] = peca1;
		Cruzeiro[1] = peca2;
		Cruzeiro[2] = peca3;
	}
	public int getTamanho() {
		return tamanho; 
	}
}
