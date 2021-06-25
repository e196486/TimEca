package marComponent.Celula;
 


public class Armadilha extends Celula{
 
	private static final long serialVersionUID = -2852903771055441124L;

	public Armadilha(int linha, int coluna, char tipo) {
		this.linha = linha;
		this.coluna = coluna;
		celulaRevelada = false;
		this.tipo = tipo; 
	}
	
	public char explode( ) {
		setCelulaRevelada(true);
		setCelulaDestruida(true); 
		return tipo;
	}
	
	public char getTipo() {
		return tipo;
	}
}
