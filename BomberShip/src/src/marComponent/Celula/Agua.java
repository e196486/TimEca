package marComponent.Celula;

import controleComponent.Bomba;

public class Agua extends Celula{
	 
	private static final long serialVersionUID = 7753065336797036453L;

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
