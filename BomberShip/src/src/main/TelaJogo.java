package main;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import celulas.*;
import mar.Mar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TelaJogo extends JFrame {

	private static final long serialVersionUID = -2885747408267733603L;

	JPanel tela;
	JPanel tabuleiroView;
	Celula[][] celula;
	Mar marPlayer1;

	public TelaJogo(Mar marPlayer1) {

		this.marPlayer1 = marPlayer1;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 500, 520);
		tela = new JPanel();
		tela.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(tela);
		tela.setLayout(null);

		this.tabuleiroView = new JPanel();
		tabuleiroView.setBounds(20, 20, 450, 450);
		tela.add(tabuleiroView);
		tabuleiroView.setLayout(new GridLayout(10, 10));
		tabuleiroView.setBackground(Color.BLACK);

		adicionaCelulas(tabuleiroView);

		this.setVisible(true);

	}

	private void adicionaCelulas(Container tabuleiroView) {

		Celula casas[][] = new Celula[10][10];
		int coluna = 0;
		int linha = 0;

		for (coluna = 0; coluna < 10; coluna++)
			for (linha = 0; linha < 10; linha++) {
				casas[coluna][linha] = new Celula();
				tabuleiroView.add(marPlayer1.celulaMar[coluna][linha]);
			}
	}

}
