package controleComponent; 

import javax.swing.JOptionPane;
import conexaoComponent.*;
import marComponent.Mar.IMarRefactor;
import viewComponent.ILogRefactor;

public class InController implements Runnable {

	private ICommandIn conexao;
	private IMarRefactor marAliado;
	private Bomba bombaAliada;
	private Bomba bombaInimiga;
	private boolean fimDeJogo = false;
	private ILogRefactor logView;

	public InController(ICommandIn conexao, IMarRefactor mar, Bomba bombaAliada, Bomba bombaInimiga) {
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
				System.out.println("linha:" + i + "\n" + j);
				String jogadaDica = resposta.substring(6);

				if (jogadaDica.equals("true"))
					bombaInimiga.usaDica("Inimigo");

				char tipo = marAliado.getCelula(i, j).explode();
				if (tipo == 'S' || tipo == 'C' || tipo == 'N' || tipo == 'P')
					bombaInimiga.usaBomba(tipo, marAliado.getCelula(i, j).getNavio().navioDestruido());
				else
					bombaInimiga.usaBomba(tipo, false);

				bombaAliada.setTurno(true);

				logView.updateLog("Sua vez...");
			}
			if (fimDeJogo || temVencedor()) {

				if (temVencedor())
					conexao.enviaDados("fimDeJogo");
				String status = bombaAliada.getResultado();

				logView.updateLog(status);
				bombaAliada.setFimDeJogo();
				JOptionPane.showMessageDialog(null, "Fim de Jogo!!\n" + status);
			}
		}
	}

	private boolean temVencedor() {
		return (bombaAliada.checaFimDeJogo() || bombaInimiga.checaFimDeJogo());
	}

	public void setLogView(ILogRefactor logView) {
		this.logView = logView;

	}

}
