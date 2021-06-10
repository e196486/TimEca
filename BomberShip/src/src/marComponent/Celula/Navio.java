package marComponent.Celula;

import controleComponent.Bomba;

public class Navio extends Celula{
	 
	private static final long serialVersionUID = -137272376822387627L;

	public Navio(int linha, int coluna, char tipo) {
		this.linha = linha;
		this.coluna = coluna;
		celulaRevelada = false;
		this.tipo = tipo; 
	}

	public void explode(Bomba bomba) {
		setCelulaRevelada(true);
		//imagem = explosão 
		if (bomba.getDica()) {
			dicaIlumina();
		}
		// ganha pontos
	}
}
