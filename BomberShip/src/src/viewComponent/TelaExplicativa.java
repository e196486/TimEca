package viewComponent;

import java.awt.Container;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class TelaExplicativa extends JFrame {
  
	private static final long serialVersionUID = -5846031524562538597L;
	
	private int nivel;
 

	public TelaExplicativa(int nivel) {
		this.setTitle("Tutorial do Jogo");
		this.setVisible(true);
		this.setBounds(0, 0, 450, 500);
		this.setLocationRelativeTo(null);
		Container telaExplicativa = getContentPane();
		this.iniciaExplicacao(telaExplicativa);
		this.setIconImage(new ImageIcon(this.getClass().getResource("/BombaExplodida.png")).getImage());
		this.nivel = nivel;

	}

	public void iniciaExplicacao(Container telaExplicativa) {

		telaExplicativa.setBounds(0, 0, 450, 500);
		telaExplicativa.setLayout(null);
		setContentPane(telaExplicativa);

		JLabel lblTitulo = new JLabel("Bem Vindo ao BomberShip!");
		lblTitulo.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(0, 10, 440, 40);
		telaExplicativa.add(lblTitulo);
		

	}
}
