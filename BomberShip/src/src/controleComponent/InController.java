package controleComponent;

import conexaoComponent.*;
import marComponent.Mar.Mar;

public class InController implements Runnable {

	private ICommandIn conexao;
	private Mar mar;
	private Bomba bomba; 
	private boolean fimDeJogo = false;

	public InController(ICommandIn conexao, Mar mar, Bomba bomba) {
		this.conexao = conexao;
		this.mar = mar;
		this.bomba = bomba;
	}

	@Override
	public void run() {

		while (true && !fimDeJogo) {
			if (conexao.getPlayer().equals("Host") && !conexao.getConexaoAceita())
				conexao.aguardaServerRequest();

			String resposta = conexao.recebeDados();

			if (resposta.equals("fimDeJogo"))
				fimDeJogo = true;
			
			else {
				System.out.println("novo in: " + resposta); 
				
				int i = Integer.parseInt(resposta.substring(1, 2));
				int j = Integer.parseInt(resposta.substring(3, 4));
				
				mar.getCelula(i, j).explode(bomba);
			    bomba.setTurno(true);
			}

		}
	}

}
