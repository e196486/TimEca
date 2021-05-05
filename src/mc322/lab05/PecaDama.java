package mc322.lab05;

public class PecaDama extends Peca {

	public PecaDama(int x, int y) {
		super(x, y);
	}

	/*
	 * damas se movem qualquer número de casas na diagonal para frente ou para trás,
	 * contanto que a diagonal esteja desimpedida e seja o seu lance.
	 */

	public Trajetoria TestaPeca(Trajetoria trajeto) {
		char inimigoDama = ' ';
		char inimigoPeao = ' ';

		String Direcao = trajeto.Direcao;
		String Caminho = trajeto.Caminho;

		char[] posicao = new char[Caminho.length()];

		for (int i = 0; i < Caminho.length(); i++) {
			posicao[i] = Caminho.charAt(i);
		}

		trajeto.TipoPeca = posicao[0];

		if (trajeto.TipoPeca == 'P') {
			inimigoDama = 'B';
			inimigoPeao = 'b';
		} else if (trajeto.TipoPeca == 'B') {
			inimigoDama = 'P';
			inimigoPeao = 'p';
		}

		// anda
		for (int i = 0; i < posicao.length; i++) {
			if (posicao[i] == '-')
				trajeto.Possivel = true;
		}

		// come
		if (posicao[posicao.length - 1] == '-'
				&& (posicao[posicao.length - 2] == inimigoPeao || posicao[posicao.length - 2] == inimigoDama)) {
			trajeto.Possivel = true;

			if (Direcao.compareTo("Sudoeste") == 0) {
				trajeto.PosicaoInimigo[0] = trajeto.cSource;
				trajeto.PosicaoInimigo[0].linha = trajeto.cSource.linha - 1;
				trajeto.PosicaoInimigo[0].coluna = trajeto.cSource.coluna - 1;

			} else if (Direcao.compareTo("Sudeste_") == 0) {
				trajeto.PosicaoInimigo[0] = trajeto.cSource;
				trajeto.PosicaoInimigo[0].linha = trajeto.cSource.linha - 1;
				trajeto.PosicaoInimigo[0].coluna = trajeto.cSource.coluna + 1;

			} else if (Direcao.compareTo("Nordeste") == 0) {
				trajeto.PosicaoInimigo[0] = trajeto.cSource;
				trajeto.PosicaoInimigo[0].linha = trajeto.cSource.linha + 1;
				trajeto.PosicaoInimigo[0].coluna = trajeto.cSource.coluna + 1;

			} else if (Direcao.compareTo("Noroeste") == 0) {
				trajeto.PosicaoInimigo[0] = trajeto.cSource;
				trajeto.PosicaoInimigo[0].linha = trajeto.cSource.linha + 1;
				trajeto.PosicaoInimigo[0].coluna = trajeto.cSource.coluna - 1;

			}

			for (int i = posicao.length - 3; i > 0; i--) {
				if (posicao[i] != '-')
					trajeto.Possivel = false;
			}
		}

		return trajeto;
	}

	public String TipodePeca() {
		return "Dama";
	}
}