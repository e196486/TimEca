package mc322.lab05;

public class Tabuleiro {
	Peca tabuleiro[][] = new Peca[10][10];
	Coordenada Csource;
	Coordenada Ctarget;

	public Peca inserePeca(int x, int y, char c) {
		Peca pc = null;
		if (y <= 9 && x < 9) {
			pc = new PecaPeao(x, y);
			tabuleiro[x][y] = pc;
			pc.P = c;
			if (y > 1 && x > 1) {
				pc.pecaSudoeste(tabuleiro[x - 1][y - 1]);
				if (tabuleiro[x - 1][y - 1] != null)
					tabuleiro[x - 1][y - 1].pecaNordeste(pc);
			} else
				pc.pecaSudoeste(null);
			if (y < 9 && x > 1) {
				pc.pecaSudeste(tabuleiro[x - 1][y + 1]);
				if (tabuleiro[x - 1][y + 1] != null)
					tabuleiro[x - 1][y + 1].pecaNoroeste(pc);
			} else
				pc.pecaSudoeste(null);
			if (y > 1 && x < 8) {
				pc.pecaNoroeste(tabuleiro[x + 1][y - 1]);
				if (tabuleiro[x + 1][y - 1] != null)
					tabuleiro[x + 1][y - 1].pecaSudeste(pc);
			} else
				pc.pecaNoroeste(null);
			if (y < 9 && x < 8) {
				pc.pecaNordeste(tabuleiro[x + 1][y + 1]);
				if (tabuleiro[x + 1][y + 1] != null)
					tabuleiro[x + 1][y + 1].pecaSudoeste(pc);
			} else
				pc.pecaNordeste(null);
		}
		return (pc);
	}

	public void setTabuleiro() {
		for (int i = 0; i < 3; i++) {
			for (int j = 1; j <= 9; j++) {
				if ((j % 2 == 0 && i % 2 == 0) || (j % 2 != 0 && i % 2 != 0)) {
					inserePeca(i + 1, j, 'b');
				} else {
					inserePeca(i + 1, j, '-');
				}
			}
			inserePeca(i + 1, 9, '\n');
		}
		for (int i = 3; i < 5; i++) {
			for (int j = 1; j <= 9; j++) {
				inserePeca(i + 1, j, '-');
			}
			inserePeca(i + 1, 9, '\n');
		}
		for (int i = 6; i <= 8; i++) {
			for (int j = 1; j <= 9; j++) {
				if ((j % 2 == 0 && i % 2 != 0) || (j % 2 != 0 && i % 2 == 0)) {
					inserePeca(i, j, 'p');
				} else {
					inserePeca(i, j, '-');
				}
			}
			inserePeca(i, 9, '\n');
		}
	}

	public String exportarArquivo() {
		return "xxxx";
	}

	public String imprimirTabuleiro() {
		String EstadoTabuleiro = "";

		for (int i = 8; i > 0; i--) {
			System.out.print(i);
			for (int j = 1; j <= 9; j++) {

				System.out.print(" " + tabuleiro[i][j].P);
				EstadoTabuleiro += " " + tabuleiro[i][j].P;
			}

		}
		System.out.print("  a b c d e f g h \n");

		return (EstadoTabuleiro);

	}

	public void CapturaOponente(Peca Peca) {
		Peca.P = '-';
		// se meu oponente for inimigo , eu excluo ele.
	}

	public boolean RegraDama(Peca Peca) {
		return ((Peca.P == 'p' && Peca.coordenada.linha == 1) || (Peca.P == 'b' && Peca.coordenada.linha == 8));
	}

