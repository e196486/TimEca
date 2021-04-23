package mc322.lab05;

public class Tabuleiro {
	PecaPeao tabPeao[][] = new PecaPeao[9][9];
	PecaDama tabDama[][] = new PecaDama[9][9];
	Coordenada Csource;
	Coordenada Ctarget;

	public void inserePeca(int x, int y, char c) {
		if (y <= 8 && x < 8) {
			PecaPeao pc = new PecaPeao("P4"); 
			// aqui ^^^  temos que passar o parametro recebido. coloquei "P4" como momentaneo
			//talvez arrumar de acordo com a coordenada
			tabPeao[x][y] = pc;
			pc.P = c;
			if (y > 0 && x > 0) {
				pc.pecaSudoeste(tabPeao[x - 1][y - 1]);
				if (tabPeao[x - 1][y - 1] != null)
					tabPeao[x - 1][y - 1].pecaNordeste(pc);
			} else
				pc.pecaSudoeste(null);
			if (y < 7 && x > 0) {
				pc.pecaSudeste(tabPeao[x - 1][y + 1]);
				if (tabPeao[x - 1][y + 1] != null)
					tabPeao[x - 1][y + 1].pecaNoroeste(pc);
			} else
				pc.pecaSudoeste(null);
			if (y > 0 && x < 7) {
				pc.pecaNoroeste(tabPeao[x + 1][y - 1]);
				if (tabPeao[x + 1][y - 1] != null)
					tabPeao[x + 1][y - 1].pecaSudeste(pc);
			} else
				pc.pecaNoroeste(null);
			if (y < 8 && x < 7) {
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
					inserePeca(i+1, j, '-');
				} else {
					inserePeca(i+1, j, 'b');
				}
			}
			inserePeca(i+1, 8, '\n');
		}
		for (int i = 3; i < 5; i++) {
			for (int j = 0; j < 8; j++) {
				inserePeca(i+1, j, '-');
			}
			inserePeca(i+1, 8, '\n');
		}
		for (int i = 5; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if ((j % 2 == 0 && i % 2 == 0) || (j % 2 != 0 && i % 2 != 0)) {
					inserePeca(i+1, j, '-');
				} else {
					inserePeca(i+1, j, 'p');
				}
			}
			inserePeca(i+1, 8, '\n');
		}
	}

	public String printTab() {
		String EstadoTabuleiro = "";

 
		for (int i = 7; i > 0; i--) {
			System.out.print(i);
			for (int j = 1; j < 8; j++) {

				System.out.print(" "+ tabPeao[i][j].P /*+"["+i+"]"+"["+j+"]"*/);
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
		//separa a String em duas coordenadas 
		
		System.out.println("recebi o movimento e é:  " + Movimento);
		
		String Source = Movimento.substring(0, 2);
		String Target = Movimento.substring(3, 5);
		System.out.println("Meu Souce é :" + Source);
		System.out.println("Meu Target é : " + Target);
		
		Csource = new Coordenada(Source);
	    Ctarget = new Coordenada(Target);
	    System.out.println("Meu Csource.linha é : " + Csource.linha);
	    System.out.println("Meu Csource.coluna é : " + Csource.coluna);
	    tabPeao[Csource.linha][Csource.coluna].P = 'X';
	    tabPeao[Csource.linha][Csource.coluna].Nordeste.P = '1';
	    tabPeao[Csource.linha][Csource.coluna].Noroeste.P = '2';
	    tabPeao[Csource.linha][Csource.coluna].Sudeste.P = '3';
	    tabPeao[Csource.linha][Csource.coluna].Sudoeste.P = '4';
	    printTab();
	    
		if (tabPeao[Csource.coluna][Csource.linha].P =='P') { //Se a peça for um peao preto, vai 
			movePeaoPreto (tabPeao[Csource.coluna][Csource.linha], Ctarget);

			System.out.println("Estou movendo meu peao preto");
		}

	}

	public boolean movePeaoPreto(PecaPeao Peao, Coordenada Ctarget) {
		boolean movimentoCorreto = false;
		
		
		if (Peao.coordenada.linha == Ctarget.linha && Peao.coordenada.coluna == Ctarget.coluna) {
			if (Peao.P == '-') // só atribuo se a peça final é vazia.
				Peao.P = 'P';
			    return (true);

		} else {
			if (Peao.TestaPeao("Movimento para Sudoeste ")) {
				if (Peao.TestaTabuleiro("Movimento para Sudoeste ")) {
					movimentoCorreto = movePeaoPreto(Peao.Sudoeste, Ctarget);
					if (Peao.P == 'B' && movimentoCorreto) { // casa atras para comer
						CapturaOponente();
						return (true);
					} 
				}

			}
			if (Peao.TestaPeao("Movimento para Sudeste ")) {
				if (Peao.TestaTabuleiro("Movimento para Sudeste ")) {
					movimentoCorreto = movePeaoPreto(Peao.Sudoeste, Ctarget);
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