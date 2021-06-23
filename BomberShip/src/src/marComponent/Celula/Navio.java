package marComponent.Celula;

import java.awt.Font; 

public class Navio extends Celula {

	private static final long serialVersionUID = -137272376822387627L;

	public Navio(int linha, int coluna, char tipo) {
		this.linha = linha;
		this.coluna = coluna;
		celulaRevelada = false;
		this.tipo = tipo;
	}

	public char explode() {
		setCelulaRevelada(true);
		this.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20)); 
		
		return tipo;
	}

	public char getTipo() {
		return tipo;
	}
}
