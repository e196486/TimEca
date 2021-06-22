package marComponent.Celula;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import controleComponent.Bomba;
import controleComponent.IMarListener;
import controleComponent.Time;
import controleComponent.outController;

public class Celula extends JButton implements ICelulaPropriedades, IMarRefactor, ActionListener  {

	private static final long serialVersionUID = -4497235678407832554L;
	protected ImageIcon imagem;
	protected int linha, coluna;
	protected boolean celulaRevelada;
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

	public void explode(Bomba bomba) {
		//this.setIcon(img);
	}

	public boolean isCelulaRevelada() {
		return celulaRevelada;
	}

	public void setCelulaRevelada(boolean celulaRevelada) {
		this.celulaRevelada = celulaRevelada;
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
}
