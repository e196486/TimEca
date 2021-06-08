package celulas;

import bomba.Bomba;

public class Agua extends Celula{
	public Agua(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
		celulaRevelada = false;
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
