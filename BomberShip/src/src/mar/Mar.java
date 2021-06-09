package mar;

import celulas.*;
import pecas.*;

public class Mar {
	private Celula[][] celulaMar;
	Submarino sub1;
	Submarino sub2;
	Submarino sub3;
	Cruzeiro cruz1;
	Cruzeiro cruz2;
	NavioTanque tank1;
	NavioTanque tank2;
	PortaAviao pa;

	// TODO : esse método está estourando os limites das celulas, aumentei para
	// [11][11] como paleativo
	public void insereCelula(Celula c) {
		int x = c.getLinha();
		int y = c.getColuna();
		celulaMar[x][y] = c;
		if (y > 0) {
			c.esquerda = celulaMar[x][y - 1];
			if (c.esquerda != null)
				celulaMar[x][y - 1].direita = c;
		}
		if (y <= 10) {
			c.direita = celulaMar[x][y + 1];
			if (c.direita != null)
				celulaMar[x][y + 1].esquerda = c;
		}
		if (x > 0) {
			c.cima = celulaMar[x - 1][y];
			if (c.cima != null)
				celulaMar[x - 1][y].baixo = c;
		}
		if (x <= 10) {
			c.baixo = celulaMar[x + 1][y];
			if (c.baixo != null)
				celulaMar[x + 1][y].cima = c;
		}
	}

	public boolean insereSubmarino(int x, int y, String sentido) throws Exception {
		if (sentido.equals("h")) {

			if (celulaMar[x][y] == null && celulaMar[x][y + 1] == null) {
				Navio n1 = new Navio(x, y, 'S');
				Navio n2 = new Navio(x, y + 1, 'S');
				insereCelula(n1);
				insereCelula(n2);
				Submarino sub = new Submarino(n1, n2);
				setSubmarino(sub);
				// TESTE
				System.out.println("inseriu :" + n1.tipo);
				return true;
			}
			return false;
		} else if (sentido.equals("v")) {
			if (celulaMar[x][y] == null && celulaMar[x + 1][y] == null) {
				Navio n1 = new Navio(x, y, 'S');
				Navio n2 = new Navio(x + 1, y, 'S');
				insereCelula(n1);
				insereCelula(n2);
				Submarino sub = new Submarino(n1, n2);
				setSubmarino(sub);
				// TESTE
				System.out.println("inseriu :" + n1.tipo);
				return true;
			}
			return false;
		}
		return false;
	}

	public boolean insereCruzeiro(int x, int y, String sentido) throws Exception {
		if (sentido.equals("h")) {
			if (celulaMar[x][y] == null && celulaMar[x][y + 1] == null && celulaMar[x][y + 2] == null) {
				Navio n1 = new Navio(x, y, 'C');
				Navio n2 = new Navio(x, y + 1, 'C');
				Navio n3 = new Navio(x, y + 2, 'C');
				insereCelula(n1);
				insereCelula(n2);
				insereCelula(n3);
				Cruzeiro cruz = new Cruzeiro(n1, n2, n3);
				setCruzeiro(cruz);
				// TESTE
				System.out.println("inseriu :" + n1.tipo);
				return true;
			}
			return false;
		} else if (sentido.equals("v")) {
			if (celulaMar[x][y] == null && celulaMar[x + 1][y] == null && celulaMar[x + 2][y] == null) {
				Navio n1 = new Navio(x, y, 'C');
				Navio n2 = new Navio(x + 1, y, 'C');
				Navio n3 = new Navio(x + 2, y, 'C');
				insereCelula(n1);
				insereCelula(n2);
				insereCelula(n3);
				Cruzeiro sub = new Cruzeiro(n1, n2, n3);
				setCruzeiro(sub);
				// TESTE
				System.out.println("inseriu :" + n1.tipo);
				return true;
			}
			return false;
		}
		return false;
	}

