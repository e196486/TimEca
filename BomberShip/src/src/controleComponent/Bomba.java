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
	protected boolean seuTurno;
	protected boolean dicaEquip;

	/* Pontos ganhos */
	protected final int ptsArmadilha = -500;
	protected final int ptsSubmarino = 40;
	protected final int ptsCruzeiro = 60;
	protected final int ptsNavioTanque = 80;
	protected final int ptsPortaAviao = 100;
	protected final int ptsMaxBau = 600;
	protected final int dicasMaxBau = 3;
	protected final int bombasMaxBau = 10;
	private Time time;

	public Bomba(Time time) {
		n_dicas = 1;
		n_bombas = 50;
		n_pontos = 0;
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
			logView.updateLog("Voc� n�o tem mais dicas dispon�veis");
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

	public void setTurno(boolean turno) {
		seuTurno = turno;
	}

	public Boolean getTurno() {
		return seuTurno;
	}

	public void usaDica(String nomeJogador) {
		n_dicas--;
		logView.updateDicas(n_dicas,nomeJogador);
		itemView.setDicaUnclicked();
	}

	public void usaBomba(char tipo, String nomeJogador) {
		String tipoCelula = "";
		n_bombas--;
		n_pontos -= 10;

		switch (tipo) {
		case 'A':
			n_pontos += ptsArmadilha;
			tipoCelula = "Armadilha";
			break;
		case 'B':
			sorteiaBau();
			break;
		case 'S':
			n_pontos += ptsSubmarino;
			tipoCelula = "Submarino";
			break;
		case 'C':
			n_pontos += ptsCruzeiro;
			tipoCelula = "Cruzeiro";
			break;
		case 'N':
			n_pontos += ptsNavioTanque;
			tipoCelula = "Navio Tanque";
			break;
		case 'P':
			n_pontos += ptsPortaAviao;
			tipoCelula = "Porta Avi�o";
			break;

		}
		logView.updateMunicao(n_bombas, tipoCelula, nomeJogador);
		atualizaPontos();
	}

	private void sorteiaBau() {
		n_pontos += new Random().nextInt(ptsMaxBau);
		n_bombas += new Random().nextInt(bombasMaxBau);
		n_dicas += new Random().nextInt(dicasMaxBau);

	}

	public void setLogView(ILogRefactor logView) {
		this.logView = logView;
	}

	public void atualizaPontos() {
		itemView.setDicas(n_dicas);
		itemView.setMunicao(n_bombas);
		itemView.setPontos(n_pontos);
	}
}
