package celulas;

import bomba.Bomba;

public class Navio extends Celula{
	
	
	
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
