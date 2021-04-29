package mc322.lab05;

public class Tabuleiro {
	Peca tabuleiro[][] = new PecaPeao[10][10];
	Coordenada Csource;
	Coordenada Ctarget;

	public void inserePeca(int x, int y, char c) {
		if (y <= 9 && x < 9) {
			PecaPeao pc = new PecaPeao(x, y);
			tabuleiro[x][y] = pc;
			pc.P = c;
			if (y > 1 && x > 1) {
				pc.pecaSudoeste(tabuleiro[x - 1][y - 1]);
				if (tabuleiro[x - 1][y - 1] != null)
					tabuleiro[x - 1][y - 1].pecaNordeste(pc);
			} else
				pc.pecaSudoeste(null);
			if (y < 8 && x > 1) {
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
	}

	public void setTabuleiro() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 8; j++) {
				if ((j % 2 == 0 && i % 2 == 0) || (j % 2 != 0 && i % 2 != 0)) {
					inserePeca(i + 1, j, 'b');
				} else {
					inserePeca(i + 1, j, '-');
				}
			}
			inserePeca(i + 1, 8, '\n');
		}
		for (int i = 3; i < 5; i++) {
			for (int j = 0; j < 8; j++) {
				inserePeca(i + 1, j, '-');
			}
			inserePeca(i + 1, 8, '\n');
		}
		for (int i = 6; i <= 8; i++) {
			for (int j = 0; j <= 8; j++) {
				if ((j % 2 == 0 && i % 2 == 0) || (j % 2 != 0 && i % 2 != 0)) {
					inserePeca(i, j, 'p');
				} else {
					inserePeca(i, j, '-');
				}
			}
			inserePeca(i, 8, '\n');
		}
	}

	public String exportarArquivo() {
		return "xxxx";
	}
	
	public String imprimirTabuleiro() {
		String EstadoTabuleiro = "";

		for (int i = 8; i > 0; i--) {
			System.out.print(i);
			for (int j = 1; j < 8; j++) {

				System.out.print(" " + tabuleiro[i][j].P /* +"["+i+"]"+"["+j+"]" */);
				EstadoTabuleiro += " " + tabuleiro[i][j].P;
			}
			EstadoTabuleiro += "\n";

			System.out.println(" ");
		}
		System.out.print("  a b c d e f g \n\n");

		return (EstadoTabuleiro);

	}

	public void CapturaOponente(Peca Peca) {
		Peca.P = '-';
		// se meu oponente for inimigo , eu excluo ele.
	}

	public void solicitaMovimento(String Movimento) {
		// separa a String em duas coordenadas

		System.out.println("recebi o movimento e é:  " + Movimento);

		String Source = Movimento.substring(0, 2);
		String Target = Movimento.substring(3, 5);

		Csource = new Coordenada(Source);
		Ctarget = new Coordenada(Target);

		if (tabuleiro[Csource.linha][Csource.coluna].P == 'p' || 
				tabuleiro[Csource.linha][Csource.coluna].P == 'P') {
			solicitaMovimentoPreta(tabuleiro[Csource.linha][Csource.coluna], Ctarget);

		}
		if (tabuleiro[Csource.linha][Csource.coluna].P == 'b' || 
				tabuleiro[Csource.linha][Csource.coluna].P == 'B') {
			solicitaMovimentoBranca(tabuleiro[Csource.linha][Csource.coluna], Ctarget);

		}
	}

	public boolean solicitaMovimentoPreta(Peca Peca, Coordenada Ctarget) {
		boolean StatusMovimento = false;
		System.out.println("\n\n >> Estou movendo minha Peca preta");
		System.out.print("Meu Peca.coordenada.linha : " + Peca.coordenada.linha);
		System.out.println(" | Meu Ctarget.linha : " + Ctarget.linha);
		System.out.print("Meu Peca.coordenada.coluna : " + Peca.coordenada.coluna);
		System.out.println(" | Meu Ctarget.coluna : " + Ctarget.coluna);

		if (Peca.coordenada.linha == Ctarget.linha && Peca.coordenada.coluna == Ctarget.coluna) {
			if (Peca.P == '-') // só atribuo se a peça final é vazia.
				Peca.P = 'p';
			System.out.println("chegamos no target");
			return (true);

		} else {
			if (Peca.TestaPeca(Peca.Sudoeste.coordenada)) { /* "Movimento para Sudoeste" */

				if (Peca.TestaTabuleiro(Peca.Sudoeste.coordenada)) { /* "Movimento para Sudoeste" */

					System.out.println("pode mover para Sudoeste:" + Peca.Sudoeste.P);

					if (solicitaMovimentoPreta(Peca.Sudoeste, Ctarget))
						StatusMovimento = true;

					if (StatusMovimento) {
						if (Peca.P == 'b') // casa atras para comer
							CapturaOponente(Peca);

						if (Peca.P == 'p')
							Peca.P = '-';

						return (true);
					}
				}

			}

			if (Peca.TestaPeca(Peca.Sudeste.coordenada) && !StatusMovimento) { /* "Movimento para Sudeste " */
				if (Peca.TestaTabuleiro(Peca.Sudeste.coordenada)) { /* "Movimento para Sudeste " */
					if (solicitaMovimentoPreta(Peca.Sudoeste, Ctarget))
						StatusMovimento = true;
					if (StatusMovimento) {
						if (Peca.P == 'b') // casa atras para comer
							CapturaOponente(Peca);

						if (Peca.P == 'p')
							Peca.P = '-';

						return (true);
					}
				}

			}
			return (false);
		}
	}

	public boolean solicitaMovimentoBranca(Peca Peca, Coordenada Ctarget) {
		boolean StatusMovimento = false;
		System.out.println("\n\n >> Estou movendo minha peca branca");
		System.out.print("Meu Peca.coordenada.linha : " + Peca.coordenada.linha);
		System.out.println(" | Meu Ctarget.linha : " + Ctarget.linha);
		System.out.print("Meu Peca.coordenada.coluna : " + Peca.coordenada.coluna);
		System.out.println(" | Meu Ctarget.coluna : " + Ctarget.coluna);

		if (Peca.coordenada.linha == Ctarget.linha && Peca.coordenada.coluna == Ctarget.coluna) {
			if (Peca.P == '-') // só atribuo se a peça final é vazia.
				Peca.P = 'b';
			System.out.println("chegamos no target");
			return (true);

		} else {

			if (Peca.TestaPeca(Peca.Nordeste.coordenada)) { /* "Movimento para Nordeste" */

				if (Peca.TestaTabuleiro(Peca.Nordeste.coordenada)) { /* "Movimento para Nordeste" */

					System.out.println("pode mover para Nordeste:" + Peca.Nordeste.P);

					if (solicitaMovimentoBranca(Peca.Nordeste, Ctarget))
						StatusMovimento = true;

					if (StatusMovimento) {
						if (Peca.P == 'p') // casa atras para comer
							CapturaOponente(Peca);

						if (Peca.P == 'b')
							Peca.P = '-';

						return (true);
					}
				}

			}

			if (Peca.TestaPeca(Peca.Noroeste.coordenada) && !StatusMovimento) { /* "Movimento para Noroeste" */

				if (Peca.TestaTabuleiro(Peca.Noroeste.coordenada)) { /* "Movimento para Noroeste" */
					if (solicitaMovimentoBranca(Peca.Noroeste, Ctarget))
						StatusMovimento = true;
					if (StatusMovimento) {
						if (Peca.P == 'p') // casa atras para comer
							CapturaOponente(Peca);

						if (Peca.P == 'b')
							Peca.P = '-';

						return (true);
					}
				}

			}
			return (false);
		}
	}
}