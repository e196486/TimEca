package viewComponent;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class TelaExplicativa extends JFrame {

	private static final long serialVersionUID = -5846031524562538597L;

	private int nivel;
	private int maxBombas;
	private int maxDicas;
	private int maxTubaroes;
	private int maxBaus;
	private final int ptsSubmarino = 40;
	private final int ptsCruzeiro = 60;
	private final int ptsNavioTanque = 80;
	private final int ptsPortaAviao = 100;

	private ImageIcon imgBombaExplodida;
	private ImageIcon imgArmadilhaTubarao;
	private ImageIcon imgBauDoTesouro;
	private ImageIcon imgSplash;
	private ImageIcon imgNavioTanque;
	private ImageIcon imgCruzeiro;
	private ImageIcon imgPortaAviao;
	private ImageIcon imgSubmarino;
	private ImageIcon imgDicaRevelada;

	public TelaExplicativa(int nivel) {
		this.nivel = nivel;
		carregaImagens();
		this.setTitle("Tutorial do Jogo");
		this.setVisible(true);
		this.setBounds(0, 0, 580, 500);
		this.setLocationRelativeTo(null);
		Container telaExplicativa = getContentPane();
		this.iniciaExplicacao(telaExplicativa);
		this.setIconImage(imgBombaExplodida.getImage());

	}

	private int getDadosNivel(String Dado) {
		switch (nivel) {
		case 1:
			this.maxBombas = 90;
			this.maxDicas = 3;
			this.maxBaus = 2;
			this.maxTubaroes = 2;
			break;
		case 2:
			this.maxBombas = 70;
			this.maxDicas = 2;
			this.maxBaus = 1;
			this.maxTubaroes = 4;
			break;
		case 3:
			this.maxBombas = 50;
			this.maxDicas = 1;
			this.maxBaus = 0;
			this.maxTubaroes = 6;
		}

		if (Dado.equals("Dica"))
			return maxDicas;
		else if (Dado.equals("Bomba"))
			return maxBombas;
		else if (Dado.equals("Tubaroes"))
			return maxTubaroes;
		else
			return maxBaus;

	}

	public void iniciaExplicacao(Container janela) {

		janela.setBounds(0, 0, 580, 500);
		janela.setLayout(new BorderLayout());
		setContentPane(janela);

		JPanel telaExplicativa = new JPanel();
		JScrollPane scroll = new JScrollPane(telaExplicativa);
		scroll.setSize(560, 450);
		telaExplicativa.setLayout(new BoxLayout(telaExplicativa, BoxLayout.PAGE_AXIS));
		janela.add(BorderLayout.CENTER, scroll);

		JLabel lblTitulo = new JLabel("BOMBERSHIP! Nível: " + nivel);
		lblTitulo.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(0, 10, 560, 30);
		telaExplicativa.add(lblTitulo);

		JPanel telaObjetivo = new JPanel();
		telaObjetivo.setBounds(0, 50, 520, 200);
		JLabel lblObjetivoJogo = new JLabel(txtObjetivoJogo);
		lblObjetivoJogo.setFont(new Font("Comic Sans MS", Font.LAYOUT_NO_START_CONTEXT, 13));
		telaObjetivo.add(lblObjetivoJogo);
		telaExplicativa.add(telaObjetivo);

		JPanel telaTexto = new JPanel();
		telaTexto.setBounds(10, 350, 520, 300);
		telaTexto.setLayout(new GridLayout(9, 0));

		telaTexto.add(adicionaTela(imgArmadilhaTubarao, explicaArmadilhaTubarao + "<b>Serão "
				+ getDadosNivel("Tubaroes") + " tubarões  atras de você!</html>"));
		if (nivel != 3)
			telaTexto.add(adicionaTela(imgBauDoTesouro,
					explicaBauDoTesouro + "<b>Serão " + getDadosNivel("Baus") + " Baus espalhados para você!</html>"));

		telaTexto.add(adicionaTela(imgBombaExplodida, explicaBomba + "<b>Você irá iniciar com " + getDadosNivel("Bomba")
				+ " bombas disponíveis!</b>" + "</html>"));

		telaTexto.add(adicionaTela(imgSplash, explicaSplash));
		telaTexto.add(adicionaTela(imgSubmarino, explicaSubmarino));
		telaTexto.add(adicionaTela(imgCruzeiro, explicaCruzeiro));
		telaTexto.add(adicionaTela(imgNavioTanque, explicaNavioTanque));
		telaTexto.add(adicionaTela(imgPortaAviao, explicaPortaAviao));

		telaTexto.add(adicionaTela(imgDicaRevelada, explicaDica + "<b>Você irá iniciar com " + getDadosNivel("Dica")
				+ " dicas disponíveis!</b>" + "</html>"));

		telaExplicativa.add(telaTexto);

	}

	private JPanel adicionaTela(ImageIcon imgIcone, String explicaIcone) {
		JPanel tela = new JPanel();

		JLabel lblImg = new JLabel();
		lblImg.setIcon(imgIcone);
		tela.add(lblImg);

		JLabel lblTxt = new JLabel(explicaIcone);
		lblTxt.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		tela.add(lblTxt);
		return tela;
	}

	private void carregaImagens() {
		imgBombaExplodida = new ImageIcon(new ImageIcon(this.getClass().getResource("/BombaExplodida.png")).getImage()
				.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
		imgArmadilhaTubarao = new ImageIcon(new ImageIcon(this.getClass().getResource("/imgArmadilhaTubarao.png"))
				.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
		imgBauDoTesouro = new ImageIcon(new ImageIcon(this.getClass().getResource("/imgBauDoTesouro.png")).getImage()
				.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
		imgSplash = new ImageIcon(new ImageIcon(this.getClass().getResource("/imgSplash.png")).getImage()
				.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
		imgCruzeiro = new ImageIcon(new ImageIcon(this.getClass().getResource("/imgCruzeiro.png")).getImage()
				.getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH));
		imgNavioTanque = new ImageIcon(new ImageIcon(this.getClass().getResource("/imgNavio.png")).getImage()
				.getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH));
		imgPortaAviao = new ImageIcon(new ImageIcon(this.getClass().getResource("/imgPortaAviao.png")).getImage()
				.getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH));
		imgSubmarino = new ImageIcon(new ImageIcon(this.getClass().getResource("/imgSubmarino.png")).getImage()
				.getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH));
		imgDicaRevelada = new ImageIcon(new ImageIcon(this.getClass().getResource("/imgDicaRevelada.png")).getImage()
				.getScaledInstance(75, 75, java.awt.Image.SCALE_SMOOTH));

	}

	private final String txtObjetivoJogo = "<html> \r\n" + "<br>" + "<h2>Objetivo do Jogo</h2>\r\n" + "\r\n"
			+ "<p style=\"text-align:center;\">Você deverá localizar e derrotar todos os navios inimigos!<br>"
			// + " Para isso, <u>seus pontos devem permanecer acima de 0</u>, ou suas forças
			// <br>"
			// + "acabarão e você perderá! <br>\r\n"
			+ "<b>Mas cuidado</b>: O campo inimigo está cercado de tubarões que podem roubar seus itens! <br>\r\n"
			+ "A notícia boa é que antigos aliados colocaram baús escondidos com premios <br>"
			+ "para te ajudar! Ache-os e você poderá recuperar alguns itens;\r\n" + "\r\n" + "</p> \r\n"
			+ "<h2>Explicando as peças</h2>\r\n" + "</html>";

	private String explicaBomba = "<html>Bomba Explodida! <br>"
			+ "Esse icone aparecerá em cima de cada embarcação que você <br>"
			+ "destruir! Você ganhará x pontos por essa ação!<br>";

	private final String explicaArmadilhaTubarao = "<html>Tubarão-Armadilha! <br>"
			+ "Ele irá roubar alguns itens de você! Pode ser alguns pontos,<br>"
			+ " algumas bombas ou até algumas dicas!! cuidado!<br>";

	private final String explicaBauDoTesouro = "<html>Bau do Tesouro! <br>"
			+ "Esse item te dará alguns bonus. Você poderá ganhar bombas," + "<br> pontos ou até mesmo dicas!<br>";

	private final String explicaSplash = "<html><p>Splash! <br>"
			+ "Esse icone aparecerá quando você atingir o mar! Você irá <br>"
			+ "perder 10 pontos por essa ação!</p></html>";

	private final String explicaSubmarino = "<html><p>Submarino! <br>"
			+ "Esse navio inimigo ocupa duas celulas do mar! <br>" + "Afundando todas as partes, você ganhará mais "
			+ ptsSubmarino + " pontos!! </p></html>";

	private final String explicaCruzeiro = "<html><p>Cruzeiro! <br>"
			+ "Esse navio inimigo ocupa três celulas do mar! <br>" + "Afundando todas as partes, você ganhará mais "
			+ ptsCruzeiro + " pontos!! </p></html>";

	private final String explicaNavioTanque = "<html><p>Navio Tanque! <br>"
			+ "Esse navio inimigo ocupa quatro celulas do mar! <br>" + "Afundando todas as partes, você ganhará mais "
			+ ptsNavioTanque + " pontos!! </p></html>";

	private final String explicaPortaAviao = "<html><p>Porta Avião! <br>"
			+ "Esse navio inimigo ocupa cinco celulas do mar! <br>" + "Afundando todas as partes, você ganhará mais "
			+ ptsPortaAviao + " pontos!! </p></html>";

	private String explicaDica = "<html><p>Dica! <br>" + "As dicas te ajudam espionando o inimigo! <br>"
			+ "Use-as e a sua bomba irá revelar as 4 celulas adjacentes de onde atingir! </p>";
}
