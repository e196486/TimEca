package mc322.lab05;

public class PecaDama extends Peca{ 
	
Coordenada coordenada = new Coordenada("a1");
	
	public PecaDama(int x, int y) {
		super(x, y);
	}  
	
    
	/*damas se movem qualquer número de casas na diagonal para frente ou para trás,
contanto que a diagonal esteja desimpedida e seja o seu lance.*/  
	
    public  boolean TestaPeca(char TipoSource, Coordenada Ctarget) {
    	if (Ctarget.linha < coordenada.linha && Ctarget.coluna < coordenada.coluna) {
			if (Sudoeste != null) {
	        	if (((Ctarget.linha == Sudoeste.coordenada.linha)&&(Ctarget.coluna == Sudoeste.coordenada.coluna)))
	        		return (Sudoeste.P == '-'|| Sudoeste.P != 'P' && Sudoeste.P != 'p' && Sudoeste.Sudoeste != null && Sudoeste.Sudoeste.P == '-');
	        	else
	        		return Sudoeste.TestaPeca(TipoSource, Ctarget);
			}
    	}
    	else if (Ctarget.linha < coordenada.linha && Ctarget.coluna > coordenada.coluna) {
			if (Sudeste != null) {
				if (((Ctarget.linha == Sudeste.coordenada.linha)&&(Ctarget.coluna == Sudeste.coordenada.coluna)))
	        		return (Sudeste.P == '-'|| Sudeste.P != 'P' && Sudeste.P != 'p' && Sudeste.Sudeste != null && Sudeste.Sudeste.P == '-');
				else
					return Sudeste.TestaPeca(TipoSource, Ctarget);
			}
    	}
    	else if (Ctarget.linha > coordenada.linha && Ctarget.coluna < coordenada.coluna) {
			if (Noroeste != null) {
				if (((Ctarget.linha == Noroeste.coordenada.linha)&&(Ctarget.coluna == Noroeste.coordenada.coluna)))
	        		return (Noroeste.P == '-'|| Noroeste.P != 'B' && Noroeste.P != 'b' && Noroeste.Noroeste != null && Noroeste.Noroeste.P == '-');
				else
					return Noroeste.TestaPeca(TipoSource, Ctarget);
			}
    	} else {
		    if (Nordeste != null) {
		    	if (((Ctarget.linha == Nordeste.coordenada.linha)&&(Ctarget.coluna == Nordeste.coordenada.coluna)))
	        		return (Nordeste.P == '-'|| Nordeste.P != 'B' && Nordeste.P != 'b' && Nordeste.Nordeste != null && Nordeste.Nordeste.P == '-');
		    	else
		    		return Nordeste.TestaPeca(TipoSource, Ctarget);
		    }
    	}
    	return false;
    }
}