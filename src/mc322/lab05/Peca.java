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
    
    public boolean TestaPeca(Peca PecaSource, Coordenada Ctarget) {
    	return true;
    }
    
    public String TipodePeca() {
    	return "";
    	
    }
}