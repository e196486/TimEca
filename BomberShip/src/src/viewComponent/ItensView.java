package viewComponent;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ItensView extends JPanel implements IItemRefactor {

	private static final long serialVersionUID = 1L;
	
	JTextField campoPontos;
	JTextField campoDicas;
	JTextField campoMunicao;
	
	public ItensView() {
		
	}

	public JPanel criaItensView(String Player) {

		this.setPreferredSize(new Dimension(450, 50));
		this.setBorder(new EmptyBorder(10, 5, 10, 5));
		GridLayout itensLayout = new GridLayout(0, 6);
		itensLayout.setHgap(10);
		itensLayout.setVgap(10);
		this.setLayout(itensLayout);

		JLabel lblPontos = new JLabel("Pontos");
		lblPontos.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		this.add(lblPontos);

		campoPontos = new JTextField("1");
		campoPontos.setBackground(Color.white);
		campoPontos.setEditable(false);
		campoPontos.setBounds(1, 1, 50, 50);
		this.add(campoPontos);

		JLabel lblDicas = new JLabel("Dicas");
		lblDicas.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		this.add(lblDicas);

		campoDicas = new JTextField("1");
		campoDicas.setBackground(Color.white);
		campoDicas.setEditable(false);
		this.add(campoDicas);

		JLabel lblMunicao = new JLabel("Munição");
		lblMunicao.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		this.add(lblMunicao);

		campoMunicao = new JTextField("1");
		campoMunicao.setBackground(Color.white);
		campoMunicao.setEditable(false);
		this.add(campoMunicao);

		return this;

	}

	public void setPontos(int Pontos) { 
		campoPontos.setText(Pontos + "");
	}

	public void setMunicao(int Municao) {
		campoMunicao.setText(Municao + "");
	}

	public void setDicas(int Dicas) {
		campoDicas.setText(Dicas + "");
	}
	
	public ItensView getThis() {
		return this;
	}
 
}
