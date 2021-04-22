package mc322.lab05;

public class PecaPeao {
    PecaPeao NO = null,
    		 NE = null,
    		 SO = null,
    		 SE = null;
    char P;
    
    public void pecaNO(PecaPeao pc) {
        NO = pc;
    }
    public void pecaNE(PecaPeao pc) {
        NE = pc;
    }
    public void pecaSO(PecaPeao pc) {
        SO = pc;
    }
    public void pecaSE(PecaPeao pc) {
    	SE = pc;
    }

    public void pecaComida() {
        P = '-';
    } 
}