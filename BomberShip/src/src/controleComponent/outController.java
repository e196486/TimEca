package controleComponent;
 

import conexaoComponent.ICommandOut;
import marComponent.Mar.IMarRefactor;
import viewComponent.IItemRefactor;

public class outController implements IMarListener {

	IMarRefactor mar;
	Bomba bomba;

	public Time time;
	private ICommandOut conexao;
	int i;
	int j;
	String Jogada;
	private IItemRefactor logView;

	public outController(ICommandOut conexao, Bomba bomba) {
		this.conexao = conexao;
		this.bomba = bomba;
	}

	public void setMar(IMarRefactor mar) {
		this.mar = mar;
	}

	// Adicionei mar e bomba nessa classe para controlar as açoes.
	public void celulaAcionada(int i, int j) {

		if (bomba.getTurno()) {
			logView.updateLog("Atingiu a celula inimiga: " +  "(" + i + ":" + j + ")");   
			Jogada = "(" + i + ":" + j + ")";

			conexao.enviaDados(Jogada);

			if (bomba.getBombas() > 0) {
				mar.getCelula(i, j).explode(bomba);

				if (bomba.dicaEquipada()) {
					mar.getCelula(i + 1, j).setCelulaRevelada(true);
					mar.getCelula(i, j + 1).setCelulaRevelada(true);
					mar.getCelula(i - 1, j).setCelulaRevelada(true);
					mar.getCelula(i, j - 1).setCelulaRevelada(true);
				}
				bomba.usaBomba();
				logView.setMunicao(bomba.getBombas());
			}
			bomba.setTurno(false);
		} else { 
			logView.updateLog("Aguarde seu turno");  
		}
	}

	public void setLogView(IItemRefactor logView) {
		this.logView = logView;
		
	}

}
