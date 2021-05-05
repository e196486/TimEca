package mc322.lab05;

public class Peca {
	Peca Noroeste = null, Nordeste = null, Sudoeste = null, Sudeste = null;
	char P;

	Coordenada coordenada = new Coordenada(null);

	public Peca(int x, int y) {
		this.coordenada.linha = x;
		this.coordenada.coluna = y;
	}

	public void pecaNoroeste(Peca pc) {
		Noroeste = pc;
	}

	public void pecaNordeste(Peca pc) {
		Nordeste = pc;
	}

	public void pecaSudoeste(Peca pc) {
		Sudoeste = pc;
	}

	public void pecaSudeste(Peca pc) {
		Sudeste = pc;
	}

	public Trajetoria TestaPeca(Trajetoria trajeto) {
		return trajeto;
	}

	public String TipodePeca() {
		return "";

	}
	
	public String leitura() {
		String cond = "";
		switch (coordenada.coluna) {
		case 1:
			cond = "a";
			break;
		case 2:
			cond = "b";
			break;
		case 3:
			cond = "c";
			break;
		case 4:
			cond = "d";
			break;
		case 5:
			cond = "e";
			break;
		case 6:
			cond = "f";
			break;
		case 7:
			cond = "g";
			break;
		case 8:
			cond = "h";
			break;
		}
		cond = cond + coordenada.linha;
		if (P == '-')
			cond = cond + "_";
		else if (P == 'p'|| P =='P')
			cond = cond + "p";
		else
			cond = cond + "b";
		return cond;
	}
}