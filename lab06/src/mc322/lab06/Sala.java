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
		if ((C.componente != 'P') && (Wumpus != null || Buraco != null || Ouro != null))// se já houver algum desses componentes na sala, retorna falso para a caverna.
			return true;
		else if((C.componente == 'P')&& Buraco != null) 
			return true;
		else {
			P = C.componente;
			if (C.componente == 'W')
				Wumpus = C;
			 
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
	
	public String confronto(StatusJogo status) {
		 
		
		//se for o wumpus 
		if (Wumpus != null) {
			if (status.flechaEquipada) {// considerando que o herói sempre está na sala quando confronto é chamado. Tem que arrumar.
				Random rand = new Random();
				int x = rand.nextInt(100);
				System.out.print("batalha com o wumpus. chance: " + x);
				if (x < 50)
					return "no:Wumpus derrotou Heroi";
				else {
					Wumpus = null;
					atualizaChar();
					return "ok:Wumpus derrotado";
				}
			} else {
				return  "no:Wumpus derrotou Heroi";
			}
		}
		
		if (status.flechaEquipada) {
			status.usaFlecha();
			}
		
		if (Buraco != null) 
			return "no:Tinha buraco";
		
		
		if (Ouro != null) 
			return  "ok:Tem ouro";
		
		
		if (Fedor != null) 
			return  "ok: Tem Fedor";
		
		
		if (Brisa != null) 
			return  "ok: Tem Brisa";
		
		 
		return "ok: Vazio";
	}
	
}