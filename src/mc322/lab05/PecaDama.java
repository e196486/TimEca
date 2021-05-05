package mc322.lab05;

public class PecaDama extends Peca{ 
	 
	
	public PecaDama(int x, int y) {
		super(x, y);
	}  
	
    
	/*damas se movem qualquer número de casas na diagonal para frente ou para trás,
contanto que a diagonal esteja desimpedida e seja o seu lance.*/  
	
	public Trajetoria TestaPeca(Trajetoria trajeto){ 
    	return trajeto;
    }

    public String TipodePeca() {
    	System.out.println("\n eh DAMA!!\n");
    	return "Dama";
    }
}