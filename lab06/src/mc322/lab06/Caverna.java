package mc322.lab06;

public class Caverna {

	Sala cav[][];
	StatusJogo status;

	public Caverna(StatusJogo status) {
		this.status = status;
		cav = new Sala[5][5];
		criaCaverna();
	}

	public void criaCaverna() {
		for (int i = 1; i < 5; i++) {
			for (int j = 1; j < 5; j++) {
				Sala sala = new Sala();
				cav[i][j] = sala;
			}
		}
	}

	public String imprimeEstado() {
		String Estado = "";
		for (int i = 1; i < 5; i++) {
			Estado += i + " ";
			for (int j = 1; j < 5; j++) {
				Estado += cav[i][j].P + " ";
			}
			Estado += "\n";
		}
		Estado += "  1 2 3 4";

		Estado += ("\n\nPlayer: " + status.player + "\nScore: " + status.score);

		System.out.println(Estado);

		return Estado;
	}

	public void insereComponente(Componente C) {
		
		boolean erro = cav[C.linha][C.coluna].insereC(C);
		if (!erro)
			System.out.println("Erro");

	}

	public StatusJogo solicitaMovimento(Componente heroi, int linhaTarget, int colunaTarget) {
		// O solicita movimento testa se o movimento � possivel, pede para as salas
		// testarem o "confronto" e atualiza tudo isso no Status.
		// caso seja poss�vel, ele insere a pe�a # na sala que estava e se move para o
		// Target. Temos que pensar direito nessa l�gica pq as vezes a troca poder�
		// ocorrer dentro do confronto ou ent�o o resultado do confronto sair do
		// inserePeca na Sala

		if (cav[linhaTarget][colunaTarget] != null) {

			/*String SalaAcessada[] = { (String.valueOf(heroi.linha) + ":" + String.valueOf(heroi.coluna)), "#" };
			insereComponente(new Componente(SalaAcessada));*/
			
			//N�o precisa mais, porque eu coloco o # quando o her�i entra na sala. Achei melhor pra encapsular mais.

			heroi.linha = linhaTarget;
			heroi.coluna = colunaTarget;

			insereComponente(heroi);
			
			status.Confronto(cav[linhaTarget][colunaTarget].confronto());

		}
		return status;
	}
	
	public void retiraOuro(int linha, int coluna) {
		cav[linha][coluna].Ouro = null;
		cav[linha][coluna].atualizaChar();
	}
}