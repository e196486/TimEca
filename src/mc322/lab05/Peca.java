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
    
    public boolean TestaPeca(char TipoSource, Coordenada Ctarget) {
    	if (TipoSource == 'p') {
    		if (Sudoeste != null) {
	        	if (((Ctarget.linha == Sudoeste.coordenada.linha)&&(Ctarget.coluna == Sudoeste.coordenada.coluna)))
	        		if (Sudoeste.P == '-')
	        			return true;
	        	if (Sudoeste.Sudoeste != null)
	        		if (((Ctarget.linha == Sudoeste.Sudoeste.coordenada.linha)&&(Ctarget.coluna == Sudoeste.Sudoeste.coordenada.coluna)))
	        			if ((Sudoeste.P == 'b' || Sudoeste.P == 'B') && (Sudoeste.Sudoeste.P == '-'))
	        				return true;
    		}
    		else if (Sudeste != null) {
	    		if (((Ctarget.linha == Sudeste.coordenada.linha)&&(Ctarget.coluna == Sudeste.coordenada.coluna)))
	    			if (Sudeste.P == '-')
	    				return true;
	    		if (Sudeste.Sudeste != null)
					if (((Ctarget.linha == Sudeste.Sudeste.coordenada.linha)&&(Ctarget.coluna == Sudeste.Sudeste.coordenada.coluna)))
						if ((Sudeste.P == 'b' || Sudeste.P == 'B') && (Sudeste.Sudeste.P == '-'))
							return true;
    		}
        	return false;
    	}
    	else if (TipoSource == 'b') {
    		if (Noroeste != null)
    			if (((Ctarget.linha == Noroeste.coordenada.linha)&&(Ctarget.coluna == Noroeste.coordenada.coluna)))
    				if (Noroeste.P == '-')
    					return true;
    			if (Noroeste.Noroeste != null)
    				if (((Ctarget.linha == Noroeste.Noroeste.coordenada.linha)&&(Ctarget.coluna == Noroeste.Noroeste.coordenada.coluna)))
    	    			if ((Noroeste.P == 'b' || Noroeste.P == 'B') && (Noroeste.Noroeste.P == '-'))
    	    				return true;
    	    else if (Nordeste != null)
    	    	if (((Ctarget.linha == Nordeste.coordenada.linha)&&(Ctarget.coluna == Nordeste.coordenada.coluna)))
    	    		if (Nordeste.P == '-')
    	    			return true;
    			if (Nordeste.Nordeste != null)
    				if (((Ctarget.linha == Nordeste.Nordeste.coordenada.linha)&&(Ctarget.coluna == Nordeste.Nordeste.coordenada.coluna)))
    					if ((Nordeste.P == 'b' || Nordeste.P == 'B') && (Nordeste.Nordeste.P == '-'))
    						return true;
        	return false;
    	}
    	return false;
    }
}