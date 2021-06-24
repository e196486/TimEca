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
	protected final int ptsArmadilha = -500;
	protected final int ptsSubmarino = 40;
	protected final int ptsCruzeiro = 60;
	protected final int ptsNavioTanque = 80;
	protected final int ptsPortaAviao = 100;
	protected final int ptsMaxBau = 600;
	protected final int dicasMaxBau = 3;
	protected final int bombasMaxBau = 10;
	private Time time;

	private boolean fimDeJogo = false;

	public Bomba(Time time) {
		n_dicas = 1;
		n_bombas = 50;
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

	public void usaBomba(char tipo, String nomeJogador) {
		String tipoCelula = "";
		n_bombas--;
		n_pontos -= 10;

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
			n_pontos += ptsSubmarino;
			tipoCelula = "um Submarino";
			break;
		case 'C':
			n_pontos += ptsCruzeiro;
			tipoCelula = "um Cruzeiro";
			break;
		case 'N':
			n_pontos += ptsNavioTanque;
			tipoCelula = "um Navio Tanque";
			break;
		case 'P':
			n_pontos += ptsPortaAviao;
			tipoCelula = "um Porta Avião";
			break;
		case '~': 
			tipoCelula = "o Mar";
			break;
		}
		if ((tipo != 'A') || (tipo != 'B') || (tipo != '~'))
			n_inimigos--;

		logView.updateMunicao(n_bombas, tipoCelula, nomeJogador);
		atualizaPontos();
	}

	private void sorteiaBau() {
		int pontosGanhos = new Random().nextInt(ptsMaxBau);
		int bombasGanhas = new Random().nextInt(bombasMaxBau);
		int dicasGanhas = new Random().nextInt(dicasMaxBau);

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
		return (n_inimigos == 0);
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
