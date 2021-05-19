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
		if ((C.componente == 'W'||C.componente == 'B'||C.componente == 'O') && (Wumpus != null || Buraco != null || Ouro != null))// se já houver algum desses componentes na sala, retorna falso para a caverna.
			return true;
		else if((C.componente == 'P'|| C.componente == 'f'||C.componente == 'b'
				)&& Buraco != null) 
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
	
	public String[] confronto(StatusJogo status) {
		String result[] = new String[4]; 
		
		if (Fedor != null) { 
			result[1] =  "Tem Fedor";
			result[0] = "ok";
		}
		if (Brisa != null) {
			result[0] = "ok";
			result[2] = "Tem Brisa";
		}
		//se for o wumpus 
		if (Wumpus != null) {
			if (status.flechaEquipada) {
				Random rand = new Random();
				int x = rand.nextInt(100);
				System.out.print("batalha com o wumpus. chance: " + x + "\n");
				if (x < 50) {
					result[0] = "no";
					result[3] = "Wumpus derrotou Heroi";
				}
				else {

					Wumpus = null;
					atualizaChar();
					result[0] = "ok";
					result[3] = "Wumpus derrotado";
				}
			} else {
				result[0] = "no";
				result[3] = "Wumpus derrotou Heroi";
			}
		}
		
		if (status.flechaEquipada) {
			status.usaFlecha();
			}
		
		if (Buraco != null) {
			result[0] = "no";
			result[3] = "Tinha buraco";
		}
		
		if (Ouro != null) {
			result[0] = "ok";
			result[3] =  "Tem ouro";
		}
		if (result[3] == null && result[1] == null && result[2] == null) {
			result[0] = "ok";
			result[3] = "Vazio";
		}
		return result;
	}
	
}
