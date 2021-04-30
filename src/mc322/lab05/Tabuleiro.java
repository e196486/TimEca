package mc322.lab05;

public class Tabuleiro {
	Peca tabuleiro[][] = new Peca[10][10];
	Coordenada Csource;
	Coordenada Ctarget;

	public void inserePeca(int x, int y, char c) {
		if (y <= 9 && x < 9) {
			Peca pc = new PecaPeao(x, y);
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

				System.out.print(" " + tabuleiro[i][j].P );
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

	public void CriaDama(Peca Peca) {
		char cor = Peca.P;

		Peca pDama = new PecaDama(Peca.coordenada.linha, Peca.coordenada.coluna);

		tabuleiro[Peca.coordenada.linha][Peca.coordenada.coluna] = pDama;

		if (cor == 'p')
			pDama.P = 'P';
		if (cor == 'b')
			pDama.P = 'B';

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

		char tipoPeca = PecaSource.P;

		StatusMovimento = movePeca(tipoPeca, PecaSource, Ctarget);

		if (StatusMovimento && RegraDama(PecaSource))
			CriaDama(PecaTarget);
		PecaTarget.TestaPeca(tipoPeca,Ctarget);

	}

	private boolean movePeca(char tipoPeca, Peca Peca, Coordenada Ctarget) {
		boolean StatusMovimento = false;

		// linha de debug
		System.out.println("\n >> Estou movendo minha Peca" + "\nPeca.coordenada.linha : " + Peca.coordenada.linha
				+ " | Ctarget.linha : " + Ctarget.linha + "\nPeca.coordenada.coluna : " + Peca.coordenada.coluna
				+ " | Ctarget.coluna : " + Ctarget.coluna);

		if (Peca.coordenada.linha == Ctarget.linha && Peca.coordenada.coluna == Ctarget.coluna) {
			if (Peca.P == '-') // só atribuo se a peça final é vazia.
				Peca.P = tipoPeca;

			System.out.println("chegamos no target");
			return true;

		} else {
			if (Peca.Sudoeste != null)
				if (!StatusMovimento && Peca.TestaPeca(tipoPeca,Peca.Sudoeste.coordenada)) {
					System.out.println("indo para Sudoeste");
					StatusMovimento = movePeca(tipoPeca, Peca.Sudoeste, Ctarget);
				}
			if (Peca.Sudeste != null)
				if (!StatusMovimento && Peca.TestaPeca(tipoPeca,Peca.Sudeste.coordenada)) {
					System.out.println("indo para Sudeste");
					StatusMovimento = movePeca(tipoPeca, Peca.Sudeste, Ctarget);
				}
			if (Peca.Nordeste != null)
				if (!StatusMovimento && Peca.TestaPeca(tipoPeca,Peca.Nordeste.coordenada)) { 
					System.out.println("indo para Nordeste");
					StatusMovimento = movePeca(tipoPeca, Peca.Nordeste, Ctarget);
					if (Peca.P == 'b' && Peca.Nordeste.P == 'p')
					  System.out.println("ca estou eu ");
					}
			
			if (Peca.Noroeste != null)
				if (!StatusMovimento && Peca.TestaPeca(tipoPeca,Peca.Noroeste.coordenada)) {
					System.out.println("indo para Noroeste");
					StatusMovimento = movePeca(tipoPeca, Peca.Noroeste, Ctarget);
				}
			if (StatusMovimento) {

				
				if (Peca.P != tipoPeca) { // casa atras para comer{
					CapturaOponente(Peca); 
				}

				if (Peca.P == tipoPeca)
					Peca.P = '-';
				return (StatusMovimento);
			}
			System.out.println("não deu certo. voltando.");
			return (StatusMovimento);
		}
	}

}