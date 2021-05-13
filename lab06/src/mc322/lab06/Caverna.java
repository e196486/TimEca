package mc322.lab06;

public class Caverna {

	Sala cave[][];
	StatusJogo status;

	public Caverna(StatusJogo status) {
		this.status = status;
		cave = new Sala[5][5];
		criaCaverna();
	}

	public void criaCaverna() {
		for (int i = 1; i < 5; i++) {
			for (int j = 1; j < 5; j++) {
				Sala sala = new Sala();
				cave[i][j] = sala;
			}
		}
	}

	public String imprimeEstado() {
		String Estado = "";
		for (int i = 1; i < 5; i++) {
			Estado += i + " ";
			for (int j = 1; j < 5; j++) {
				Estado += cave[i][j].P + " ";
			}
			Estado += "\n";
		}
		Estado += "  1 2 3 4";

		Estado += ("\n\nPlayer: " + status.player + "\nScore: " + status.score);

		System.out.println(Estado);

		return Estado;
	}

	public void insereComponente(Componente C) {
		
		boolean erro = cave[C.linha][C.coluna].insereC(C);
		if (erro)
			System.out.println("Erro");
		else if (C.componente == 'W'){
			if (C.coluna > 1) {
				Componente f = new Fedor(C.linha, C.coluna-1);
				cave[C.linha][C.coluna-1].insereC(f);
			}
			if (C.coluna < 4) {
				Componente f = new Fedor(C.linha, C.coluna+1);
				cave[C.linha][C.coluna+1].insereC(f);
			}	
			if (C.linha > 1) {
				Componente f = new Fedor(C.linha-1, C.coluna);
				cave[C.linha-1][C.coluna].insereC(f);
			}
			if (C.linha < 4) {
				Componente f = new Fedor(C.linha+1, C.coluna);
				cave[C.linha+1][C.coluna].insereC(f);
			}
		}
		else if (C.componente == 'B') {
			if (C.coluna > 1) {
				Componente b = new Brisa(C.linha, C.coluna-1);
				cave[C.linha][C.coluna-1].insereC(b);
			}
			if (C.coluna < 4) {
				Componente b = new Brisa(C.linha, C.coluna+1);
				cave[C.linha][C.coluna+1].insereC(b);
			}	
			if (C.linha > 1) {
				Componente b = new Brisa(C.linha-1, C.coluna);
				cave[C.linha-1][C.coluna].insereC(b);
			}
			if (C.linha < 4) {
				Componente b = new Brisa(C.linha+1, C.coluna);
				cave[C.linha+1][C.coluna].insereC(b);
			}
		}

	}

	public StatusJogo solicitaMovimento(Componente heroi, int linhaTarget, int colunaTarget) {
		// O solicita movimento testa se o movimento é possivel, pede para as salas
		// testarem o "confronto" e atualiza tudo isso no Status.
		// caso seja possível, ele insere a peça # na sala que estava e se move para o
		// Target. Temos que pensar direito nessa lógica pq as vezes a troca poderá
		// ocorrer dentro do confronto ou então o resultado do confronto sair do
		// inserePeca na Sala

		if (cave[linhaTarget][colunaTarget] != null) {

			/*String SalaAcessada[] = { (String.valueOf(heroi.linha) + ":" + String.valueOf(heroi.coluna)), "#" };
			insereComponente(new Componente(SalaAcessada));*/
			
			//Não precisa mais, porque eu coloco o # quando o herói entra na sala. Achei melhor pra encapsular mais.

			heroi.linha = linhaTarget;
			heroi.coluna = colunaTarget;

			insereComponente(heroi);
			
			status.Confronto(cave[linhaTarget][colunaTarget].confronto());

		}
		return status;
	}
	
	public void retiraOuro(int linha, int coluna) {
		cave[linha][coluna].Ouro = null;
		cave[linha][coluna].atualizaChar();
	}
	
	public boolean temSala(int x, int y) {
		if (cave[x][y] != null)
			return true;
		else
			return false;
	}
}