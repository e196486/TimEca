package mc322.lab06;

public class Heroi extends Componente {
	StatusJogo status;
	Caverna cave;
	boolean temFlecha, // se tem flecha dispon?vel
			flechaEquip; // se a flecha est? equipada

	public Heroi(String str[], StatusJogo status, Caverna cave) {
		super(str);
		this.cave = cave;
		this.status = status;
		temFlecha = true;
		flechaEquip = false;

	}

	public void setStatus(StatusJogo status) {
		this.status = status;
	}

	public void setCave(Caverna cave) {
		this.cave = cave;
	}

	public boolean equipaFlecha() {

		flechaEquip = temFlecha;

		if (flechaEquip) {
			status.flechaEquipada = true;
			System.out.println("Flecha Equipada");
		} else {
			System.out.println("N?o temos flechas dispon?veis");
		}
		return flechaEquip;
	}

	public boolean movimenta(String direcao) {

		// Aqui nesse m?todo, o Heroi recebe de controle as dire??es e a partir disso,
		// manda para a caverna o pedido de movimento. Se for poss?vel, ela ir? se
		// movimentar. Tudo ser? devolvido atrav?s do Status.

		switch (direcao) {
		case "Cima":
			status = cave.solicitaMovimento(this, linha - 1, coluna);
			break;
		case "Baixo":
			status = cave.solicitaMovimento(this, linha + 1, coluna);
			break;
		case "Esquerda":
			status = cave.solicitaMovimento(this, linha, coluna - 1);
			break;
		case "Direita":
			status = cave.solicitaMovimento(this, linha, coluna + 1);
			break;
		}

		temFlecha = status.numFlechas == 1;
		flechaEquip = status.flechaEquipada;

		return true;
	}

	public boolean capturaOuro() {
		cave.retiraOuro(linha, coluna); // Tirando o Ouro da sala sem fazer refer?ncia direta a ela.
		status.pegaOuro();
		return true;
	}

}
