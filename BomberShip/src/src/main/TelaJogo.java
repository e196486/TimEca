package main;

import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import celulas.*;
import mar.Mar;
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

	public JTextField campoMunicaoPlayer1;
	public JTextField campoDicasPlayer1;
	public JTextField campoPontosPlayer1;

	public JTextField campoMunicaoPlayer2;
	public JTextField campoDicasPlayer2;
	public JTextField campoPontosPlayer2;
	
	String host = "Host";

	public TelaJogo(Mar marPlayer1, Mar marPlayer2,String Player) {

		this.marPlayer1 = marPlayer1;
		this.marPlayer2 = marPlayer2;
		
		if (Player.equals(host))
			numPlayer = 1;
		else 
			numPlayer = 2;

		this.setTitle("BomberShip - Player "+ numPlayer); 
		
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

		tabuleiroView.add(criaPlayerView(player1View, itensPlayer1View, "Aliado"));

		JPanel player2View = new JPanel();
		JPanel itensPlayer2View = new JPanel();

		tabuleiroView.add(criaPlayerView(player2View, itensPlayer2View, "Inimigo"));

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

	private Component criaPlayerView(JPanel playerView, JPanel itensPlayerView, String Player) {
		playerView.setSize(450, 600);
		playerView.setLayout(new BoxLayout(playerView, BoxLayout.PAGE_AXIS));
		playerView.setVisible(true);

		JLabel lblTituloTabuleiro = new JLabel();

		lblTituloTabuleiro.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		playerView.add(lblTituloTabuleiro);

		JPanel playerTabuleiroView = new JPanel();
		playerTabuleiroView.setPreferredSize(new Dimension(450, 500));
		playerTabuleiroView.setLayout(new GridLayout(10, 10));
		playerTabuleiroView.setBackground(Color.BLUE);

		if (Player.equals("Aliado"))
			adicionaCelulas(playerTabuleiroView, marPlayer1);
		else
			adicionaCelulas(playerTabuleiroView, marPlayer2);

		playerTabuleiroView.setVisible(true);

		playerView.add(playerTabuleiroView);

		playerView.add(criaItensPlayerView(itensPlayerView, Player));

		return playerView;
	}

	private JPanel criaItensPlayerView(JPanel itensPlayerView, String Player) {

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

		if (Player.equals("Aliado")) {
			campoMunicaoPlayer1 = campoMunicao;
			campoDicasPlayer1 = campoDicas;
			campoPontosPlayer1 = campoPontos;
		} else {
			campoMunicaoPlayer2 = campoMunicao;
			campoDicasPlayer2 = campoDicas;
			campoPontosPlayer2 = campoPontos;
		}

		return itensPlayerView;

	}

	private void adicionaCelulas(Container playerView, Mar mar) { 

		for (int coluna = 0; coluna < 10; coluna++)
			for (int linha = 0; linha < 10; linha++)
				playerView.add(mar.celulaMar[coluna][linha]);
	}


}
