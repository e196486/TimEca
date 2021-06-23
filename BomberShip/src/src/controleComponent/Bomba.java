package controleComponent;

public class Bomba {
	protected int n_dicas;
	protected int n_bombas;
	protected boolean seuTurno;
	protected boolean dicaEquip;
	
	public Bomba() {
		n_dicas = 1;
		n_bombas = 50;
	}
	
	public boolean temDica() {
		if (n_dicas > 0)
			return true;
		return false;
	}
	
	public void equipaDica() {
		if (temDica())
			this.dicaEquip = true;
	}
	
	public boolean dicaEquipada() {
		if (dicaEquip)
			return true;
		return false;
	}
	public int getBombas() {
		return n_bombas;
	}
	public void setTurno (boolean turno) {
		seuTurno = turno;
	}
	public Boolean getTurno () {
		return seuTurno;
	}
}