	public boolean insereNavioTanque(int x, int y, String sentido) throws Exception {
		if (sentido.equals("h")) {
			if (celulaMar[x][y] == null && celulaMar[x][y + 1] == null && celulaMar[x][y + 2] == null
					&& celulaMar[x][y + 3] == null) {
				Navio n1 = new Navio(x, y, 'N');
				Navio n2 = new Navio(x, y + 1, 'N');
				Navio n3 = new Navio(x, y + 2, 'N');
				Navio n4 = new Navio(x, y + 3, 'N');
				insereCelula(n1);
				insereCelula(n2);
				insereCelula(n3);
				insereCelula(n4);
				NavioTanque nt = new NavioTanque(n1, n2, n3, n4);
				setNavioTanque(nt);
				// TESTE
				System.out.println("inseriu :" + n1.tipo);
				return true;
			}
			return false;
		} else if (sentido.equals("v")) {
			if (celulaMar[x][y] == null && celulaMar[x + 1][y] == null && celulaMar[x + 2][y] == null
					&& celulaMar[x + 3][y] == null) {
				Navio n1 = new Navio(x, y, 'N');
				Navio n2 = new Navio(x + 1, y, 'N');
				Navio n3 = new Navio(x + 2, y, 'N');
				Navio n4 = new Navio(x + 3, y, 'N');
				insereCelula(n1);
				insereCelula(n2);
				insereCelula(n3);
				insereCelula(n4);
				NavioTanque nt = new NavioTanque(n1, n2, n3, n4);
				setNavioTanque(nt);
				// TESTE
				System.out.println("inseriu :" + n1.tipo);
				return true;
			}
			return false;
		}
		return false;
	}

	public boolean inserePortaAviao(int x, int y, String sentido) throws Exception {
		if (sentido.equals("h")) {
			if (celulaMar[x][y] == null && celulaMar[x][y + 1] == null && celulaMar[x][y + 2] == null
					&& celulaMar[x][y + 3] == null && celulaMar[x][y + 4] == null) {
				Navio n1 = new Navio(x, y, 'P');
				Navio n2 = new Navio(x, y + 1, 'P');
				Navio n3 = new Navio(x, y + 2, 'P');
				Navio n4 = new Navio(x, y + 3, 'P');
				Navio n5 = new Navio(x, y + 4, 'P');
				insereCelula(n1);
				insereCelula(n2);
				insereCelula(n3);
				insereCelula(n4);
				insereCelula(n5);
				PortaAviao pa = new PortaAviao(n1, n2, n3, n4, n5);
				setPortaAviao(pa);
				// TESTE
				System.out.println("inseriu :" + n1.tipo);
				return true;
			}
			return false;
		} else if (sentido.equals("v")) {
			if (celulaMar[x][y] == null && celulaMar[x + 1][y] == null && celulaMar[x + 2][y] == null
					&& celulaMar[x + 3][y] == null && celulaMar[x + 4][y] == null) {
				Navio n1 = new Navio(x, y, 'P');
				Navio n2 = new Navio(x + 1, y, 'P');
				Navio n3 = new Navio(x + 2, y, 'P');
				Navio n4 = new Navio(x + 3, y, 'P');
				Navio n5 = new Navio(x + 4, y, 'P');
				insereCelula(n1);
				insereCelula(n2);
				insereCelula(n3);
				insereCelula(n4);
				insereCelula(n5);
				PortaAviao pa = new PortaAviao(n1, n2, n3, n4, n5);
				setPortaAviao(pa);
				// TESTE
				System.out.println("inseriu :" + n1.tipo);
				return true;
			}
			return false;
		}
		return false;
	}

	public boolean insereArmadilha(int x, int y) {
		if (celulaMar[x][y] == null) {
			Armadilha a = new Armadilha(x, y, 'A');
			insereCelula(a);
			// TESTE
			System.out.println("inseriu :" + a.tipo);
			return true;
		}
		return false;
	}

	public boolean insereBauDoTesouro(int x, int y) {
		if (celulaMar[x][y] == null) {
			BauDoTesouro b = new BauDoTesouro(x, y, 'B');
			insereCelula(b);
			// TESTE
			System.out.println("inseriu :" + b.tipo);
			return true;
		}
		return false;
	}

	public void setMar(Celula[][] mar) {
		this.celulaMar = mar;
	}

	public void setSubmarino(Submarino sub) {
		if (sub1 == null)
			this.sub1 = sub;
		else if (sub2 == null)
			this.sub2 = sub;
		else
			this.sub3 = sub;
	}

	public void setCruzeiro(Cruzeiro cruz) {
		if (cruz1 == null)
			this.cruz1 = cruz;
		else
			this.cruz2 = cruz;
	}

	public void setNavioTanque(NavioTanque tank) {
		if (tank1 == null)
			this.tank1 = tank;
		else
			this.tank2 = tank;
	}

	public void setPortaAviao(PortaAviao pa) {
		this.pa = pa;
	}

	public Celula[][] getMar() {
		return celulaMar;
	}

	public char getTipoCelula(int coluna, int linha) {

		if (!(celulaMar[coluna][linha] == null))
			return celulaMar[coluna][linha].tipo;
		else
			return '-';
	}

}
