package controleComponent;

import conexaoComponent.*;
import marComponent.Mar.Mar;

public class InController implements Runnable {

	private  ICommandIn conexao;
	private Mar mar;
	private boolean fimDeJogo = false;

	public InController(ICommandIn conexao, Mar mar) {
		this.conexao = conexao;
		this.mar = mar;
	}

	@Override
	public void run() {

		while (true && !fimDeJogo) {
			if (conexao.getPlayer().equals("Host") && !conexao.getConexaoAceita())
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
