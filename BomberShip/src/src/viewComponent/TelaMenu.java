package viewComponent;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class TelaMenu extends JFrame {

	String IP;
	int Porta;
	boolean comecaJogo = false;
	private int nivel;

	private static final long serialVersionUID = -8873103691626125174L;

	public TelaMenu() {
		setBounds(100, 100, 450, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container menuInicial = getContentPane();
		iniciaMenu(menuInicial);

	}

	public void iniciaMenu(Container menuInicial) {

		menuInicial.setBounds(0, 0, 450, 500);
		menuInicial.setLayout(null);
		setContentPane(menuInicial);

		JLabel lblTitulo = new JLabel("Bem Vindo ao BomberShip!");
		lblTitulo.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(0, 50, 440, 40);
		menuInicial.add(lblTitulo);

		JLabel lblInsiraNome = new JLabel("Insira seu nome:");
		lblInsiraNome.setBounds(50, 125, 300, 20);
		menuInicial.add(lblInsiraNome);

		JTextField campoNome = new JTextField(20);
		campoNome.setBounds(50, 150, 320, 30);
		campoNome.setText("Player");
		campoNome.setEditable(true);
		menuInicial.add(campoNome);

		JLabel lblInsiraIP = new JLabel("Insira seu IP:");
		lblInsiraIP.setBounds(50, 185, 300, 20);
		menuInicial.add(lblInsiraIP);

		JTextField campoIP = new JTextField(20);
		campoIP.setBounds(50, 210, 320, 30);
		campoIP.setText("localhost");
		campoIP.setEditable(true);
		menuInicial.add(campoIP);

		JLabel lblInsiraPorta = new JLabel("Insira sua Porta:");
		lblInsiraPorta.setBounds(50, 245, 300, 20);
		menuInicial.add(lblInsiraPorta);

		JTextField campoPorta = new JTextField(20);
		campoPorta.setBounds(50, 270, 320, 30);
		campoPorta.setText("1234");
		campoPorta.setEditable(true);
		menuInicial.add(campoPorta);

		JLabel lblInsiraNivel = new JLabel("Escolha um nível para seu tabuleiro:");
		lblInsiraNivel.setBounds(50, 305, 300, 20);
		menuInicial.add(lblInsiraNivel);

		String fases[] = { "1 - Fácil", "2 - Médio", "3 - Difícil" };
		JComboBox cb = new JComboBox(fases);
		cb.setBackground(Color.white);
		cb.setBounds(50, 330, 320, 30);
		menuInicial.add(cb);

		JButton btnIniciaJogo = new JButton("Inicia Jogo");
		btnIniciaJogo.setBounds(50, 390, 150, 20);
		btnIniciaJogo.addActionListener(e -> {
			this.IP = campoIP.getText();
			this.Porta = Integer.parseInt(campoPorta.getText());
			this.nivel = cb.getSelectedIndex() + 1;

			this.setVisible(false);
			setComecaJogo(true);

		});

		menuInicial.add(btnIniciaJogo);

	}

	public synchronized boolean aguardaIniciaJogo() throws InterruptedException {
		System.out.println("estamos aguardando o Jogo iniciar");

		while (!comecaJogo) {
			wait();
		}

		return true;
	}

	public synchronized void setComecaJogo(boolean comecaJogo) {
		this.comecaJogo = comecaJogo;
		if (this.comecaJogo)
			notifyAll();
	}

	public String getIP() {
		return IP;
	}

	public int getPorta() {
		return Porta;
	}
	
	public int getNivel() {
		return nivel;
	}

}
