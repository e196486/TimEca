package mc322.lab06;

public class Caverna {

	Sala room[][];
	StatusJogo status;
	int buracos;

	public Caverna(StatusJogo status) {
		this.status = status;
		room = new Sala[5][5];
		criaCaverna();
		buracos = 0;
	}

	public void criaCaverna() {
		for (int i = 1; i < 5; i++) {
			for (int j = 1; j < 5; j++) {
				Sala sala = new Sala();
				room[i][j] = sala;
			}
		}
	}

	public String imprimeEstado() {
		String Estado = "";
		for (int i = 1; i < 5; i++) {
			Estado += i + " ";
			for (int j = 1; j < 5; j++) {
				Estado += room[i][j].P + " ";
			}
			Estado += "\n";
		}
		Estado += "  1 2 3 4";

		Estado += ("\n\nPlayer: " + status.player + "\nScore: " + status.score +"\n"+ status.mensagemFinal);

		System.out.println(Estado);

		return Estado;
	}

	public void insereComponente(Componente C) {
		if (C.componente == 'W'){
			
			boolean erro = room[C.linha][C.coluna].insereC(C);
			if (erro)
				System.out.println("Erro");
			else { 
				if (C.coluna > 1) {
					Componente f = new Fedor(C.linha, C.coluna-1);
					room[C.linha][C.coluna-1].insereC(f);
				}
				if (C.coluna < 4) {
					Componente f = new Fedor(C.linha, C.coluna+1);
					room[C.linha][C.coluna+1].insereC(f);
				}	
				if (C.linha > 1) {
					Componente f = new Fedor(C.linha-1, C.coluna);
					room[C.linha-1][C.coluna].insereC(f);
				}
				if (C.linha < 4) {
					Componente f = new Fedor(C.linha+1, C.coluna);
					room[C.linha+1][C.coluna].insereC(f);
				}
			}
		}
		else if (C.componente == 'B') {
			if (buracos <= 3) {
				boolean erro = room[C.linha][C.coluna].insereC(C);
				if (erro)
					System.out.println("Erro");
				else { 
					if (C.coluna > 1) {
						Componente b = new Brisa(C.linha, C.coluna-1);
						room[C.linha][C.coluna-1].insereC(b);
					}
					if (C.coluna < 4) {
						Componente b = new Brisa(C.linha, C.coluna+1);
						room[C.linha][C.coluna+1].insereC(b);
					}	
					if (C.linha > 1) {
						Componente b = new Brisa(C.linha-1, C.coluna);
						room[C.linha-1][C.coluna].insereC(b);
					}
					if (C.linha < 4) {
						Componente b = new Brisa(C.linha+1, C.coluna);
						room[C.linha+1][C.coluna].insereC(b);
					}
					buracos++;
				}
			}
		} else if (C.componente == 'P') {
			boolean erro = room[C.linha][C.coluna].insereC(C);
			if (erro)
				System.out.println("Erro");
		} 
		
		
		else {
			boolean erro = room[C.linha][C.coluna].insereC(C);
			if (erro)
				System.out.println("Erro"); 
		}
	}

	public StatusJogo solicitaMovimento(Componente heroi, int linhaTarget, int colunaTarget) {
		// O solicita movimento testa se o movimento é possivel, pede para as salas
		// testarem o "confronto" e atualiza tudo isso no Status. 
		
		if (linhaTarget == 1 && colunaTarget == 1 && status.temOuro) {
			status.win();
		}

		if (temSala(linhaTarget,colunaTarget)) { 
			
			room[heroi.linha][heroi.coluna].Heroi = null;
			room[heroi.linha][heroi.coluna].atualizaChar();
			
			heroi.linha = linhaTarget;
			heroi.coluna = colunaTarget;

			insereComponente(heroi);
			room[heroi.linha][heroi.coluna].atualizaChar();
			
			String resultadoConfronto = room[linhaTarget][colunaTarget].confronto(status);
			
			status.Confronto(resultadoConfronto);
			

		}
		else  {
			System.err.println("Movimento impossível! ");
		}
		
		if (status.JogoAtivo)
			imprimeEstado();
		
		return status;
	}
	
	public void retiraOuro(int linha, int coluna) {
		room[linha][coluna].Ouro = null;
		room[linha][coluna].atualizaChar();
	}
	
	public boolean temSala(int x, int y) {
		return (x >= 1 && x <= 4 && y >=1 && y <=4 );
	}
}