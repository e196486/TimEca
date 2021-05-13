package mc322.lab06;

import java.util.Random;

public class Sala {
	char P = '-'; 
	boolean salaVisitada = false;// eu mudo o char pra # se tiver sido visitada.
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
			if (C.componente == 'W')
				Wumpus = C;
				
			/* adicionei essas duas casas que estavam faltando ( _ e # */	
			//Estou deixando a sala vazia quando é "_"
				
			else if (C.componente == 'B')
				Buraco = C;
			else if (C.componente == 'O') 
				Ouro = C;
			else if (C.componente == 'P') {
				Heroi = C;
				salaVisitada = true;
			}
			else if (C.componente == 'f') 
				Fedor = C;
			else if (C.componente == 'b')
				Brisa = C;
			
			atualizaChar();
			return false;
		}
	}
	
	public void atualizaChar() {
		if (salaVisitada) {
			if (Wumpus != null)
				P = 'W';
			else if (Buraco != null)
				P = 'B';
			else if (Ouro != null)
				P = 'O';
			else if (Heroi != null)
				P = 'P';
			else if (Fedor != null)
				P = 'f';
			else if (Brisa != null)
				P = 'b';
			else
				P = '#';
		} else {
			P = '-';
		}
		return;
	}
	
	public String confronto() {
		
		String confronto = "";
		
		//se for o wumpus 
		if (Wumpus != null) {
			if (1 == 1) {// considerando que o herói sempre está na sala quando confronto é chamado. Tem que arrumar.
				Random rand = new Random();
				int x = rand.nextInt(100);
				if (x < 50)
					confronto = "no:Wumpus derrotou Heroi";
				else {
					confronto = "ok:Wumpus derrotado";
					Wumpus = null;
					atualizaChar();
				}
			} else {
				confronto = "no:Wumpus derrotou Heroi";
			}
		}
		
		//se for o buraco
		
		if (Buraco != null) {
			confronto = "no:Tinha buraco";
		}
		
		//se for ouro 
		
		if (Ouro != null) {
			confronto = "ok:Tem ouro";
		}
		
		//se for Fedor 
		
		//se for Brisa 
		
		return confronto;
	}
	
}