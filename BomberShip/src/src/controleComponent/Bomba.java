package controleComponent;

import java.util.Random;

import viewComponent.IItemRefactor;
import viewComponent.ILogRefactor;

public class Bomba {
	protected IItemRefactor itemView;
	protected ILogRefactor logView;
	protected int n_dicas;
	protected int n_bombas;
	protected int n_pontos;
	protected int n_inimigos;
	protected boolean seuTurno;
	protected boolean dicaEquip;

	/* Pontos ganhos */

	protected final int ptsAtingeNavio = +25;
	protected final int ptsUsaBomba = -10;
	protected final int ptsArmadilha = -500;
	protected final int ptsSubmarino = 40;
	protected final int ptsCruzeiro = 60;
	protected final int ptsNavioTanque = 80;
	protected final int ptsPortaAviao = 100;
	protected final int ptsMaxBau = 12;
	protected final int dicasMaxBau = 3;
	protected final int bombasMaxBau = 10;
	private Time time;

	private boolean fimDeJogo = false;

	public Bomba(Time time) {
		n_pontos = 0;
		n_inimigos = 25;
		this.time = time;

	}

	public void setItensView(IItemRefactor itemView, ILogRefactor iLogRefactor) {
		this.itemView = itemView;
		this.logView = iLogRefactor;

		if (time.equals(Time.Aliado))
			itemView.setDicaEnable();

		atualizaPontos();
	}

	public boolean temDica() {
		if (!(n_dicas > 0)) {
			itemView.setDicaUnclicked();
			logView.updateLog("Você não tem mais dicas disponíveis");
		}

		return (n_dicas > 0);
	}

	public void equipaDica() {
		if (temDica())
			this.dicaEquip = true;
	}

	public boolean dicaEquipada() {
		return (itemView.isBtnDicas());
	}

	public int getBombas() {
		return n_bombas;
	}

	public void setBombas(int n_bombas) {
		this.n_bombas = n_bombas;
	}

	public void setDicas(int n_dicas) {
		this.n_dicas = n_dicas;
	}

	public void setTurno(boolean turno) {
		seuTurno = turno;
	}

	public Boolean getTurno() {
		return seuTurno;
	}

	public void usaDica(String nomeJogador) {
		n_dicas--;
		logView.updateDicas(n_dicas, nomeJogador);
		itemView.setDicaUnclicked();
	}

	public void usaBomba(char tipo, String nomeJogador, boolean bonus) {
		String tipoCelula = "";
		String txtAfunda = "";
		n_bombas--;
		n_pontos += ptsUsaBomba;

		switch (tipo) {
		case 'A':
			n_pontos += ptsArmadilha;
			tipoCelula = "uma Armadilha";
			break;
		case 'B':
			sorteiaBau();
			tipoCelula = "um Baú";
			break;
		case 'S':
			tipoCelula = "um Submarino";
			if (bonus)
				n_pontos += ptsSubmarino;

			break;
		case 'C':
			tipoCelula = "um Cruzeiro";
			if (bonus)
				n_pontos += ptsCruzeiro;
			break;
		case 'N':
			tipoCelula = "um Navio Tanque";
			if (bonus)
				n_pontos += ptsNavioTanque;
			break;
		case 'P':
			tipoCelula = "um Porta Avião";
			if (bonus)
				n_pontos += ptsPortaAviao;

			break;
		case '~':
			tipoCelula = "o Mar";
			break;
		}
		if ((tipo != 'A') && (tipo != 'B') && (tipo != '~')) {
			n_inimigos--;
			n_pontos += ptsAtingeNavio;
			if (bonus)
				txtAfunda += ", você o afundou";
		}

		logView.updateMunicao(n_bombas, tipoCelula + txtAfunda, nomeJogador);
		atualizaPontos();
	}

	private void sorteiaBau() {
		int pontosGanhos = new Random().nextInt(ptsMaxBau) * 50;
		int bombasGanhas = new Random().nextInt(bombasMaxBau);
		int dicasGanhas = new Random().nextInt(dicasMaxBau);
		n_pontos += pontosGanhos;
		n_bombas += bombasGanhas;
		n_dicas += dicasGanhas;

		logView.updateLog(
				"você ganhou " + pontosGanhos + " pontos, " + bombasGanhas + " bombas e " + dicasGanhas + " dicas!!");

	}

	public void setLogView(ILogRefactor logView) {
		this.logView = logView;
	}

	public void atualizaPontos() {
		itemView.setDicas(n_dicas);
		itemView.setMunicao(n_bombas);
		itemView.setPontos(n_pontos);
	}

	public boolean checaVencedor() { 
		return fimDeJogo = (n_inimigos == 0);
	}

	public String getResultado() {
		String Resultado = (n_inimigos != 0) ? "perdeu! =(" : "ganhou!! =)";

		return "\n Numero de pontos: " + n_pontos + "\n Numero de Bombas: " + n_bombas + "\n Numero de dicas: "
				+ n_dicas + "\n Numero de inimigos: " + n_inimigos + "\n você " + Resultado;
	}

	public boolean isFimDeJogo() {
		return fimDeJogo;
	}
}
