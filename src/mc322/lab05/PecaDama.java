package mc322.lab05;

public class PecaDama extends Peca{ 
	
Coordenada coordenada = new Coordenada("a1");
	
	public PecaDama(int x, int y) {
		super(x, y);
	}  
    
	/*damas se movem qualquer n�mero de casas na diagonal para frente ou para tr�s,
contanto que a diagonal esteja desimpedida e seja o seu lance.*/    
    public  boolean TestaPeca(String Movimento) {
    	
    return true;
    }
    
    
    public  boolean TestaTabuleiro(String Movimento) {

        return true;	
    }
}