package viewComponent;

import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import marComponent.Celula.Celula;
import marComponent.Mar.Mar;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class TelaJogo extends JFrame {

	private static final long serialVersionUID = -2885747408267733603L;

	JPanel tela;
	JPanel tabuleiroView;
	Celula[][] celula;
	Mar marPlayer1;
	Mar marPlayer2;
	int numPlayer;

	IBuildView viewP1 = new PlayerView();
	IBuildView viewP2 = new PlayerView();

	final String host = "Host";

	public TelaJogo(Mar marPlayer1, Mar marPlayer2, String Player) {

		this.marPlayer1 = marPlayer1;
		this.marPlayer2 = marPlayer2;

		numPlayer = (Player.equals(host)) ? 1 : 2;

		this.setTitle("BomberShip - Player " + numPlayer);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1050, 650);
		tela = new JPanel();
		tela.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(tela);
		tela.setLayout(new BoxLayout(tela, BoxLayout.PAGE_AXIS));

		this.tabuleiroView = new JPanel();
		tabuleiroView.setPreferredSize(new Dimension(1000, 600));
		GridLayout tabuleiroLayout = new GridLayout(0, 2);
		tabuleiroLayout.setHgap(10);
		tabuleiroLayout.setVgap(10);
		tabuleiroView.setLayout(tabuleiroLayout);

		JPanel player1View = new JPanel();
		JPanel itensPlayer1View = new JPanel();

		tabuleiroView.add(viewP1.criaPlayerView(player1View, itensPlayer1View, "Aliado", marPlayer1));

		JPanel player2View = new JPanel();
		JPanel itensPlayer2View = new JPanel();

		tabuleiroView.add(viewP2.criaPlayerView(player2View, itensPlayer2View, "Inimigo", marPlayer2));

		tela.add(tabuleiroView);

		JPanel logView = new JPanel();
		logView.setPreferredSize(new Dimension(1000, 100));
		tela.setBorder(new EmptyBorder(5, 5, 5, 5));
		logView.setLayout(null);

		JTextPane campoLog = new JTextPane();
		campoLog.setEditable(false);
		campoLog.setForeground(Color.GRAY);
		campoLog.setText(
				"-------------------------------------------- campo de atualizações --------------------------------------------\n Jogo Iniciado");
		campoLog.setBounds(10, 10, 1000, 80);

		logView.add(campoLog);
		logView.setVisible(true);
		tela.add(logView);

		this.setVisible(true);

	}

}
