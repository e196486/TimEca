package celulas;

import java.awt.Color;
import java.awt.Font; 
import javax.swing.ImageIcon;
import javax.swing.JButton;

import bomba.Bomba;
import comunicacao.outController;

public class Celula extends JButton implements ICelulaPropriedades {

	private static final long serialVersionUID = -4497235678407832554L;
	protected ImageIcon imagem;
	protected int linha, coluna;
	protected boolean celulaRevelada;
	public Celula cima, baixo, esquerda, direita;
	public char tipo; 

	public Celula() {
		super();
		this.setOpaque(true);
		this.setBorderPainted(true);
		this.setEnabled(false);
		this.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15)); // Depois tirar para trocar para imagens
		
		
	}

	public ImageIcon getImage() {
		return imagem;
	}

	public void SetImage(ImageIcon img) {
		imagem = img;
		this.setIcon(img);
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

	public void setTime(Time time) { 
		Color cor = (time == Time.Aliado) ? new Color(223, 233, 247) : new Color(170, 202, 250);
		this.setBackground(cor); 

	}

	public void setControle(outController controle) { 
		System.out.println("controle declarado no time inimigo"); 
		addActionListener(controle);
		this.setEnabled(true);
	}
}
