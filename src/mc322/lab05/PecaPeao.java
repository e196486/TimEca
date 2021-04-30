package mc322.lab05;

public class PecaPeao extends Peca{
	
Coordenada coordenada = new Coordenada("a1");
	
	public PecaPeao(int x, int y) {
		super(x, y);
	}  
    
    /*peças comuns se movem uma casa na diagonal para frente somente se a 
      posição estiver livre e for o seu lance;
    */
	public boolean TestaPeca(char TipoSource, Coordenada Ctarget) {
    	if (TipoSource == 'p') {
    		if (Sudoeste != null) {
	        	if (((Ctarget.linha == Sudoeste.coordenada.linha)&&(Ctarget.coluna == Sudoeste.coordenada.coluna)))
	        		return (Sudoeste.P == '-'|| Sudoeste.P != 'P' && Sudoeste.P != 'p' && Sudoeste.Sudoeste != null && Sudoeste.Sudoeste.P == '-');
    		}
    		if (Sudeste != null)
    			if (((Ctarget.linha == Sudeste.coordenada.linha)&&(Ctarget.coluna == Sudeste.coordenada.coluna)))
	        		return (Sudeste.P == '-'|| Sudeste.P != 'P' && Sudeste.P != 'p' && Sudeste.Sudeste != null && Sudeste.Sudeste.P == '-');
    	}
    	else if (TipoSource == 'b') {
    		if (Noroeste != null) {
    			if (((Ctarget.linha == Noroeste.coordenada.linha)&&(Ctarget.coluna == Noroeste.coordenada.coluna)))
	        		return (Noroeste.P == '-'|| Noroeste.P != 'B' && Noroeste.P != 'b' && Noroeste.Noroeste != null && Noroeste.Noroeste.P == '-');
    		}
    	    if (Nordeste != null) {
    	    	if (((Ctarget.linha == Nordeste.coordenada.linha)&&(Ctarget.coluna == Nordeste.coordenada.coluna)))
	        		return (Nordeste.P == '-'|| Nordeste.P != 'B' && Nordeste.P != 'b' && Nordeste.Nordeste != null && Nordeste.Nordeste.P == '-');
    	    }
    	}
    	return false;
    }
}