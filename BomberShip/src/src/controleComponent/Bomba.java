package controleComponent;

public class Bomba {
	protected int n_dicas;
	protected boolean dicaEquip;
	
	public boolean temDica() {
		if (n_dicas > 0)
			return true;
		return false;
	}
	
	public void equipaDica(boolean dicaEquip) {
		this.dicaEquip = dicaEquip;
	}
	
	public boolean getDica() {
		if (dicaEquip)
			return true;
		return false;
	}
}
