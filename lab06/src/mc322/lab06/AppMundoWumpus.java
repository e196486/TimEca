package mc322.lab06;

public class AppMundoWumpus {
	
	public static void main(String[] args) { 
		
		String Arquivo = args[0];
		
		MontadorCaverna mont = new MontadorCaverna(Arquivo);
		
		StatusJogo status = mont.status; 
		
		Componente Heroi = mont.cave.room[1][1].Heroi;
		
		ControleJogo controle = new ControleJogo(Heroi,status);
		
		controle.leInput();
		
		mont.cave.imprimeEstado();
		
		 
	}

}
