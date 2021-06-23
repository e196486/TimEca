package marComponent.Celula;
 

public class Agua extends Celula{
	 
	private static final long serialVersionUID = 7753065336797036453L;

	public Agua(int linha, int coluna, char tipo) {
		this.linha = linha;
		this.coluna = coluna;
		celulaRevelada = false;
		this.tipo = tipo;
		//imagem = agua normal
	}
	
	public char explode( ) {
		setCelulaRevelada(true);
		//imagem = splash
		return tipo;
	}
}
