package viewComponent;
 
import java.awt.Dimension;
import java.awt.GridLayout;
import marComponent.Celula.Celula;
import marComponent.Mar.IMarVisual; 
import javax.swing.BoxLayout;
import javax.swing.JFrame; 
import javax.swing.JPanel;  
import javax.swing.border.EmptyBorder;

public class TelaJogo extends JFrame {

	private static final long serialVersionUID = -2885747408267733603L;

	JPanel tela;
	JPanel tabuleiroView;
	Celula[][] celula;
	IMarVisual marPlayer1;
	IMarVisual marPlayer2;
	int numPlayer;

	IBuildView viewP1 = new PlayerView();
	IBuildView viewP2 = new PlayerView();
	
	ItensView itensPlayer1View;
	ItensView itensPlayer2View;
	
	LogView logView;

	final String host = "Host";

	public TelaJogo(IMarVisual marPlayer1, IMarVisual marPlayer2, String Player) {

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
		itensPlayer1View = new ItensView();

		tabuleiroView.add(viewP1.criaPlayerView(player1View, itensPlayer1View, "Aliado", marPlayer1.getThis()));

		JPanel player2View = new JPanel();
		itensPlayer2View = new ItensView();

		tabuleiroView.add(viewP2.criaPlayerView(player2View, itensPlayer2View, "Inimigo", marPlayer2.getThis()));

		tela.add(tabuleiroView);

		logView = new LogView();
		tela.add(logView.criaLog());

		this.setVisible(true);

	}
	
	public IItemRefactor getItensPlayer1View(){
		return itensPlayer1View.getThis();
	}
	
	public IItemRefactor getItensPlayer2View(){
		return itensPlayer2View;
	}
	
	public IItemRefactor getLogView(){
		return logView;
	}
	 
}
