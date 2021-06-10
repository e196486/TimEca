package celulas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import bomba.Bomba;

public class Celula extends JButton implements ICelulaPropriedades, ActionListener {
	

	private static final long serialVersionUID = -4497235678407832554L;
	protected ImageIcon imagem;
	protected int linha, coluna;
	protected boolean celulaRevelada;
	public Celula cima, baixo, esquerda, direita;
	public char tipo;
	private Time time;

	public Celula() {
		super();
		this.setOpaque(true);
		this.setBorderPainted(true);
		this.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15)); // Depois tirar para trocar para imagens

		addActionListener(this);
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

		this.time = time;

		Color cor = (time == Time.Aliado) ? new Color(223, 233, 247) : new Color(170, 202, 250);
		this.setBackground(cor);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (time == Time.Aliado)
			System.out.println("você não pode mexer no seu tabuleiro");
		
		else {
					
		}

	}
}
