package marComponent.Celula;

import javax.swing.ImageIcon;

public class Agua extends Celula{
	 
	private static final long serialVersionUID = 7753065336797036453L;

	public Agua(int linha, int coluna, char tipo) {
		this.linha = linha;
		this.coluna = coluna;
		celulaRevelada = false;
		this.tipo = tipo;
		//imagem = agua normal
	}
	
	public char explode( ) {
		setCelulaRevelada(true);
		this.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/imgSplash.png")).getImage()
				.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH)));
		return tipo;
	}
}
