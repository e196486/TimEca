package mc322.lab06;

public class Caverna {

	Sala cav[][];
	StatusJogo status;

	public Caverna(StatusJogo status) {
		this.status = status;
		cav = new Sala[5][5];
		criaCaverna();
	}

	/*
	 * alterei aqui para que o criacaverna começasse das coordenadas que o prof
	 * passa.
	 */
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
		// O solicita movimento testa se o movimento é possivel, pede para as salas
		// testarem o "confronto" e atualiza tudo isso no Status.
		// caso seja possível, ele insere a peça # na sala que estava e se move para o
		// Target. Temos que pensar direito nessa lógica pq as vezes a troca poderá
		// ocorrer dentro do confronto ou então o resultado do confronto sair do
		// inserePeca na Sala

		if (cav[linhaTarget][colunaTarget] != null) {

			status.Confronto(cav[linhaTarget][colunaTarget].confronto());

			String SalaAcessada[] = { (String.valueOf(heroi.linha) + ":" + String.valueOf(heroi.coluna)), "#" };
			insereComponente(new Componente(SalaAcessada));

			heroi.linha = linhaTarget;
			heroi.coluna = colunaTarget;

			insereComponente(heroi);

		}
		return status;
	}
}