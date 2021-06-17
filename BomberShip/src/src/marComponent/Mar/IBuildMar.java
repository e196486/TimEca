package marComponent.Mar;

import java.awt.Component;

import controleComponent.Time;
import marComponent.Celula.Celula;

// A interface é essa, mas não sei mexer direito com ela
public interface IBuildMar {
	public Celula insereCelula(Celula c) throws Exception;
	public boolean insereSubmarino(int x, int y, String sentido) throws Exception;
	public boolean insereCruzeiro(int x, int y, String sentido) throws Exception;
	public boolean insereNavioTanque(int x, int y, String sentido) throws Exception;
	public boolean inserePortaAviao(int x, int y, String sentido) throws Exception;
	public boolean insereArmadilha(int x, int y) throws Exception;
	public boolean insereBauDoTesouro(int x, int y) throws Exception;
	public void setMar(Celula[][] mar, Time time);
	public Celula[][] getMar();
	public char getTipoCelula(int coluna, int linha);
	Component getcelulaMar(int coluna, int linha);
}
