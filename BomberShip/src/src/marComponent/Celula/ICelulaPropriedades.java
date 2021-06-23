package marComponent.Celula;
 
import javax.swing.ImageIcon; 

public interface ICelulaPropriedades {
	public ImageIcon getImage();
	public char explode( );
	public boolean isCelulaRevelada();
	public void setCelulaRevelada(boolean celulaRevelada);
	public void dicaIlumina();
}
