package comunicacao;

import mar.Mar;

public class InController implements Runnable {

	private Conexao conexao;
	private Mar mar;
	private boolean fimDeJogo = false;

	public InController(Conexao conexao, Mar mar) {
		this.conexao = conexao;
		this.mar = mar;
	}

	@Override
	public void run() {

		while (true && !fimDeJogo) {
			if (conexao.Player.equals("Host") && !conexao.conexaoAceita)
				conexao.aguardaServerRequest();

			String resposta = conexao.recebeDados();

			if (resposta.equals("fimDeJogo"))
				fimDeJogo = true;
			else
				System.out.println("novo in: " + resposta);

			// seta seuTurno = true;

		}
	}

}
