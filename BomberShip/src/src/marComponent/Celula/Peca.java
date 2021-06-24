package marComponent.Celula;

import java.awt.Font;

import controleComponent.Bomba;
import marComponent.Pecas.Navio;

public class Peca extends Celula {

	private static final long serialVersionUID = -137272376822387627L;
	
	private Navio navio;

	public Peca(int linha, int coluna, char tipo) {
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
	
	public void setNavio(Navio navio) {
		this.navio = navio;
	}
	
	public Navio getNavio() {
		return navio;
	}
}
