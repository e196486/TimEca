package marComponent.Celula;
 
import javax.swing.ImageIcon;

import controleComponent.Bomba;

public interface ICelulaPropriedades {
	public ImageIcon getImage();
	public void explode(Bomba bomba);
	public boolean isCelulaRevelada();
	public void setCelulaRevelada(boolean celulaRevelada);
	public void dicaIlumina();
}
