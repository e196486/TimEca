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
    
    public boolean TestaPeca(Coordenada Ctarget) {
    	if (P == 'p') {
    		if (Sudoeste != null) {
	        	if (((Ctarget.linha == coordenada.linha+1)&&(Ctarget.coluna == coordenada.coluna-1)))
	        		if (Sudoeste.P == '-')
	        			return true;
	        	if (Sudoeste.Sudoeste != null)
	        		if (((Ctarget.linha == coordenada.linha+2)&&(Ctarget.coluna == coordenada.coluna-2)))
	        			if (Sudoeste.P == 'b' || Sudoeste.P == 'B')
	        				return true;
    		}
    		else if (Sudeste != null) {
	    		if (((Ctarget.linha == coordenada.linha+1)&&(Ctarget.coluna == coordenada.coluna+1)))
	    			if (Sudeste.P == '-')
	    				return true;
	    		if (Sudeste.Sudeste != null)
					if (((Ctarget.linha == coordenada.linha+2)&&(Ctarget.coluna == coordenada.coluna+2)))
						if (Sudeste.P == 'b' || Sudeste.P == 'B')
							return true;
    		}
        	return false;
    	}
    	else if (P == 'b') {
    		if (Noroeste != null)
    			if (((Ctarget.linha == coordenada.linha-1)&&(Ctarget.coluna == coordenada.coluna-1)))
    				if (Noroeste.P == '-')
    					return true;
    			if (Noroeste.Noroeste != null)
    				if (((Ctarget.linha == coordenada.linha-2)&&(Ctarget.coluna == coordenada.coluna-2)))
    	    			if ((Noroeste.P == 'b' || Noroeste.P == 'B') && (Noroeste.Noroeste.P == '-'))
    	    				return true;
    	    else if (Nordeste != null)
    	    	if (((Ctarget.linha == coordenada.linha-1)&&(Ctarget.coluna == coordenada.coluna+1)))
    	    		if (Nordeste.P == '-')
    	    			return true;
    			if (Nordeste.Nordeste != null)
    				if (((Ctarget.linha == coordenada.linha-2)&&(Ctarget.coluna == coordenada.coluna+2)))
    					if ((Nordeste.P == 'b' || Nordeste.P == 'B') && (Nordeste.Nordeste.P == '-'))
    						return true;
        	return false;
    	}
    	return false;
    }
    
    public  boolean TestaMovimento(Coordenada Ctarget) {
    	
        return true;
    }
}