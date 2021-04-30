package mc322.lab05;

public class PecaDama extends Peca{ 
	
Coordenada coordenada = new Coordenada("a1");
	
	public PecaDama(int x, int y) {
		super(x, y);
	}  
    
	/*damas se movem qualquer número de casas na diagonal para frente ou para trás,
contanto que a diagonal esteja desimpedida e seja o seu lance.*/  
    public  boolean TestaPeca(char TipoSource, Coordenada Ctarget) { 
    	if (TipoSource == 'P') {
	    	if (Sudoeste != null) {
		        if (((Ctarget.linha == Sudoeste.coordenada.linha)&&(Ctarget.coluna == Sudoeste.coordenada.coluna)))
		        	if (Sudoeste.P == '-')
		        		return true;
		        else if (Sudoeste.Sudoeste != null)
		        	if (((Ctarget.linha == Sudoeste.Sudoeste.coordenada.linha)&&(Ctarget.coluna == Sudoeste.Sudoeste.coordenada.coluna)))
		        		if ((Sudoeste.P == 'b' || Sudoeste.P == 'B') && (Sudoeste.Sudoeste.P == '-'))
		        			return true;
		        	else
		        		return Sudoeste.TestaPeca(TipoSource, Ctarget);
    		}
    		else if (Sudeste != null) {
	    		if (((Ctarget.linha == Sudeste.coordenada.linha)&&(Ctarget.coluna == Sudeste.coordenada.coluna)))
	    			if (Sudeste.P == '-')
	    				return true;
	    		else if (Sudeste.Sudeste != null)
					if (((Ctarget.linha == Sudeste.Sudeste.coordenada.linha)&&(Ctarget.coluna == Sudeste.Sudeste.coordenada.coluna)))
						if ((Sudeste.P == 'b' || Sudeste.P == 'B') && (Sudeste.Sudeste.P == '-'))
							return true;
				else
	        		return Sudeste.TestaPeca(TipoSource, Ctarget);
    		}
        	return false;
    	}
    	else if (TipoSource == 'B') {
    		if (Noroeste != null) {
    			if (((Ctarget.linha == Noroeste.coordenada.linha)&&(Ctarget.coluna == Noroeste.coordenada.coluna)))
    				if (Noroeste.P == '-')
    					return true;
    			else if (Noroeste.Noroeste != null)
    				if (((Ctarget.linha == Noroeste.Noroeste.coordenada.linha)&&(Ctarget.coluna == Noroeste.Noroeste.coordenada.coluna)))
    	    			if ((Noroeste.P == 'b' || Noroeste.P == 'B') && (Noroeste.Noroeste.P == '-'))
    	    				return true;
    			else
	        		return Noroeste.TestaPeca(TipoSource, Ctarget);
    		}
    	    else if (Nordeste != null) {
    	    	if (((Ctarget.linha == Nordeste.coordenada.linha)&&(Ctarget.coluna == Nordeste.coordenada.coluna)))
    	    		if (Nordeste.P == '-')
    	    			return true;
    	    	else if (Nordeste.Nordeste != null)
    				if (((Ctarget.linha == Nordeste.Nordeste.coordenada.linha)&&(Ctarget.coluna == Nordeste.Nordeste.coordenada.coluna)))
    					if ((Nordeste.P == 'b' || Nordeste.P == 'B') && (Nordeste.Nordeste.P == '-'))
    						return true;
				else
	        		return Nordeste.TestaPeca(TipoSource, Ctarget);
    	    }
        	return false;
    	}
    	return false;
    }
}