	public Peca CriaDama(Peca Peca) {
		char cor = Peca.P;

		Peca pDama = new PecaDama(Peca.coordenada.linha, Peca.coordenada.coluna);

		tabuleiro[Peca.coordenada.linha][Peca.coordenada.coluna] = pDama;

		pDama.Nordeste = Peca.Nordeste;
		if (pDama.Nordeste != null)
			pDama.Nordeste.Sudeste = pDama;
		pDama.Noroeste = Peca.Noroeste;
		if (pDama.Noroeste != null)
			pDama.Noroeste.Sudoeste = pDama;
		pDama.Sudeste = Peca.Sudeste;
		if (pDama.Sudeste != null)
			pDama.Sudeste.Noroeste = pDama;
		pDama.Sudoeste = Peca.Sudoeste;
		if (pDama.Sudoeste != null)
			pDama.Sudoeste.Nordeste = pDama;

		if (cor == 'p' || cor == 'P')
			pDama.P = 'P';
		if (cor == 'b' || cor == 'B')
			pDama.P = 'B';

		System.out.println("CRIEI DAMA HEIN \n");
		System.out.println("Peca.coordenada.linha : " + pDama.coordenada.linha);
		System.out.println("Peca.coordenada.coluna : " + pDama.coordenada.coluna);
		return (pDama);
	}

	public void solicitaMovimento(String Movimento) {
		boolean StatusMovimento = false;
		// separa a String em duas coordenadas

		System.out.println("recebi o movimento e é:  " + Movimento);

		String Source = Movimento.substring(0, 2);
		String Target = Movimento.substring(3, 5);

		Csource = new Coordenada(Source);
		Ctarget = new Coordenada(Target);

		Peca PecaSource = tabuleiro[Csource.linha][Csource.coluna];
		Peca PecaTarget = tabuleiro[Ctarget.linha][Ctarget.coluna];

		StatusMovimento = movePeca(PecaSource, PecaSource, Ctarget);

		if (StatusMovimento && RegraDama(PecaTarget))
			CriaDama(PecaTarget);
		// PecaTarget.TestaPeca(PecaSource, Ctarget);

	}

