package marComponent.Pecas;

import marComponent.Celula.Celula;
import marComponent.Celula.Peca;

public class Submarino extends Navio{
	protected Celula[] submarino = new Peca[2];
	protected char sentido;
	protected final int tamanho = 2;
	
	public Submarino (Celula peca1, Celula peca2) { 
		submarino[0] = peca1;
		submarino[1] = peca2;
	}
	public int getTamanho() {
		return tamanho; 
	}
	
	public boolean navioDestruido() {
		if (submarino[0].isCelulaDestruida()&&submarino[1].isCelulaDestruida())
			return true;
		return false;
	}
}
