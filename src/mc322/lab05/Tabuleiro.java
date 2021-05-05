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

	public void CapturaOponente(Coordenada Inimigo[]) {
		
		for (int i = 0; Inimigo[i]!= null ; i++)
			tabuleiro [Inimigo[i].linha][Inimigo[i].coluna].P = '-';
		
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
		 
		// separa a String em duas coordenadas

		System.out.println("recebi o movimento e é:  " + Movimento);

		String Source = Movimento.substring(0, 2);
		String Target = Movimento.substring(3, 5);

		Csource = new Coordenada(Source);
		Ctarget = new Coordenada(Target);

		Peca PecaSource = tabuleiro[Csource.linha][Csource.coluna];
		Peca PecaTarget = tabuleiro[Ctarget.linha][Ctarget.coluna];
		
		Trajetoria trajeto = new Trajetoria (PecaSource);
		
		trajeto = TraduzMovimento(PecaSource, Ctarget); 
		 
		System.out.println(">>>>>>>>>>>>>>>"+ trajeto.Direcao +":"+ trajeto.Caminho + "<<<<<<<<<<<<<<<<<<<<<");
		
		if (PecaSource.TestaPeca(trajeto).Possivel) {
			if (trajeto.PosicaoInimigo[0]!= null)
				CapturaOponente(trajeto.PosicaoInimigo);
			
			PecaTarget.P = PecaSource.P;
			PecaSource.P = '-';
		}
	}


	public Trajetoria TraduzMovimento(Peca peca, Coordenada Ctarget) {
		Trajetoria trajeto = new Trajetoria (peca);
		String Caminho = "";  
		Coordenada cAux = new Coordenada (null); 
		
		cAux.linha = peca.coordenada.linha;
		cAux.coluna = peca.coordenada.coluna;
		
		/*System.out.println("cAux.linha ("+cAux.linha+")= peca.coordenada.linha("+peca.coordenada.linha+")");
		System.out.println("cAux.coluna ("+cAux.coluna+")= peca.coordenada.coluna("+peca.coordenada.coluna+")");
		System.out.println("Ctarget.linha:"+Ctarget.linha);
		System.out.println("Ctarget.coluna:"+Ctarget.coluna);*/
		
		if ((peca.coordenada.linha < Ctarget.linha) && (peca.coordenada.coluna < Ctarget.coluna)) { // caminho Nordeste 
			trajeto.Direcao = "Nordeste"; 
			while( (cAux.linha <= Ctarget.linha) && (cAux.coluna <= Ctarget.coluna) ) {
				Caminho += tabuleiro[cAux.linha][cAux.coluna].P;
				cAux.linha++;
				cAux.coluna++;
			}
			
		}
		if ((peca.coordenada.linha < Ctarget.linha) && (peca.coordenada.coluna > Ctarget.coluna)) { // caminho Noroeste
			trajeto.Direcao = "Noroeste"; 
			while( (cAux.linha <= Ctarget.linha) && (cAux.coluna >= Ctarget.coluna) ) {
				Caminho += tabuleiro[cAux.linha][cAux.coluna].P;
				cAux.linha++;
				cAux.coluna--;
			}
		}
		if ((peca.coordenada.linha > Ctarget.linha) && (peca.coordenada.coluna < Ctarget.coluna)) { // caminho Sudeste  
			trajeto.Direcao = "Sudeste_"; 
			while( (cAux.linha >= Ctarget.linha) && (cAux.coluna <= Ctarget.coluna) ) {
				Caminho += tabuleiro[cAux.linha][cAux.coluna].P;
				cAux.linha--;
				cAux.coluna++;
			}
		}		
		if ( ((peca.coordenada.linha > Ctarget.linha) && (peca.coordenada.coluna > Ctarget.coluna))  ) { // caminho Sudoeste
			trajeto.Direcao = "Sudoeste"; 
			while( ((cAux.linha >= Ctarget.linha) && (cAux.coluna >= Ctarget.coluna)) ) {
				Caminho += tabuleiro[cAux.linha][cAux.coluna].P;
				cAux.linha--;
				cAux.coluna--;
			}
		}
		trajeto.Caminho = Caminho;
		return trajeto;
	}
}