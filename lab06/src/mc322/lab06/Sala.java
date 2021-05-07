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
				P = 'P';
			}
			else if (C.componente == 'b') {
				Brisa = C;
				P = 'b';
			}else {
				Fedor = C;
				P = 'f';
			}
			return true;
		}
	}
}