package marComponent.Celula;
 

import javax.swing.ImageIcon;

import marComponent.Pecas.Navio; 

public class Peca extends Celula {

	private static final long serialVersionUID = -137272376822387627L;
	
	private Navio navio;

	public Peca(int linha, int coluna, char tipo) {
		this.linha = linha;
		this.coluna = coluna;
		celulaRevelada = false;
		this.tipo = tipo;
	}

	public char explode() {
		setCelulaRevelada(true);
		this.setText(""); 
		this.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/BombaExplodida.png")).getImage()
				.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
		return tipo;
	}

	public char getTipo() {
		return tipo;
	}
	
	public void setNavio (Navio navio) {
		this.navio = navio;
	}
}
