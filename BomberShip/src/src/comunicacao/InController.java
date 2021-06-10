package comunicacao;

import mar.Mar;

public class InController implements Runnable {

	private Conexao conexao;
	private Mar mar; 

	public InController(Conexao conexao, Mar mar) {
		this.conexao = conexao;
		this.mar = mar; 
	}

	@Override
	public void run() {

		while (true) {
			if (conexao.Player.equals("Host") && !conexao.conexaoAceita)
				conexao.aguardaServerRequest();

			String resposta = conexao.recebeDados();
			System.out.println("novo in: " + resposta);
			// seta seuTurno = true;
		}
	}

}
