package marComponent.Celula;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import controleComponent.IMarListener;
import controleComponent.Time;
import controleComponent.outController;
import marComponent.Pecas.Navio;

public class Celula extends JButton implements ICelulaRefactor, ActionListener {

	private static final long serialVersionUID = -4497235678407832554L;
	protected ImageIcon imagem;
	protected int linha, coluna;
	protected boolean celulaRevelada = false;
	protected boolean celulaDestruida = false;
	public char tipo;

	IMarListener controle;

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

	public char explode() {
		return tipo;
	}

	public boolean isCelulaRevelada() {
		return celulaRevelada;
	}
	public void setCelulaRevelada(boolean celulaRevelada) {
		this.celulaRevelada = celulaRevelada;

		if (!celulaRevelada) {
			setIcon(null);
			setText(null);
		} else {
			if ((tipo == 'P') || (tipo == 'N') || (tipo == 'C') || (tipo == 'S') || (tipo == '~'))
				setText(tipo + "");
			else
				setIcon(imagem);

		}
	}
	public boolean isCelulaDestruida() {
		return celulaDestruida;
	}
	public void setCelulaDestruida(boolean celulaDestruida) {
		this.celulaDestruida = celulaDestruida;
	}

	public void dicaIlumina() {

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

	public void setControle(outController control) {
		this.controle = control;
		addActionListener(this);
		this.setEnabled(true);
	}

	public void actionPerformed(ActionEvent e) {
		controle.celulaAcionada(linha, coluna);

	}

	public char getTipo() {
		return tipo;
	}
	
	public Navio getNavio() {
		return null;
	}

}
