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
	
	
	
}