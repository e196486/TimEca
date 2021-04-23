package mc322.lab05;

public class Tabuleiro {
	PecaPeao tabPeao[][] = new PecaPeao[10][10];
	PecaDama tabDama[][] = new PecaDama[10][10];
	Coordenada Csource;
	Coordenada Ctarget;

	public void inserePeca(int x, int y, char c) {
		if (y <= 9 && x < 9) {
			PecaPeao pc = new PecaPeao(x, y);
			tabPeao[x][y] = pc;
			pc.P = c;
			if (y > 1 && x > 1) {
				pc.pecaSudoeste(tabPeao[x - 1][y - 1]);
				if (tabPeao[x - 1][y - 1] != null)
					tabPeao[x - 1][y - 1].pecaNordeste(pc);
			} else
				pc.pecaSudoeste(null);
			if (y < 8 && x > 1) {
				pc.pecaSudeste(tabPeao[x - 1][y + 1]);
				if (tabPeao[x - 1][y + 1] != null)
					tabPeao[x - 1][y + 1].pecaNoroeste(pc);
			} else
				pc.pecaSudoeste(null);
			if (y > 1 && x < 8) {
				pc.pecaNoroeste(tabPeao[x + 1][y - 1]);
				if (tabPeao[x + 1][y - 1] != null)
					tabPeao[x + 1][y - 1].pecaSudeste(pc);
			} else
				pc.pecaNoroeste(null);
			if (y < 9 && x < 8) {
				pc.pecaNordeste(tabPeao[x + 1][y + 1]);
				if (tabPeao[x + 1][y + 1] != null)
					tabPeao[x + 1][y + 1].pecaSudoeste(pc);
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

	public String printTab() {
		String EstadoTabuleiro = "";

		for (int i = 8; i > 0; i--) {
			System.out.print(i);
			for (int j = 1; j < 8; j++) {

				System.out.print(" " + tabPeao[i][j].P /* +"["+i+"]"+"["+j+"]" */);
				EstadoTabuleiro += " " + tabPeao[i][j].P;
			}
			EstadoTabuleiro += "\n";

			System.out.println(" ");
		}
		System.out.print("  a b c d e f g \n\n");

		return (EstadoTabuleiro);

	}

	public void CapturaOponente() {

	}

	public void movePeca(String Movimento) {
		// separa a String em duas coordenadas

		System.out.println("recebi o movimento e é:  " + Movimento);

		String Source = Movimento.substring(0, 2);
		String Target = Movimento.substring(3, 5);

		Csource = new Coordenada(Source);
		Ctarget = new Coordenada(Target);

		if (tabPeao[Csource.linha][Csource.coluna].P == 'p') { // Se a peça for um peao preto, vai

			movePeaoPreto(tabPeao[Csource.linha][Csource.coluna], Ctarget);

		}

	}

	public boolean movePeaoPreto(PecaPeao Peao, Coordenada Ctarget) {
		boolean StatusMovimento = false;
		System.out.println("\n\n >> Estou movendo meu peao preto");
		System.out.print("Meu Peao.coordenada.linha : " + Peao.coordenada.linha);
		System.out.println(" | Meu Ctarget.linha : " + Ctarget.linha);
		System.out.print("Meu Peao.coordenada.coluna : " + Peao.coordenada.coluna);
		System.out.println(" | Meu Ctarget.coluna : " + Ctarget.coluna);

		if (Peao.coordenada.linha == Ctarget.linha && Peao.coordenada.coluna == Ctarget.coluna) {
			if (Peao.P == '-') // só atribuo se a peça final é vazia.
				Peao.P = 'P';
			System.out.println("chegamos no target");
			return (true);

		} else {

			if (Peao.TestaPeao("Movimento para Sudoeste")) {

				if (Peao.TestaTabuleiro("Movimento para Sudoeste")) {

					System.out.println("pode mover para Sudoeste:" + Peao.Sudoeste.P);

					if (movePeaoPreto(Peao.Sudoeste, Ctarget))
						StatusMovimento = true;

					if (StatusMovimento) {
						if (Peao.P == 'b') // casa atras para comer
							CapturaOponente();

						if (Peao.P == 'p')
							Peao.P = '-';
						
						return(true);
					}
				}

			}

			if (Peao.TestaPeao("Movimento para Sudeste ") && !StatusMovimento) {
				if (Peao.TestaTabuleiro("Movimento para Sudeste ")) {
					if (movePeaoPreto(Peao.Sudoeste, Ctarget))
						StatusMovimento = true;
					if (StatusMovimento) {
						if (Peao.P == 'b') // casa atras para comer
							CapturaOponente();

						if (Peao.P == 'p')
							Peao.P = '-';
						
						return(true);
					}
				}

			}
			return (false);
		}
	}
}