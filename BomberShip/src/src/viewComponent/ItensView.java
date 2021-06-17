package viewComponent;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ItensView extends JPanel {
 
	private static final long serialVersionUID = 1L;

	public JPanel criaItensView(JPanel itensPlayerView, String Player) {

		itensPlayerView.setPreferredSize(new Dimension(450, 50));
		itensPlayerView.setBorder(new EmptyBorder(10, 5, 10, 5));
		GridLayout itensLayout = new GridLayout(0, 6);
		itensLayout.setHgap(10);
		itensLayout.setVgap(10);
		itensPlayerView.setLayout(itensLayout);

		JLabel lblPontos = new JLabel("Pontos");
		lblPontos.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		itensPlayerView.add(lblPontos);

		JTextField campoPontos = new JTextField("1");
		campoPontos.setBackground(Color.white);
		campoPontos.setEditable(false);
		campoPontos.setBounds(1, 1, 50, 50);
		itensPlayerView.add(campoPontos);

		JLabel lblDicas = new JLabel("Dicas");
		lblDicas.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		itensPlayerView.add(lblDicas);

		JTextField campoDicas = new JTextField("1");
		campoDicas.setBackground(Color.white);
		campoDicas.setEditable(false);
		itensPlayerView.add(campoDicas);

		JLabel lblMunicao = new JLabel("Munição");
		lblMunicao.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		itensPlayerView.add(lblMunicao);

		JTextField campoMunicao = new JTextField("1");
		campoMunicao.setBackground(Color.white);
		campoMunicao.setEditable(false);
		itensPlayerView.add(campoMunicao);


		return itensPlayerView;

	}
}
