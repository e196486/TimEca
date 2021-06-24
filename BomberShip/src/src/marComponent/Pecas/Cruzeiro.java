package marComponent.Pecas;

import marComponent.Celula.Celula;
import marComponent.Celula.Peca;

public class Cruzeiro extends Navio{
	protected Celula Cruzeiro[] = new Peca[3];
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
	
	public boolean navioDestruido() {
		if (Cruzeiro[0].isCelulaDestruida()&&Cruzeiro[1].isCelulaDestruida()&&Cruzeiro[2].isCelulaDestruida())
			return true;
		return false;
	}
}
