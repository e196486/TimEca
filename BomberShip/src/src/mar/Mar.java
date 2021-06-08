package mar;

import celulas.*;
import celulas.Cruzeiro;
import celulas.NavioTanque;
import celulas.PortaAviao;
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
	
	public void insereCelula (Celula c) {
		int x = c.getLinha();
		int y = c.getColuna();
		mar[x][y] = c;
		if (y > 0) {
			c.esquerda = mar[x][y-1];
			if (c.esquerda != null)
				mar[x][y-1].direita = c;
		}
		if (y < 10) {
			c.direita = mar[x][y+1];
			if (c.direita != null)
				mar[x][y+1].esquerda = c;
		}
		if (x > 0) {
			c.cima = mar[x-1][y];
			if (c.cima != null)
				mar[x-1][y].baixo = c;
		}
		if (x < 10) {
			c.baixo = mar[x+1][y];
			if (c.baixo != null)
				mar[x+1][y].cima = c;
		}
	}
	
	public void insereSubmarino(int x, int y, String sentido) {
		if (mar[x][y] != null) {
			Navio n1 = new Navio(x, y);
			insereCelula(n1);
		}
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
