package mc322.lab05;

public class PecaDama extends Peca{ 
	
Coordenada coordenada = new Coordenada("a1");
	
	public PecaDama(int x, int y) {
		super(x, y);
	}  
    
	/*damas se movem qualquer número de casas na diagonal para frente ou para trás,
contanto que a diagonal esteja desimpedida e seja o seu lance.*/    
    public  boolean TestaPeca(Coordenada Ctarget) {
    	
    return true;
    }
    
    
    public  boolean TestaTabuleiro(Coordenada Ctarget) {

        return true;	
    }
    
    
    public boolean RegraDama(Peca Peca) {
    	if (Peca.P == 'p') {
    		if (Peca.coordenada.linha == 1 ) {
    			return true;
    		} 
    	}else if (Peca.P == 'b') {
    		if (Peca.coordenada.linha == 8 ) {
    			return true;
    		} 
    	}
    		return false; 
    }
}