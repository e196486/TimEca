package mc322.lab06;

public class Sala {
	char P = '-'; 
	Componente Wumpus = null,
			Buraco = null,
			Ouro = null,
			Heroi = null,
			Brisa = null,
			Fedor = null;
			
	
	
	public boolean insereC(Componente C) {
		if (Wumpus != null || Buraco != null || Ouro != null)// se já houver algum desses componentes na sala, retorna falso para a caverna.
			return false;
		else {
			P = C.componente;
			if (C.componente == 'W') {
				Wumpus = C;
				P = 'W';
	
			/* adicionei essas duas casas que estavam faltando ( _ e # */	
			}else if (C.componente == '_') {
				Buraco = C;
				P = '-';
			}else if (C.componente == '#') {
				Buraco = C;
				P = '#';
			}
			else if (C.componente == 'B') {
				Buraco = C;
				P = 'B';
			}
			else if (C.componente == 'O') {
				Ouro = C;
				P = 'O';
			}
			else if (C.componente == 'P') {
				Heroi = C;
				if(Wumpus == null && Buraco == null && Ouro == null)
					P = 'P';
			}
			else if (C.componente == 'f') {
				Fedor = C;
				if(Wumpus == null && Buraco == null && Ouro == null && Heroi == null)
					P = 'f';
			}else {
				Brisa = C;
				if(Wumpus == null && Buraco == null && Ouro == null && Heroi == null && Fedor == null)
					P = 'b';
			}
			return true;
		}
	}
	
	public String confronto() {
		
		//se for o wumpus 
		
		//se for o buraco
		
		//se for ouro 
		
		//se for Fedor 
		
		//se for Brisa 
		
		return "Status do Movimento";
	}
	
}