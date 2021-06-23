package marComponent.Pecas;

import marComponent.Celula.Celula;
import marComponent.Celula.Navio;

public class Submarino {
	protected Celula[] submarino = new Navio[2];
	protected char sentido;
	protected final int tamanho = 2;
	
	public Submarino (Celula peca1, Celula peca2) { 
		submarino[0] = peca1;
		submarino[1] = peca2;
	}
	public int getTamanho() {
		return tamanho; 
	}
}
