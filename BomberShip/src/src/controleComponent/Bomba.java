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

	protected final int ptsAtingeNavio = +40;
	protected final int ptsUsaBomba = -10;
	protected final int ptsMaxRoubados = 15; // adiciono multiplicador de 50, -> 50 < pts roubados < 800
	protected final int bombasMaxRoubadas = 10; // 1< bombasRoubadas < 11
	protected final int dicasMaxRoubadas = 2; // 1< dicasRoubadas < 2
	protected final int ptsSubmarino = 40;
	protected final int ptsCruzeiro = 60;
	protected final int ptsNavioTanque = 80;
	protected final int ptsPortaAviao = 100;
	protected final int ptsMaxBau = 12; // 1 < pts Bau < 650
	protected final int dicasMaxBau = 3;
	protected final int bombasMaxBau = 10;
	private Time time;

	private boolean fimDeJogo = false;
	private boolean perdeu = false;
	private String nomePersonagem = ""; 

	public Bomba(Time time, String nome, int nivel) {
		n_pontos = 500;
		n_inimigos = 25;
		this.time = time;
		this.nomePersonagem = nome; 
		
		switch (nivel) {
		case 1:
			setBombas(90);
			setDicas(3);
			break;
		case 2:
			setBombas(70);
			setDicas(2);
			break;
		case 3:
			setBombas(50);
			setDicas(1);
			break;
		}

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

	public void usaBomba(char tipo, boolean bonus) {
		String tipoCelula = "";
		String txtAfunda = "";
		n_bombas--;
		n_pontos += ptsUsaBomba;

		switch (tipo) {
		case 'A':
			sorteiaArmadilha(nomePersonagem);
			tipoCelula = "uma Armadilha";
			break;
		case 'B':
			sorteiaBau();
			tipoCelula = "um Ba�";
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
			tipoCelula = "um Porta Avi�o";
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
				txtAfunda += ", " + nomePersonagem + " o afundou";
		}

		logView.updateMunicao(n_bombas, tipoCelula + txtAfunda, nomePersonagem);
		atualizaPontos();
	}

	private void sorteiaBau() {
		int pontosGanhos = (new Random().nextInt(ptsMaxBau) + 1) * 50;
		int bombasGanhas = new Random().nextInt(bombasMaxBau);
		int dicasGanhas = new Random().nextInt(dicasMaxBau);
		n_pontos += pontosGanhos;
		n_bombas += bombasGanhas;
		n_dicas += dicasGanhas;

		logView.updateLog(
				"voc� ganhou " + pontosGanhos + " pontos, " + bombasGanhas + " bombas e " + dicasGanhas + " dicas!!");

	}

	private void sorteiaArmadilha(String nomeJogador) {
		String tipoPenalidade = "";
		int valorPenalidade = 0;

		int casoPenalidade = new Random().nextInt(2) + 1;

		switch (casoPenalidade) {

		case 1:
			valorPenalidade = (new Random().nextInt(ptsMaxRoubados) + 1) * 50;
			tipoPenalidade = "ponto(s)";
			n_pontos -= valorPenalidade;
			break;

		case 2:
			valorPenalidade = new Random().nextInt(bombasMaxRoubadas) + 1;

			if (n_bombas < valorPenalidade)
				valorPenalidade = n_bombas;

			tipoPenalidade = "bomba(s)";
			n_bombas -= valorPenalidade;
			break;

		case 3:
			valorPenalidade = new Random().nextInt(dicasMaxRoubadas) + 1;

			if (n_dicas < valorPenalidade)
				valorPenalidade = n_dicas;

			tipoPenalidade = "Dica(s)";
			n_dicas -= valorPenalidade;
			break;
		}

		atualizaPontos();
		logView.updateLog("O tubar�o roubou " + valorPenalidade + " " + tipoPenalidade + " de " + nomeJogador);

	}
 

	public void atualizaPontos() {
		itemView.setDicas(n_dicas);
		itemView.setMunicao(n_bombas);
		itemView.setPontos(n_pontos);
	}

	public boolean checaFimDeJogo() {

		if (n_inimigos == 0) {
			perdeu = false;
			fimDeJogo = true;
		}

		if (n_bombas == 0) {
			perdeu = true;
			fimDeJogo = true;
		}

		return fimDeJogo;
	}

	public String getResultado() {
		String Resultado = (perdeu) ? "perdeu! =(" : "ganhou!! =)";

		return "\n Numero de pontos: " + n_pontos + "\n Numero de Bombas: " + n_bombas + "\n Numero de dicas: "
				+ n_dicas + "\n voc� " + Resultado;
	}

	public boolean isFimDeJogo() {
		return fimDeJogo;
	}

	public void setFimDeJogo() {
		fimDeJogo = true;
	}
}
