package mc322.lab05;

public class PecaDama {
	PecaDama Noroeste = null,
   		 	 Nordeste = null,
   		 	 Sudoeste = null,
   		 	 Sudeste = null;
	char P;
	Coordenada coordenada;
	
	public PecaDama(String Posicao) {
		this.coordenada = new Coordenada (Posicao);
	}
    
	public void pecaNoroeste(PecaDama pc) {
        Noroeste = pc;
    }
    public void pecaNordeste(PecaDama pc) {
        Nordeste = pc;
    }
    public void pecaSudoeste(PecaDama pc) {
        Sudoeste = pc;
    }
    public void pecaSudeste(PecaDama pc) {
    	Sudeste = pc;
    }

    public void pecaComida() {
        P = '-';
    } 
    
	/*damas se movem qualquer número de casas na diagonal para frente ou para trás,
contanto que a diagonal esteja desimpedida e seja o seu lance.*/    
    public  boolean TestaDama(String Movimento) {
    	
    return true;
    }
    
    
    public  boolean TestaTabuleiro(String Movimento) {

        return true;	
    }
}