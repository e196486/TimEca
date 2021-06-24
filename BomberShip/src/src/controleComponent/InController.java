package controleComponent;

import conexaoComponent.*; 
import marComponent.Mar.Mar;
import viewComponent.ILogRefactor;

public class InController implements Runnable {

	private ICommandIn conexao;
	private Mar marAliado;
	private Bomba bombaAliada;
	private Bomba bombaInimiga;
	private boolean fimDeJogo = false;
	private ILogRefactor logView;

	public InController(ICommandIn conexao, Mar mar, Bomba bombaAliada, Bomba bombaInimiga) {
		this.conexao = conexao;
		this.marAliado = mar;
		this.bombaAliada = bombaAliada;
		this.bombaInimiga = bombaInimiga;
	}

	@Override
	public void run() {

		while (true && !fimDeJogo && !temVencedor()) {
			if (conexao.getPlayer().equals("Host") && !conexao.getConexaoAceita())
				conexao.aguardaServerRequest();

			String resposta = conexao.recebeDados();

			if (resposta.equals("fimDeJogo"))
				fimDeJogo = true;

			else {

				int i = Integer.parseInt(resposta.substring(1, 2));
				int j = Integer.parseInt(resposta.substring(3, 4));
				String jogadaDica = resposta.substring(6);

				if (jogadaDica.equals("true"))
					bombaInimiga.usaDica("Inimigo");

				bombaInimiga.usaBomba(marAliado.getCelula(i, j).explode(), "Inimigo");
				bombaAliada.setTurno(true);

				logView.updateLog("Sua vez...");
			}
			if (bombaAliada.checaVencedor())
				logView.updateLog("Você Ganhou!");
			else if (bombaInimiga.checaVencedor())
				logView.updateLog("Você Perdeu!");
		}
	}

	private boolean temVencedor() {
		return (bombaAliada.checaVencedor() || bombaInimiga.checaVencedor());
	}

	public void setLogView(ILogRefactor logView) {
		this.logView = logView;

	}

}
