package celulas;

import bomba.Bomba;


public class Armadilha extends Celula{
	public Armadilha(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
		celulaRevelada = false;
		//imagem =
	}
	
	public void explode(Bomba bomba) {
		setCelulaRevelada(true);
		if (bomba.getDica()) {
			dicaIlumina();
		}
		// perde pontos
	}
}
