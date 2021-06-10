package celulas;

import bomba.Bomba;


public class Armadilha extends Celula{
 
	private static final long serialVersionUID = -2852903771055441124L;

	public Armadilha(int linha, int coluna, char tipo) {
		this.linha = linha;
		this.coluna = coluna;
		celulaRevelada = false;
		this.tipo = tipo;
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
