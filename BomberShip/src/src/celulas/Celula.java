package celulas;

import java.awt.Image;

import bomba.Bomba;

public class Celula implements ICelulaPropriedades{
	protected Image imagem;
	protected int linha, coluna;
	protected boolean celulaRevelada;
	public Celula cima,
					baixo,
					esquerda,
					direita;
	public char tipo; 
	
	public Image getImage() {
		return imagem;
	}
	public void explode(Bomba bomba) {
		
	}
	public boolean isCelulaRevelada() {
		return celulaRevelada;
	}
	public void setCelulaRevelada(boolean celulaRevelada) {
		this.celulaRevelada = celulaRevelada;
	}
	public void dicaIlumina() {
		cima.setCelulaRevelada(true);
		baixo.setCelulaRevelada(true);
		esquerda.setCelulaRevelada(true);
		direita.setCelulaRevelada(true);
	}
	public int getLinha() {
		return linha;
	}
	public int getColuna() {
		return coluna;
	}
}
