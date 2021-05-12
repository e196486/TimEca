package mc322.lab06;

public class StatusJogo {
	
	String player = ""; 
	int score; 
	int numFlechas; 
	boolean temOuro; 
	boolean derrotaWumpus;
	boolean movimento;
	boolean JogoAtivo;
	
	
	
	public StatusJogo () { 
		this.score = 0;
		numFlechas = 1;
		temOuro = false;
		derrotaWumpus = false; 
		JogoAtivo = true;
		
	}
	
	
	public void derrotaHeroi() {
		score -= 1000;	
	}
	
	public void moveHeroi(){
		score -= 15; 
	}
	
	public void usaFlecha (){
		numFlechas --;
		score -= 100;
		
	}
	
	public void derrotaWumpus() {
		derrotaWumpus = true;
		score += 500;
	}
	
	public void pegaOuro() {
		
	}
	
	public boolean Confronto (String confronto) {
		/* Esse método tem por objetivo traduzir o que é pego a partir do confronto que acontece nas classes sala e atualizar o status do jogo*/
		
		// ok: Wumpus derrotado
		// ok: Tem Brisa
		// ok: Tem Fedor 
		// ok: Tem ouro 
		// No: Tinha buraco 		 
		// No: Wumpus derrotou Heroi
		
		
		movimento = (confronto.substring(1,2) == "ok");
		
		String statMov  = confronto.substring(3);
		
		switch (statMov) {
		case "Wumpus derrotado" : 
			derrotaWumpus();
			break;
		case "Tem ouro":
			pegaOuro();
			break;
			
		case "Tinha buraco" : case "Wumpus derrotou Heroi":
			derrotaHeroi();
		
		}
			 
		
		return movimento; 
	}

}
