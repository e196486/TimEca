package marComponent.Pecas;

import marComponent.Celula.Celula;
import marComponent.Celula.Peca;

public class NavioTanque extends Navio{
	protected Celula[] NavioTanque = new Peca[4];
	protected char sentido;
	protected int tamanho = 4;
	
	public NavioTanque (Celula peca1, Celula peca2, Celula peca3, Celula peca4) {
		NavioTanque[0] = peca1;
		NavioTanque[1] = peca2;
		NavioTanque[2] = peca3;
		NavioTanque[3] = peca4;
	}
	public int getTamanho() {
		return tamanho; 
	}
	
	public boolean navioDestruido() {
		if (NavioTanque[0].isCelulaDestruida()&&NavioTanque[1].isCelulaDestruida()&&NavioTanque[2].isCelulaDestruida()&&NavioTanque[3].isCelulaDestruida())
			return true;
		return false;
	}
}
