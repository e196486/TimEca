package mc322.lab05;

public class PecaPeao {
    PecaPeao Noroeste = null,
    		 Nordeste = null,
    		 Sudoeste = null,
    		 Sudeste = null;
    char P;
	Coordenada coordenada = new Coordenada("a1");
	
	public PecaPeao(int x, int y) {
		this.coordenada.linha = x;
		this.coordenada.coluna = y;
	}  
	
    public void pecaNoroeste(PecaPeao pc) {
        Noroeste = pc;
    }
    public void pecaNordeste(PecaPeao pc) {
        Nordeste = pc;
    }
    public void pecaSudoeste(PecaPeao pc) {
        Sudoeste = pc;
    }
    public void pecaSudeste(PecaPeao pc) {
    	Sudeste = pc;
    }

    public void pecaComida() {
        P = '-';
    }
    
    /*peças comuns se movem uma casa na diagonal para frente somente se a 
      posição estiver livre e for o seu lance;
    */
    
    public boolean TestaPeao(String Movimento) {

        return true;	
    }
    
    public  boolean TestaTabuleiro(String Movimento) {

        return true;
    }
}