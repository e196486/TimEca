package marComponent.Celula;

import java.awt.Font;

import controleComponent.Bomba;

public class Navio extends Celula {

	private static final long serialVersionUID = -137272376822387627L;

	public Navio(int linha, int coluna, char tipo) {
		this.linha = linha;
		this.coluna = coluna;
		celulaRevelada = false;
		this.tipo = tipo;
	}

	public void explode(Bomba bomba) {
		setCelulaRevelada(true);
		this.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20)); // depois trocar 
		
		// imagem = explosão
		// ganha pontos
	}

	public char getTipo() {
		return tipo;
	}
}
