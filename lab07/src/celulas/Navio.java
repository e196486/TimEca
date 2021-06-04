package celulas;

import bomba.Bomba;

public class Navio extends Celula{
	
	public Navio(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
		celulaRevelada = false;
		//imagem =
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
