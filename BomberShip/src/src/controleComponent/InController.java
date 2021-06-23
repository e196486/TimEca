package controleComponent;

import conexaoComponent.*;
import marComponent.Mar.Mar;
import viewComponent.IItemRefactor;

public class InController implements Runnable {

	private ICommandIn conexao;
	private Mar marAliado;
	private Bomba bombaAliada; 
	private Bomba bombaInimiga; 
	private boolean fimDeJogo = false;
	private IItemRefactor logView;

	public InController(ICommandIn conexao, Mar mar, Bomba bombaAliada,Bomba bombaInimiga) {
		this.conexao = conexao;
		this.marAliado = mar;
		this.bombaAliada = bombaAliada;
		this.bombaInimiga = bombaInimiga;
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
				
				marAliado.getCelula(i, j).explode(bombaInimiga);
				bombaInimiga.usaBomba();
			    bombaAliada.setTurno(true); 
			    logView.updateLog("Sua vez...");
			}

		}
	}
	
	public void setLogView(IItemRefactor logView) {
		this.logView = logView;
		
	}

}