	private boolean movePeca(Peca pecaSource, Peca Peca, Coordenada Ctarget) {
		boolean StatusMovimento = false;
		char PecaAux = ' ';
		// linha de debug
		System.out.println("\n >> Estou movendo minha Peca" + "\nPeca.coordenada.linha : " + Peca.coordenada.linha
				+ " | Ctarget.linha : " + Ctarget.linha + "\nPeca.coordenada.coluna : " + Peca.coordenada.coluna
				+ " | Ctarget.coluna : " + Ctarget.coluna);

		if (Peca.coordenada.linha == Ctarget.linha && Peca.coordenada.coluna == Ctarget.coluna) {
			if (Peca.P == '-' || Peca.TipodePeca() == "Dama") { // só atribuo se a peça final é vazia.
				Peca.P = pecaSource.P;
				pecaSource.P = '-';
				System.out.println("\nchegamos no target");
				return true;
			} else {
				System.out.println("Jogada Impossível");
				return false;
			}

		} else {
			if (Peca.Sudoeste != null)
				if (!StatusMovimento && Peca.TestaPeca(pecaSource, Peca.Sudoeste.coordenada)) {

					/* movimento falso */
					System.out.println("indo para Sudoeste. Tabuleiro : \n");

					if (pecaSource.P == 'P' || pecaSource.P == 'B') {

						PecaAux = Peca.Sudoeste.P;
						Peca.Sudoeste.P = pecaSource.P;
						Peca.Sudoeste = CriaDama(Peca.Sudoeste);
					}
					/*----------*/

					StatusMovimento = movePeca(pecaSource, Peca.Sudoeste, Ctarget);

					/* retira movimento falso */
					if (!StatusMovimento && pecaSource.P == 'P' || pecaSource.P == 'B') {
						Peca.Sudoeste = inserePeca(Peca.Sudoeste.coordenada.linha, Peca.Sudoeste.coordenada.coluna,
								Peca.Sudoeste.P);
						Peca.Sudoeste.P = PecaAux;
					}
					/*---*/

				}
			if (Peca.Sudeste != null)
				if (!StatusMovimento && Peca.TestaPeca(pecaSource, Peca.Sudeste.coordenada)) {

					/* movimento falso */
					System.out.println("indo para Sudeste. Tabuleiro : \n");

					if (pecaSource.P == 'P' || pecaSource.P == 'B') {

						PecaAux = Peca.Sudeste.P;
						Peca.Sudeste.P = pecaSource.P;
						Peca.Sudeste = CriaDama(Peca.Sudeste);
					}
					/*----------*/

					StatusMovimento = movePeca(pecaSource, Peca.Sudeste, Ctarget);

					/* retira movimento falso */
					if (!StatusMovimento && pecaSource.P == 'P' || pecaSource.P == 'B') {
						Peca.Sudeste = inserePeca(Peca.Sudeste.coordenada.linha, Peca.Sudeste.coordenada.coluna,
								Peca.Sudeste.P);
						Peca.Sudeste.P = PecaAux;
					}
					/*---*/

				}
			if (Peca.Nordeste != null && ((Ctarget.linha >= Peca.Nordeste.coordenada.linha)&&(Ctarget.coluna >= Peca.Nordeste.coordenada.coluna)))
				if (!StatusMovimento && Peca.TestaPeca(pecaSource, Peca.Nordeste.coordenada)) {

					/* movimento falso */
					System.out.println("indo para Nordeste. Tabuleiro : \n");

					if (pecaSource.TipodePeca()=="Dama") {
						PecaAux = Peca.Nordeste.P;
						if (Peca.Noroeste.P == '-')
						Peca.Nordeste.P = pecaSource.P;
						Peca.Nordeste = CriaDama(Peca.Nordeste);
					}
					imprimirTabuleiro();
					Peca.Nordeste.TipodePeca();

					/*----------*/

					StatusMovimento = movePeca(pecaSource, Peca.Nordeste, Ctarget);

					/* retira movimento falso */

					if (!StatusMovimento && pecaSource.TipodePeca()=="Dama") {
						Peca.Nordeste = inserePeca(Peca.Nordeste.coordenada.linha, Peca.Nordeste.coordenada.coluna,
								Peca.Nordeste.P);
						Peca.Nordeste.P = PecaAux;
						imprimirTabuleiro();
					}
					/*---*/

				}

			if (Peca.Noroeste != null && (((Ctarget.linha >= Peca.Nordeste.coordenada.linha)&&(Ctarget.coluna < Peca.Nordeste.coordenada.coluna))))
				if (!StatusMovimento && Peca.TestaPeca(pecaSource, Peca.Noroeste.coordenada)) {
					/* movimento falso */
					System.out.println("indo para Noroeste. Tabuleiro : \n");

					imprimirTabuleiro();
					if (pecaSource.TipodePeca()=="Dama") {
						PecaAux = Peca.Noroeste.P;
						if (Peca.Noroeste.P == '-')
							Peca.Noroeste.P = pecaSource.P;
						Peca.Noroeste = CriaDama(Peca.Noroeste);
					}
					/*----------*/
					StatusMovimento = movePeca(pecaSource, Peca.Noroeste, Ctarget);

					/* retira movimento falso */
					if (!StatusMovimento && pecaSource.TipodePeca()=="Dama") {
						Peca.Noroeste = inserePeca(Peca.Noroeste.coordenada.linha, Peca.Noroeste.coordenada.coluna,
								Peca.Noroeste.P);
						Peca.Noroeste.P = PecaAux;
					}
					/*---*/
				}
			if (StatusMovimento) {

				if (Peca.P != pecaSource.P) { // casa atras para comer
					CapturaOponente(Peca);
				}

				if (Peca.P == pecaSource.P && ((Peca.coordenada.linha != pecaSource.coordenada.linha)
						&& (Peca.coordenada.coluna != pecaSource.coordenada.coluna)))
					;
				Peca.P = '-';

				return (StatusMovimento);
			}
			System.out.println("não deu certo. voltando.");
			return (StatusMovimento);
		}
	}

}