package viewComponent;

import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;  
import marComponent.Mar.IMarVisual; 

public class PlayerView extends JPanel implements IBuildView {

	private static final long serialVersionUID = 1L;
	ItensView itens;

	public Component criaPlayerView(JPanel playerView, ItensView itensPlayerView, String Player, IMarVisual mar) {
		itens = itensPlayerView;
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

		adicionaCelulas(playerTabuleiroView, mar);

		playerTabuleiroView.setVisible(true);

		playerView.add(playerTabuleiroView);

		playerView.add(itens.criaItensView(Player));

		return playerView;
	}

	private void adicionaCelulas(Container playerView, IMarVisual mar) {

		for (int coluna = 0; coluna < 10; coluna++)
			for (int linha = 0; linha < 10; linha++)
				playerView.add(mar.getcelulaMar(coluna,linha));
		// TODO: alterar aqui para interfaces
	}
   
}
