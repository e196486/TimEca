package mc322.lab06;

public class StatusJogo {

	String player = "";
	int score;
	int numFlechas;
	boolean temOuro;
	boolean derrotaWumpus;
	boolean movimento;
	boolean JogoAtivo;
	boolean flechaEquipada;
	String mensagemFinal = "";

	public StatusJogo() {
		this.score = 0;
		numFlechas = 1;
		temOuro = false;
		derrotaWumpus = false;
		JogoAtivo = true;
		flechaEquipada = false;

	}
	
	public void quit () {
		mensagemFinal = "Volte sempre !"; 
		JogoAtivo = false;
	}
	public void win () {
		score += 1000;
		mensagemFinal = "Voce ganhou =D !!!"; 
		JogoAtivo = false;	
	}
	public void lose () {
		mensagemFinal = "Voce perdeu =( ..."; 
		JogoAtivo = false;	
	}

	public void derrotaHeroi() {
		score -= 1000;
	}

	public void moveHeroi() {
		score -= 15;
	}

	public void usaFlecha() {
		numFlechas--;
		score -= 100;
		flechaEquipada = false;
		System.out.println("Flecha Usada");

	}

	public void derrotaWumpus() {
		derrotaWumpus = true;
		score += 500;
	}

	public void pegaOuro() {
		temOuro = true;
		System.out.println("Ouro Pego");

	}
	

	public boolean Confronto(String confronto) {
		/*
		 * Esse método tem por objetivo traduzir o que é pego a partir do confronto que
		 * acontece nas classes sala e atualizar o status do jogo
		 */

		// ok: Wumpus derrotado
		// ok: Tem Brisa
		// ok: Tem Fedor
		// ok: Tem ouro
		// No: Tinha buraco
		// No: Wumpus derrotou Heroi
		
		System.out.println(confronto.substring(3) );

		if (confronto != null) {
			movimento = (confronto.substring(0, 2).equals("ok"));
			
			if (movimento)
				moveHeroi();

			String statMov = confronto.substring(3);

			switch (statMov) {
			case "Wumpus derrotado":
				derrotaWumpus();
				break;
			case "Tem ouro":
				break;

			case "Tinha buraco":
			case "Wumpus derrotou Heroi":
				derrotaHeroi();
				lose();
				break;

			}
		}

		return movimento;
	}

}
