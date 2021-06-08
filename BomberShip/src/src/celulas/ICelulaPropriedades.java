package celulas;

import java.awt.Image;

import bomba.Bomba;

public interface ICelulaPropriedades {
	public Image getImage();
	public void explode(Bomba bomba);
	public boolean isCelulaRevelada();
	public void setCelulaRevelada(boolean celulaRevelada);
	public void dicaIlumina();
}
