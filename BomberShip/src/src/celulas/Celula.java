package celulas;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import bomba.Bomba;

public class Celula extends JButton implements ICelulaPropriedades,ActionListener{
	
	private static final long serialVersionUID = -4497235678407832554L;
	protected Image imagem;
	protected int linha, coluna;
	protected boolean celulaRevelada;
	public Celula cima,
					baixo,
					esquerda,
					direita;
	public char tipo; 
	
	public Celula () {
		super();
		this.setBackground(new Color(213, 241, 209));
		this.setOpaque(true);
		this.setBorderPainted(true);
		//this.setSize(10, 10);
	}
	
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
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
