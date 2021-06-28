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
	
	int i ;
	int j ;

	int a ;
	int b ;
	int c ;

	int bombasInimigo ;
	int pontosInimigo ;
	int dicasInimigo ;		
	String jogadaDica;

	public InController(ICommandIn conexao, IMarRefactor mar, Bomba bombaAliada, Bomba bombaInimiga) {
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

			if (!resposta.equals("fimDeJogo")) {

				traduzResposta(resposta);

				if (jogadaDica.equals("true"))
					bombaInimiga.usaDica();

				char tipo = marAliado.getCelula(i, j).explode();
				int pontosPerdidos;
				if (tipo == 'S' || tipo == 'C' || tipo == 'N' || tipo == 'P')
					pontosPerdidos = bombaInimiga.usaBomba(tipo, marAliado.getCelula(i, j).getNavio().navioDestruido());
				else
					pontosPerdidos = bombaInimiga.usaBomba(tipo, false);

				bombaInimiga.setBombas(bombasInimigo);
				bombaInimiga.setPontos(pontosInimigo);
				bombaInimiga.setDicas(dicasInimigo);

				bombaAliada.penalidadeRecebida(pontosPerdidos);
				bombaAliada.setTurno(true);

			}
			if (resposta.equals("fimDeJogo") || temVencedor()) {

				conexao.enviaDados("fimDeJogo");
				String status = bombaAliada.getResultado();

				logView.updateLog(status);
				bombaAliada.setFimDeJogo();
				bombaAliada.atualizaPontos();
				bombaInimiga.atualizaPontos();
				JOptionPane.showMessageDialog(null, "Fim de Jogo!!\n" + status);
				fimDeJogo = true;
			}

		}

	}

	private void traduzResposta(String resposta) {
		 i = Integer.parseInt(resposta.substring(1, 2));
		 j = Integer.parseInt(resposta.substring(3, 4)); 

		 a = posicao(resposta, 7, ':');
		 b = posicao(resposta, a + 1, ':');
		 c = posicao(resposta, b + 1, ')');

		 bombasInimigo = Integer.parseInt(resposta.substring(7, a));
		 pontosInimigo = Integer.parseInt(resposta.substring(a + 1, b));
		 dicasInimigo = Integer.parseInt(resposta.substring(b + 1, c));	
		 jogadaDica = resposta.substring(c + 2);
	}

	private int posicao(String x, int inicio, char c) {
		int fim;
		char S = 'A';

		for (fim = inicio; S != c; fim++) {
			S = x.charAt(fim);
		}
		return fim - 1;
	}

	private boolean temVencedor() {
		return (bombaAliada.checaFimDeJogo() || bombaInimiga.checaFimDeJogo());
	}

	public void setLogView(ILogRefactor logView) {
		this.logView = logView;

	}

}
