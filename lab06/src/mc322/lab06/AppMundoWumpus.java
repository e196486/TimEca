package mc322.lab06;

public class AppMundoWumpus {
	
	public static void main(String[] args) {
		
		// aqui temos  que mudar depois para o args 
		String Arquivo = "C:\\Users\\muril\\Desktop\\TimECA (mc322)\\lab06\\data\\arq0001.csv";
		
		MontadorCaverna mont = new MontadorCaverna(Arquivo);
		
		Componente Heroi = mont.cave.cav[1][1].Heroi;
		
		StatusJogo status = mont.status;
		
		ControleJogo controle = new ControleJogo(Heroi,status);
		
		controle.leInput();
		
		mont.cave.imprimeEstado();
		
	}

}
