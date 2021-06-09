package mar;

import celulas.*; 
import pecas.*;

public class Mar {
	private Celula[][] mar;
	Submarino sub1;
	Submarino sub2;
	Submarino sub3;
	Cruzeiro cruz1;
	Cruzeiro cruz2;
	NavioTanque tank1;
	NavioTanque tank2;
	PortaAviao pa;
	
	
	//TODO : esse método está estourando os limites das celulas, aumentei para [11][11] como paleativo 
	public void insereCelula (Celula c) {
		int x = c.getLinha();
		int y = c.getColuna();
		mar[x][y] = c;
		if (y > 0) {
			c.esquerda = mar[x][y-1];
			if (c.esquerda != null)
				mar[x][y-1].direita = c;
		}
		if (y <= 10) {
			c.direita = mar[x][y+1];
			if (c.direita != null)
				mar[x][y+1].esquerda = c;
		}
		if (x > 0) {
			c.cima = mar[x-1][y];
			if (c.cima != null)
				mar[x-1][y].baixo = c;
		}
		if (x <= 10) {
			c.baixo = mar[x+1][y];
			if (c.baixo != null)
				mar[x+1][y].cima = c;
		}
	}
	
	public boolean insereSubmarino(int x, int y, String sentido) throws Exception{
		if (sentido == "h") {
			if (mar[x][y] != null && mar[x][y+1] != null) {
				Navio n1 = new Navio(x, y);
				Navio n2 = new Navio(x, y+1);
				insereCelula(n1);
				insereCelula(n2);
				Submarino sub = new Submarino(n1, n2);
				setSubmarino(sub);
				return true;
			}
			return false;
		}
		else if (sentido == "v") {
			if (mar[x][y] != null && mar[x+1][y] != null) {
				Navio n1 = new Navio(x, y);
				Navio n2 = new Navio(x+1, y);
				insereCelula(n1);
				insereCelula(n2);
				Submarino sub = new Submarino(n1, n2);
				setSubmarino(sub);
				return true;
			}
			return false;
		}
		return false;
	}
	
	public boolean insereCruzeiro(int x, int y, String sentido) throws Exception{
		if (sentido == "h") {
			if (mar[x][y] != null && mar[x][y+1] != null && mar[x][y+2] != null) {
				Navio n1 = new Navio(x, y);
				Navio n2 = new Navio(x, y+1);
				Navio n3 = new Navio(x, y+2);
				insereCelula(n1);
				insereCelula(n2);
				insereCelula(n3);
				Cruzeiro cruz = new Cruzeiro(n1, n2, n3);
				setCruzeiro(cruz);
				return true;
			}
			return false;
		}
		else if (sentido == "v") {
			if (mar[x][y] != null && mar[x+1][y] != null && mar[x+2][y] != null) {
				Navio n1 = new Navio(x, y);
				Navio n2 = new Navio(x+1, y);
				Navio n3 = new Navio(x+2, y);
				insereCelula(n1);
				insereCelula(n2);
				insereCelula(n3);
				Cruzeiro sub = new Cruzeiro(n1, n2, n3);
				setCruzeiro(sub);
				return true;
			}
			return false;
		}
		return false;
	}
	
	public boolean insereNavioTanque(int x, int y, String sentido) throws Exception{
		if (sentido == "h") {
			if (mar[x][y] != null && mar[x][y+1] != null && mar[x][y+2] != null && mar[x][y+3] != null) {
				Navio n1 = new Navio(x, y);
				Navio n2 = new Navio(x, y+1);
				Navio n3 = new Navio(x, y+2);
				Navio n4 = new Navio(x, y+3);
				insereCelula(n1);
				insereCelula(n2);
				insereCelula(n3);
				insereCelula(n4);
				NavioTanque nt = new NavioTanque(n1, n2, n3, n4);
				setNavioTanque(nt);
				return true;
			}
			return false;
		}
		else if (sentido == "v") {
			if (mar[x][y] != null && mar[x+1][y] != null && mar[x+2][y] != null && mar[x+3][y] != null) {
				Navio n1 = new Navio(x, y);
				Navio n2 = new Navio(x+1, y);
				Navio n3 = new Navio(x+2, y);
				Navio n4 = new Navio(x+3, y);
				insereCelula(n1);
				insereCelula(n2);
				insereCelula(n3);
				insereCelula(n4);
				NavioTanque nt = new NavioTanque(n1, n2, n3, n4);
				setNavioTanque(nt);
				return true;
			}
			return false;
		}
		return false;
	}
	
	public boolean inserePortaAviao(int x, int y, String sentido) throws Exception{
		if (sentido == "h") {
			if (mar[x][y] != null && mar[x][y+1] != null && mar[x][y+2] != null && mar[x][y+3] != null && mar[x][y+4] != null) {
				Navio n1 = new Navio(x, y);
				Navio n2 = new Navio(x, y+1);
				Navio n3 = new Navio(x, y+2);
				Navio n4 = new Navio(x, y+3);
				Navio n5 = new Navio(x, y+4);
				insereCelula(n1);
				insereCelula(n2);
				insereCelula(n3);
				insereCelula(n4);
				insereCelula(n5);
				PortaAviao pa = new PortaAviao(n1, n2, n3, n4, n5);
				setPortaAviao(pa);
				return true;
			}
			return false;
		}
		else if (sentido == "v") {
			if (mar[x][y] != null && mar[x+1][y] != null && mar[x+2][y] != null && mar[x+3][y] != null && mar[x+4][y] != null) {
				Navio n1 = new Navio(x, y);
				Navio n2 = new Navio(x+1, y);
				Navio n3 = new Navio(x+2, y);
				Navio n4 = new Navio(x+3, y);
				Navio n5 = new Navio(x+4, y);
				insereCelula(n1);
				insereCelula(n2);
				insereCelula(n3);
				insereCelula(n4);
				insereCelula(n5);
				PortaAviao pa = new PortaAviao(n1, n2, n3, n4, n5);
				setPortaAviao(pa);
				return true;
			}
			return false;
		}
		return false;
	}
	
	public boolean insereArmadilha(int x, int y) {
		if(mar[x][y] == null) {
			Armadilha a = new Armadilha(x, y);
			insereCelula(a);
			return true;
		}
		return false;
	}
	
	public boolean insereBauDoTesouro(int x, int y) {
		if(mar[x][y] == null) {
			BauDoTesouro a = new BauDoTesouro(x, y);
			insereCelula(a);
			return true;
		}
		return false;
	}
	
	public void setMar(Celula[][] mar) {
		this.mar = mar;
	}
	
	public void setSubmarino(Submarino sub) {
		if (sub1 == null)
			this.sub1 = sub;
		else if (sub2 == null)
			this.sub2 = sub;
		else
			this.sub3 = sub;
	}
	
	public void setCruzeiro (Cruzeiro cruz) {
		if (cruz1 == null)
			this.cruz1 = cruz;
		else
			this.cruz2 = cruz;
	}
	
	public void setNavioTanque (NavioTanque tank) {
		if (tank1 == null)
			this.tank1 = tank;
		else
			this.tank2 = tank;
	}
	
	public void setPortaAviao (PortaAviao pa) {
		this.pa = pa;
	}
	
	public Celula[][] getMar(){
		return mar;
	}
}
