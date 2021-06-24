package marComponent.Celula;

public class BauDoTesouro extends Celula{
	 
	private static final long serialVersionUID = 8168356839341780713L;

	public BauDoTesouro(int x, int y, char tipo) {
		this.linha = x;
		this.coluna = y;
		celulaRevelada = false;
		this.tipo = tipo;
		//imagem =
	}
	
	public char getTipo() {
		return tipo;
	}
	
	public char explode( ) {
		setCelulaRevelada(true);
		setCelulaDestruida(true);
		return tipo;
	}
}
