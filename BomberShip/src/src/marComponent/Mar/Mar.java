package marComponent.Mar;

import java.awt.Component;

import javax.swing.ImageIcon;

import controleComponent.Time;
import marComponent.Celula.Armadilha;
import marComponent.Celula.BauDoTesouro;
import marComponent.Celula.Celula;
import marComponent.Celula.Peca;
import marComponent.Pecas.Cruzeiro;
import marComponent.Pecas.Navio;
import marComponent.Pecas.NavioTanque;
import marComponent.Pecas.PortaAviao;
import marComponent.Pecas.Submarino;
import montadorComponent.InvalidMapContent;

public class Mar implements IMarRefactor, IMarVisual{
	public Celula[][] celulaMar;
	public Time time;

	ImageIcon imgBombaExplodida;
	ImageIcon imgArmadilhaTubarao;
	ImageIcon imgBauDoTesouro;
	ImageIcon imgSplash;

	public Mar() {
		carregaImagens();
	}

	private void carregaImagens() {
		imgBombaExplodida = new ImageIcon(new ImageIcon(this.getClass().getResource("/BombaExplodida.png")).getImage()
				.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH));
		imgArmadilhaTubarao = new ImageIcon(new ImageIcon(this.getClass().getResource("/imgArmadilhaTubarao.png"))
				.getImage().getScaledInstance(35, 35, java.awt.Image.SCALE_SMOOTH));
		imgBauDoTesouro = new ImageIcon(new ImageIcon(this.getClass().getResource("/imgBauDoTesouro.png")).getImage()
				.getScaledInstance(35, 35, java.awt.Image.SCALE_SMOOTH));
		imgSplash = new ImageIcon(new ImageIcon(this.getClass().getResource("/imgSplash.png")).getImage()
				.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH));

	}

	// TODO : esse método está estourando os limites das celulas, aumentei para
	// [11][11] como paleativo
	public Celula insereCelula(Celula c) throws InvalidMapContent {
		int x = c.getLinha();
		int y = c.getColuna();
		celulaMar[x][y] = c;
		if (c.tipo != 'A' && c.tipo != 'B')
			celulaMar[x][y].setText(c.tipo + "");

		celulaMar[x][y].setTime(time);

		return celulaMar[x][y];
	}

	public void insereCelula(Celula c, ImageIcon img) throws Exception {
		insereCelula(c).SetImage(img);
	}
	
	public boolean insereNavio(String tipo, String sentido, int x, int y) throws InvalidMapContent {
		boolean a = false;
		if (tipo.equals("S")) {
			a = insereSubmarino(x, y, sentido);
		} else if (tipo.equals("C")) {
			a = insereCruzeiro(x, y, sentido);
		} else if (tipo.equals("N")) {
			a = insereNavioTanque(x, y, sentido);
		} else if (tipo.equals("P")) {
			a = inserePortaAviao(x, y, sentido);
		} else if (tipo.equals("A")) {
			a = insereArmadilha(x, y);
		} else if (tipo.equals("B")) {
			a = insereBauDoTesouro(x, y);
		}
		return a;
	}

	public boolean insereSubmarino(int x, int y, String sentido) throws InvalidMapContent {
		if (sentido.equals("h")) {

			if (celulaMar[x][y] == null && celulaMar[x][y + 1] == null) {
				Peca n1 = new Peca(x, y, 'S');
				Peca n2 = new Peca(x, y + 1, 'S');
				insereCelula(n1);
				insereCelula(n2);
				Navio sub = new Submarino(n1, n2);
				n1.setNavio(sub);
				n2.setNavio(sub);
				return true;
			}
			return false;
		} else if (sentido.equals("v")) {
			if (celulaMar[x][y] == null && celulaMar[x + 1][y] == null) {
				Peca n1 = new Peca(x, y, 'S');
				Peca n2 = new Peca(x + 1, y, 'S');
				insereCelula(n1);
				insereCelula(n2);
				Submarino sub = new Submarino(n1, n2);
				n1.setNavio(sub);
				n2.setNavio(sub); 
				return true;
			}
			return false;
		}
		return false;
	}

	public boolean insereCruzeiro(int x, int y, String sentido) throws InvalidMapContent {
		if (sentido.equals("h")) {
			if (celulaMar[x][y] == null && celulaMar[x][y + 1] == null && celulaMar[x][y + 2] == null) {
				Peca n1 = new Peca(x, y, 'C');
				Peca n2 = new Peca(x, y + 1, 'C');
				Peca n3 = new Peca(x, y + 2, 'C');
				insereCelula(n1);
				insereCelula(n2);
				insereCelula(n3);
				Cruzeiro cruz = new Cruzeiro(n1, n2, n3);
				n1.setNavio(cruz);
				n2.setNavio(cruz);
				n3.setNavio(cruz);
				return true;
			}
			return false;
		} else if (sentido.equals("v")) {
			if (celulaMar[x][y] == null && celulaMar[x + 1][y] == null && celulaMar[x + 2][y] == null) {
				Peca n1 = new Peca(x, y, 'C');
				Peca n2 = new Peca(x + 1, y, 'C');
				Peca n3 = new Peca(x + 2, y, 'C');
				insereCelula(n1);
				insereCelula(n2);
				insereCelula(n3);
				Cruzeiro cruz = new Cruzeiro(n1, n2, n3);
				n1.setNavio(cruz);
				n2.setNavio(cruz);
				n3.setNavio(cruz); 
				return true;
			}
			return false;
		}
		return false;
	}

	public boolean insereNavioTanque(int x, int y, String sentido) throws InvalidMapContent {
		if (sentido.equals("h")) {
			if (celulaMar[x][y] == null && celulaMar[x][y + 1] == null && celulaMar[x][y + 2] == null
					&& celulaMar[x][y + 3] == null) {
				Peca n1 = new Peca(x, y, 'N');
				Peca n2 = new Peca(x, y + 1, 'N');
				Peca n3 = new Peca(x, y + 2, 'N');
				Peca n4 = new Peca(x, y + 3, 'N');
				insereCelula(n1);
				insereCelula(n2);
				insereCelula(n3);
				insereCelula(n4);
				NavioTanque nt = new NavioTanque(n1, n2, n3, n4);
				n1.setNavio(nt);
				n2.setNavio(nt);
				n3.setNavio(nt);
				n4.setNavio(nt);
				return true;
			}
			return false;
		} else if (sentido.equals("v")) {
			if (celulaMar[x][y] == null && celulaMar[x + 1][y] == null && celulaMar[x + 2][y] == null
					&& celulaMar[x + 3][y] == null) {
				Peca n1 = new Peca(x, y, 'N');
				Peca n2 = new Peca(x + 1, y, 'N');
				Peca n3 = new Peca(x + 2, y, 'N');
				Peca n4 = new Peca(x + 3, y, 'N');
				insereCelula(n1);
				insereCelula(n2);
				insereCelula(n3);
				insereCelula(n4);
				NavioTanque nt = new NavioTanque(n1, n2, n3, n4);
				n1.setNavio(nt);
				n2.setNavio(nt);
				n3.setNavio(nt);
				n4.setNavio(nt); 
				return true;
			}
			return false;
		}
		return false;
	}

	public boolean inserePortaAviao(int x, int y, String sentido) throws InvalidMapContent {
		if (sentido.equals("h")) {
			if (celulaMar[x][y] == null && celulaMar[x][y + 1] == null && celulaMar[x][y + 2] == null
					&& celulaMar[x][y + 3] == null && celulaMar[x][y + 4] == null) {
				Peca n1 = new Peca(x, y, 'P');
				Peca n2 = new Peca(x, y + 1, 'P');
				Peca n3 = new Peca(x, y + 2, 'P');
				Peca n4 = new Peca(x, y + 3, 'P');
				Peca n5 = new Peca(x, y + 4, 'P');
				insereCelula(n1);
				insereCelula(n2);
				insereCelula(n3);
				insereCelula(n4);
				insereCelula(n5);
				PortaAviao pa = new PortaAviao(n1, n2, n3, n4, n5);
				n1.setNavio(pa);
				n2.setNavio(pa);
				n3.setNavio(pa);
				n4.setNavio(pa);
				n5.setNavio(pa);
				return true;
			}
			return false;
		} else if (sentido.equals("v")) {
			if (celulaMar[x][y] == null && celulaMar[x + 1][y] == null && celulaMar[x + 2][y] == null
					&& celulaMar[x + 3][y] == null && celulaMar[x + 4][y] == null) {
				Peca n1 = new Peca(x, y, 'P');
				Peca n2 = new Peca(x + 1, y, 'P');
				Peca n3 = new Peca(x + 2, y, 'P');
				Peca n4 = new Peca(x + 3, y, 'P');
				Peca n5 = new Peca(x + 4, y, 'P');
				insereCelula(n1);
				insereCelula(n2);
				insereCelula(n3);
				insereCelula(n4);
				insereCelula(n5);
				PortaAviao pa = new PortaAviao(n1, n2, n3, n4, n5);
				n1.setNavio(pa);
				n2.setNavio(pa);
				n3.setNavio(pa);
				n4.setNavio(pa);
				n5.setNavio(pa); 
				return true;
			}
			return false;
		}
		return false;
	}

	public boolean insereArmadilha(int x, int y) throws InvalidMapContent {
		if (celulaMar[x][y] == null) {
			Celula a = new Armadilha(x, y, 'A');
			try {
				insereCelula(a, imgArmadilhaTubarao);
			} catch (Exception e) {
				e.printStackTrace();
			} 
			return true;
		}
		return false;
	}

	public boolean insereBauDoTesouro(int x, int y) throws InvalidMapContent {
		if (celulaMar[x][y] == null) {
			Celula b = new BauDoTesouro(x, y, 'B');
			try {
				insereCelula(b, imgBauDoTesouro);
			} catch (Exception e) {
				e.printStackTrace();
			} 
			return true;
		}
		return false;
	}

	public void setMar(Celula[][] mar, Time time) {
		this.celulaMar = mar;
		this.time = time;
	}

	public Celula[][] getMar() {
		return celulaMar;
	}

	public char getTipoCelula(int coluna, int linha) {

		if (!(celulaMar[coluna][linha] == null))
			return celulaMar[coluna][linha].tipo;
		else
			return '~';
	}

	public Component getcelulaMar(int coluna, int linha) {
		return celulaMar[coluna][linha];
	}
	public Mar getThis() {
		return this;
	}
	public Celula getCelula(int i, int j) {
		return celulaMar[i][j];
	}
}
