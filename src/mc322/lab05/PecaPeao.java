package mc322.lab05;

public class PecaPeao extends Peca{
	
Coordenada coordenada = new Coordenada("a1");
	
	public PecaPeao(int x, int y) {
		super(x, y);
	}  
    
    /*peças comuns se movem uma casa na diagonal para frente somente se a 
      posição estiver livre e for o seu lance;
    */
	
    
    public boolean TestaPeca(Coordenada Ctarget) {
    	if (P == 'p') {
        	if (((Ctarget.linha == coordenada.linha+1)&&(Ctarget.coluna == coordenada.coluna-1)))
        		if (Sudoeste.P == '-')
        			return true;
    		else if (((Ctarget.linha == coordenada.linha+1)&&(Ctarget.coluna == coordenada.coluna+1)))
    			if (Sudeste.P == '-')
    				return true;
    		else if (((Ctarget.linha == coordenada.linha+2)&&(Ctarget.coluna == coordenada.coluna-2)))
    			if (Sudoeste.P == 'b' || Sudoeste.P == 'B')
    				return true;
			else if (((Ctarget.linha == coordenada.linha+2)&&(Ctarget.coluna == coordenada.coluna+2)))
    			if (Sudeste.P == 'b' || Sudeste.P == 'B')
    				return true;
        	return false;
    	}
    	else if (P == 'b') {
    		if (((Ctarget.linha == coordenada.linha-1)&&(Ctarget.coluna == coordenada.coluna-1)))
        		if (Noroeste.P == '-')
        			return true;
    		else if (((Ctarget.linha == coordenada.linha-1)&&(Ctarget.coluna == coordenada.coluna+1)))
    			if (Nordeste.P == '-')
    				return true;
    		else if (((Ctarget.linha == coordenada.linha-2)&&(Ctarget.coluna == coordenada.coluna-2)))
    			if (Noroeste.P == 'b' || Noroeste.P == 'B')
    				return true;
			else if (((Ctarget.linha == coordenada.linha-2)&&(Ctarget.coluna == coordenada.coluna+2)))
    			if (Nordeste.P == 'b' || Nordeste.P == 'B')
    				return true;
        	return false;
    	}
    	return false;
    }
    
    public  boolean TestaMovimento(Coordenada Ctarget) {

        return true;
    }
}