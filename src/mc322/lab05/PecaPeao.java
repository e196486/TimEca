package mc322.lab05;

public class PecaPeao extends Peca{
	
Coordenada coordenada = new Coordenada("a1");
	
	public PecaPeao(int x, int y) {
		super(x, y);
	}  
    
    /*pe�as comuns se movem uma casa na diagonal para frente somente se a 
      posi��o estiver livre e for o seu lance;
    */
    
    public  boolean TestaMovimento(Coordenada Ctarget) {

        return true;
    }
}