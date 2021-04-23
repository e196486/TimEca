package mc322.lab05;

public class Tabuleiro {
	PecaPeao tabPeao[][] = new PecaPeao[8][9];
	PecaDama tabDama[][] = new PecaDama[8][9];
 
	Coordenada Ctarget;

	public void inserePeca(int x, int y, char c) {
		if (y <= 8 && x < 8) {
			PecaPeao pc = new PecaPeao("P4"); 
			// aqui ^^^  temos que passar o parametro recebido. coloquei "P4" como momentaneo
			//talvez arrumar de acordo com a coordenada
			tabPeao[x][y] = pc;
			pc.P = c;
			if (y > 0 && x > 0) {
				pc.pecaNoroeste(tabPeao[x - 1][y - 1]);
				if (tabPeao[x - 1][y - 1] != null)
					tabPeao[x - 1][y - 1].pecaSudeste(pc);
			} else
				pc.pecaNoroeste(null);
			if (y < 7 && x > 0) {
				pc.pecaNordeste(tabPeao[x - 1][y + 1]);
				if (tabPeao[x - 1][y + 1] != null)
					tabPeao[x - 1][y + 1].pecaSudoeste(pc);
			} else
				pc.pecaNoroeste(null);
			if (y > 0 && x < 7) {
				pc.pecaSudoeste(tabPeao[x + 1][y - 1]);
				if (tabPeao[x + 1][y - 1] != null)
					tabPeao[x + 1][y - 1].pecaNordeste(pc);
			} else
				pc.pecaSudoeste(null);
			if (y < 8 && x < 7) {
				pc.pecaSudeste(tabPeao[x + 1][y + 1]);
				if (tabPeao[x + 1][y + 1] != null)
					tabPeao[x + 1][y + 1].pecaNoroeste(pc);
			} else
				pc.pecaSudeste(null);
		}
	}

	public void setTabuleiro() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 8; j++) {
				if ((j % 2 == 0 && i % 2 == 0) || (j % 2 != 0 && i % 2 != 0)) {
					inserePeca(i, j, '-');
				} else {
					inserePeca(i, j, 'p');
				}
			}
			inserePeca(i, 8, '\n');
		}
		for (int i = 3; i < 5; i++) {
			for (int j = 0; j < 8; j++) {
				inserePeca(i, j, '-');
			}
			inserePeca(i, 8, '\n');
		}
		for (int i = 5; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if ((j % 2 == 0 && i % 2 == 0) || (j % 2 != 0 && i % 2 != 0)) {
					inserePeca(i, j, '-');
				} else {
					inserePeca(i, j, 'b');
				}
			}
			inserePeca(i, 8, '\n');
		}
	}

	public void printTab() {
		String tabuleiro = "";

		//System.out.println("Source: " + (char) (Ysource + 96) + Xsource);
		//System.out.println("Target: " + (char) (Ytarget + 96) + Xtarget);

		for (int i = 0; i < 8; i++) {
			tabuleiro = tabuleiro + (8 - i) + " ";
			for (int j = 0; j < 9; j++) {
				if (tabPeao[i][j] != null)
					tabuleiro = tabuleiro + Character.toString(tabPeao[i][j].P);
				if (j < 7)
					tabuleiro = tabuleiro + " ";
			}
		}
		tabuleiro = tabuleiro + "  a b c d e f g h\n";
		System.out.println(tabuleiro);
		return;
	}

	public void CapturaOponente() {

	}

	public void movePeca(String Movimento) {

	}

	public boolean movePeaoPreto(PecaPeao Peao, String Target) {
		boolean movimentoCorreto = false;
		
		Ctarget = new Coordenada(Target);
		
		if (Peao.coordenada.linha == Ctarget.linha && Peao.coordenada.coluna == Ctarget.coluna) {
			if (Peao.P == '-') // s� atribuo se a pe�a final � vazia.
				Peao.P = 'P';
			    return (true);

		} else {
			if (Peao.TestaPeao("Movimento para Sudoeste ")) {
				if (Peao.TestaTabuleiro("Movimento para Sudoeste ")) {
					movimentoCorreto = movePeaoPreto(Peao.Sudoeste, "P4");
					if (Peao.P == 'B' && movimentoCorreto) { // casa atras para comer
						CapturaOponente();
						return (true);
					} 
				}

			}
			if (Peao.TestaPeao("Movimento para Sudeste ")) {
				if (Peao.TestaTabuleiro("Movimento para Sudeste ")) {
					movimentoCorreto = movePeaoPreto(Peao.Sudoeste, "P4");
					if (Peao.P == 'B' && movimentoCorreto) { // casa atras para comer
						CapturaOponente();
						return (true);
					}
				}

			}
			return (false);
		}

	}
}