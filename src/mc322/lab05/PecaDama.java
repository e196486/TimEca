package mc322.lab05;

public class PecaDama extends Peca{ 
	 
	
	public PecaDama(int x, int y) {
		super(x, y);
	}  
	
    
	/*damas se movem qualquer número de casas na diagonal para frente ou para trás,
contanto que a diagonal esteja desimpedida e seja o seu lance.*/  
	
    public  boolean TestaPeca(Peca pecaSource, Coordenada Ctarget) {
    	char amigoDama = '-',
    			amigoPeao = '-';
    	if (pecaSource.P == 'p' || pecaSource.P == 'P') {
    		amigoDama = 'P';
    		amigoPeao = 'p';
    		
    	}else if(pecaSource.P == 'b' || pecaSource.P == 'B') {
    		amigoDama = 'B';
    		amigoPeao = 'b';
    	}
    		
    		
 
    	if (Ctarget.linha < coordenada.linha && Ctarget.coluna < coordenada.coluna) {
    		
			if (Sudoeste != null) {
	        	if (((Ctarget.linha == Sudoeste.coordenada.linha)&&(Ctarget.coluna == Sudoeste.coordenada.coluna)))
	        		return (Sudoeste.P == '-'|| Sudoeste.P != amigoDama && Sudoeste.P != amigoPeao && Sudoeste.Sudoeste != null && Sudoeste.Sudoeste.P == '-');
	        	else
	        		return Sudoeste.TestaPeca(pecaSource, Ctarget);
			}
    	}
    	else if (Ctarget.linha < coordenada.linha && Ctarget.coluna > coordenada.coluna) {
			if (Sudeste != null) {
				if (((Ctarget.linha == Sudeste.coordenada.linha)&&(Ctarget.coluna == Sudeste.coordenada.coluna)))
	        		return (Sudeste.P == '-'|| Sudeste.P != amigoDama && Sudeste.P != amigoPeao && Sudeste.Sudeste != null && Sudeste.Sudeste.P == '-');
				else
					return Sudeste.TestaPeca(pecaSource, Ctarget);
			}
    	}
    	else if (Ctarget.linha > coordenada.linha && Ctarget.coluna < coordenada.coluna) {
			if (Noroeste != null) {
				if (((Ctarget.linha == Noroeste.coordenada.linha)&&(Ctarget.coluna == Noroeste.coordenada.coluna)))
	        		return (Noroeste.P == '-'|| (Noroeste.P != amigoDama && Noroeste.P != amigoPeao && Noroeste.Noroeste != null && Noroeste.Noroeste.P == '-'));
				else
					return Noroeste.TestaPeca(pecaSource, Ctarget);
			}
    	} else {
		    if (Nordeste != null) {
		    	if (((Ctarget.linha == Nordeste.coordenada.linha)&&(Ctarget.coluna == Nordeste.coordenada.coluna)))
	        		return (Nordeste.P == '-'|| Nordeste.P != amigoDama && Nordeste.P != amigoPeao && Nordeste.Nordeste != null && Nordeste.Nordeste.P == '-');
		    	else
		    		return Nordeste.TestaPeca(pecaSource, Ctarget);
		    }
    	}
    	return false;
    }

    public String TipodePeca() {
    	System.out.println("\n eh DAMA!!\n");
    	return "Dama";
    }
}