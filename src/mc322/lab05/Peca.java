package mc322.lab05;

public class Peca {
    Peca Noroeste = null,
    	 Nordeste = null,
    	 Sudoeste = null,
    	 Sudeste = null;
    char P;
    
Coordenada coordenada = new Coordenada("a1");
	
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
    	String cord = "";
    	switch (coordenada.coluna) {
		case 1:
			cord = "a";
			break;
		case 2:
			cord = "b";
			break;
		case 3:
			cord = "c";
			break;
		case 4:
			cord = "d";
			break;
		case 5:
			cord = "e";
			break;
		case 6:
			cord = "f";
			break;
		case 7:
			cord = "g";
			break;
		case 8:
			cord = "h";
			break;
		}
    	cord = cord + coordenada.linha;
    	if (P == '-')
    		cord = cord + "_";
    	else if (P == 'p' || P == 'P')
    		cord = cord + "p";
    	else
    		cord = cord + "b";
    	return cord;
    }
}