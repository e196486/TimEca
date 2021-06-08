package pecas;

import celulas.Navio;

public class Submarino {
	protected Navio submarino[];
	protected char sentido;
	protected int tamanho = 2;
	
	public Submarino (Navio peca1, Navio peca2) {
		submarino[0] = peca1;
		submarino[1] = peca2;
	}
	public int getTamanho() {
		return tamanho; 
	}
}
