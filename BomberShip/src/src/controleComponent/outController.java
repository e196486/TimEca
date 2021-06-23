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

	// Adicionei mar e bomba nessa classe para controlar as a�oes.
	public void celulaAcionada(int i, int j) {

		if (bomba.getTurno()) {
			logView.updateLog("Atingiu a celula inimiga: " +  "(" + i + ":" + j + ")");   
			Jogada = "(" + i + ":" + j + ")";

			conexao.enviaDados(Jogada);

			if (bomba.getBombas() > 0) {

				if (bomba.dicaEquipada()) {
					mar.getCelula(i + 1, j).setCelulaRevelada(true);
					mar.getCelula(i, j + 1).setCelulaRevelada(true);
					mar.getCelula(i - 1, j).setCelulaRevelada(true);
					mar.getCelula(i, j - 1).setCelulaRevelada(true);
				}
				bomba.usaBomba(mar.getCelula(i, j).explode( ),"Voc�"); 
			}
			bomba.setTurno(false);
		} else { 
			logView.updateLog("Aguarde seu turno");  
		}
	}

	public void setLogView(ILogRefactor iLogRefactor) {
		this.logView = iLogRefactor;
		
	}

}
