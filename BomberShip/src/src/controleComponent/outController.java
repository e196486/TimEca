package controleComponent;

import conexaoComponent.ICommandOut;
import conexaoComponent.InvalidMove;
import marComponent.Mar.IMarRefactor;
import viewComponent.ILogRefactor;

public class outController implements IMarListener {

	IMarRefactor mar;
	Bomba bombaAliada;
	Bomba bombaInimiga;

	public Time time;
	private ICommandOut conexao; 
	private String Jogada;
	private ILogRefactor logView;

	public outController(ICommandOut conexao, Bomba bombaAliada) {
		this.conexao = conexao;
		this.bombaAliada = bombaAliada; 
	}

	public void setMar(IMarRefactor mar) {
		this.mar = mar;
	}

	public void celulaAcionada(int i, int j) {
		boolean jogadaDica = false;
		boolean isNavioDestruido = false;
		boolean ultimaBomba = false;

		if (!bombaAliada.isFimDeJogo()) {
			if (bombaAliada.getTurno()) {
				logView.updateLog("Atingiu a celula inimiga: " + "(" + i + ":" + j + ")");
				if (bombaAliada.getBombas() > 0 && !mar.getCelula(i, j).isCelulaDestruida()) {

					if (bombaAliada.dicaEquipada() && bombaAliada.temDica()) {
						jogadaDica = true;
						bombaAliada.usaDica();
						mar.getCelula(i + 1, j).setCelulaRevelada(true);
						mar.getCelula(i, j + 1).setCelulaRevelada(true);
						mar.getCelula(i - 1, j).setCelulaRevelada(true);
						mar.getCelula(i, j - 1).setCelulaRevelada(true);
					}
					char tipo = mar.getCelula(i, j).explode();

					if (tipo == 'S' || tipo == 'C' || tipo == 'N' || tipo == 'P')
						isNavioDestruido = mar.getCelula(i, j).getNavio().navioDestruido();

					ultimaBomba = (bombaAliada.getBombas() == 1);

					int pontosPerdidos = bombaAliada.usaBomba(tipo, isNavioDestruido);
					bombaInimiga.penalidadeRecebida(pontosPerdidos);
					
					bombaAliada.setTurno(false);
					try {
						Jogada = "(" + i + ":" + j + ")|(" + bombaAliada.getBombas() + ":" + bombaAliada.getPontos() + ":" + bombaAliada.getDicas() + ")|"+ jogadaDica;
						conexao.enviaDados(Jogada);
					} catch (InvalidMove e) {
						e.printStackTrace();
					}

				} else
					logView.updateLog("Célula já destruída");

				if (ultimaBomba || bombaAliada.getPontos() <= 0) {
					
					logView.updateLog("Acabaram os recursos :( ");
					bombaAliada.setFimDeJogo();
					try {
						conexao.enviaDados("fimDeJogo");
					} catch (InvalidMove e) {
						e.printStackTrace();
					}
				}

			} else {
				logView.updateLog("Aguarde seu turno");
			}
		}
	}

	public void setLogView(ILogRefactor iLogRefactor) {
		this.logView = iLogRefactor;

	}

	public void setBombaInimiga(Bomba bombaInimiga) {
		this.bombaInimiga = bombaInimiga;
	}

}
