package controleComponent;

import java.awt.Component;

import javax.swing.JOptionPane;

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
				if (bomba.getBombas() > 0 && !mar.getCelula(i, j).isCelulaDestruida()) {

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
						boolean navio = mar.getCelula(i, j).getNavio().navioDestruido();
						bomba.usaBomba(tipo, "Você", navio);
					}else {
						bomba.usaBomba(tipo, "Você", false);
					}
					bomba.setTurno(false);
					Jogada = "(" + i + ":" + j + ")|" + jogadaDica;
					conexao.enviaDados(Jogada);
				} else {
					logView.updateLog("Célula já destruída");
				}
			} else {
				logView.updateLog("Aguarde seu turno");
			}
		}
	}

	public void setLogView(ILogRefactor iLogRefactor) {
		this.logView = iLogRefactor;

	}

}
