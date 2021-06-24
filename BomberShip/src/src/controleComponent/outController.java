package controleComponent;

import conexaoComponent.ICommandOut;
import marComponent.Mar.IMarRefactor;
import viewComponent.ILogRefactor;

public class outController implements IMarListener {

	IMarRefactor mar;
	Bomba bomba;

	public Time time;
	private ICommandOut conexao;
	int i;
	int j;
	String Jogada;
	private ILogRefactor logView;

	public outController(ICommandOut conexao, Bomba bomba) {
		this.conexao = conexao;
		this.bomba = bomba;
	}

	public void setMar(IMarRefactor mar) {
		this.mar = mar;
	}

	public void celulaAcionada(int i, int j) {
		boolean jogadaDica = false;
		if (!bomba.isFimDeJogo()) {
			if (bomba.getTurno()) {
				logView.updateLog("Atingiu a celula inimiga: " + "(" + i + ":" + j + ")");

				if (bomba.getBombas() > 0) {

					if (bomba.dicaEquipada() && bomba.temDica()) {
						jogadaDica = true;
						bomba.usaDica("Você");
						mar.getCelula(i + 1, j).setCelulaRevelada(true);
						mar.getCelula(i, j + 1).setCelulaRevelada(true);
						mar.getCelula(i - 1, j).setCelulaRevelada(true);
						mar.getCelula(i, j - 1).setCelulaRevelada(true);
					}
					char tipo = mar.getCelula(i, j).explode();
					if (tipo == 'S'||tipo == 'C'||tipo == 'N'||tipo == 'P') {
						bomba.usaBomba(tipo, "Você", mar.getCelula(tipo, j).getNavio().navioDestruido());
					}else {
						bomba.usaBomba(tipo, "Você", false);
					}
				}
				bomba.setTurno(false);

				Jogada = "(" + i + ":" + j + ")|" + jogadaDica;
				conexao.enviaDados(Jogada);
			} else {
				logView.updateLog("Aguarde seu turno");
			}
		}
	}

	public void setLogView(ILogRefactor iLogRefactor) {
		this.logView = iLogRefactor;

	}

}
