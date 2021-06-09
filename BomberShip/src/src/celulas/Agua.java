package celulas;

import bomba.Bomba;

public class Agua extends Celula{
	public Agua(int linha, int coluna, char tipo) {
		this.linha = linha;
		this.coluna = coluna;
		celulaRevelada = false;
		this.tipo = tipo;
		//imagem = agua normal
	}
	
	public void explode(Bomba bomba) {
		setCelulaRevelada(true);
		//imagem = splash
		if (bomba.getDica()) {
			dicaIlumina();
		}
			
	}
}
