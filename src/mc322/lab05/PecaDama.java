package mc322.lab05;

public class PecaDama {
	PecaDama NO = null,
    		 NE = null,
    		 SO = null,
    		 SE = null;
    char P;
    
    public void pecaNO(PecaDama pc) {
        NO = pc;
    }
    public void pecaNE(PecaDama pc) {
        NE = pc;
    }
    public void pecaSO(PecaDama pc) {
        SO = pc;
    }
    public void pecaSE(PecaDama pc) {
    	SE = pc;
    }

    public void pecaComida() {
        P = '-';
    } 
    
    
    public void TestaDama() {
    	
    }
    
    public void TestaTabuleiro() {
    	
    }
}