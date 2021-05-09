package mc322.lab06;

public class Heroi extends Componente {
	StatusJogo status;
	Caverna cave;

	public Heroi(String str[], StatusJogo status, Caverna cave) {
		super(str);
		this.cave = cave;
		this.status = status;

	}

	public boolean movimenta(String direcao) {

		// Aqui nesse m�todo, o Heroi recebe de controle as dire��es e a partir disso,
		// manda para a caverna o pedido de movimento. Se for poss�vel, ela ir� se
		// movimentar. Tudo ser� devolvido atrav�s do Status.

		switch (direcao) {
		case "Cima":
			status = cave.solicitaMovimento(this, linha + 1, coluna);
			break;
		case "Baixo":
			status = cave.solicitaMovimento(this, linha - 1, coluna);
			break;
		case "Esquerda":
			status = cave.solicitaMovimento(this, linha, coluna - 1);
			break;
		case "Direita":
			status = cave.solicitaMovimento(this, linha + 1, coluna + 1);
			break;
		}

		if (status.movimento)
			status.moveHeroi();

		return true;
	}

	public boolean equipaFlecha() {
		return false;
	}

	public boolean capturaOuro() {
		status.pegaOuro();
		return true;
	}

}
