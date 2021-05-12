package mc322.lab06;

public class Heroi extends Componente {
	StatusJogo status;
	Caverna cave;
	boolean flecha, // se tem flecha disponível
			flechaEquip; // se a flecha está equipada

	public Heroi(String str[], StatusJogo status, Caverna cave) {
		super(str);
		this.cave = cave;
		this.status = status;
		flecha = true;
		flechaEquip = false;

	}

	public boolean movimenta(String direcao) {

		// Aqui nesse método, o Heroi recebe de controle as direções e a partir disso,
		// manda para a caverna o pedido de movimento. Se for possível, ela irá se
		// movimentar. Tudo será devolvido através do Status.

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
		if (flecha)
			flechaEquip = true;
		else
			flechaEquip = false;
		return flechaEquip;
	}

	public boolean capturaOuro() {
		cave.retiraOuro(linha, coluna); //Tirando o Ouro da sala sem fazer referência direta a ela.
		status.pegaOuro();
		return true;
	}

}
