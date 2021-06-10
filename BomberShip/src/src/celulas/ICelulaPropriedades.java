package celulas;
 
import javax.swing.ImageIcon;
import bomba.Bomba;

public interface ICelulaPropriedades {
	public ImageIcon getImage();
	public void explode(Bomba bomba);
	public boolean isCelulaRevelada();
	public void setCelulaRevelada(boolean celulaRevelada);
	public void dicaIlumina();
}
