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

import controleComponent.Bomba;
import marComponent.Celula.IMarRefactor;
import marComponent.Mar.IBuildMar; 

public class PlayerView extends JPanel implements IBuildView,IMarRefactor {

	private static final long serialVersionUID = 1L;
	ItensView itens = new ItensView();

	public Component criaPlayerView(JPanel playerView, JPanel itensPlayerView, String Player, IBuildMar mar) {
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

		playerView.add(itens.criaItensView(itensPlayerView, Player));

		return playerView;
	}

	private void adicionaCelulas(Container playerView, IBuildMar mar) {

		for (int coluna = 0; coluna < 10; coluna++)
			for (int linha = 0; linha < 10; linha++)
				playerView.add(mar.getcelulaMar(coluna,linha));
		// TODO: alterar aqui para interfaces
	}

	@Override
	public void explode(Bomba bomba) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isCelulaRevelada() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setCelulaRevelada(boolean celulaRevelada) {
		// TODO Auto-generated method stub
		
	}

}
