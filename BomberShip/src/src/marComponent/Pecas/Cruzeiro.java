package marComponent.Pecas;

import marComponent.Celula.Celula;
import marComponent.Celula.Navio;

public class Cruzeiro {
	protected Celula Cruzeiro[] = new Navio[3];
	protected char sentido;
	protected int tamanho = 3;
	
	public Cruzeiro (Celula peca1, Celula peca2, Celula peca3) {
		Cruzeiro[0] = peca1;
		Cruzeiro[1] = peca2;
		Cruzeiro[2] = peca3;
	}
	public int getTamanho() {
		return tamanho; 
	}
}
