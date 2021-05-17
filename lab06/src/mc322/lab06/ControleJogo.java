package mc322.lab06;

import java.util.Scanner;

/*
 * recebe inputs e se comunica com os objetos componentes Verificar se o usu�rio
 * digitou uma sa�da inv�lida, ou seja qualquer caractere n�o compreendido pelas
 * teclas de a��o. 
 */

public class ControleJogo {
	Scanner keyboard = new Scanner(System.in);
	Componente heroi;
	String command = "";
	StatusJogo status;
	String ComandosPermitidos = 
			  " w -> Her�i movimenta para a sala acima,\n"
			+ " s -> Her�i movimenta para a sala abaixo,\n"
			+ " d -> Her�i movimenta para a sala a direita,\n"
			+ " a -> Her�i movimenta para a sala a esquerda,\n"
			+ " k -> Her�i equipa a flecha,\n"
			+ " c -> Her�i captura o ouro,\n"
			+ " q -> O usu�rio sai do jogo.\n";

	public ControleJogo(Componente heroijogo, StatusJogo status) {
		this.heroi = heroijogo;
		this.status = status;
		status.JogoAtivo = true;

		System.out.println("Insira aqui seu nome: ");

		status.player = keyboard.nextLine();
		
		System.out.println("Comece a jogar. Os comandos permitidos s�o : \n" + ComandosPermitidos);
		
		
		

	}

	public void leInput() {

		 while (status.JogoAtivo) {
			command = keyboard.nextLine();
			comando(command);
		}

		keyboard.close();

	}

	public boolean comando(String command) {
		boolean estado = true;

		switch (command) {
		case "w":
			heroi.movimenta("Cima");
			break;

		case "s":
			heroi.movimenta("Baixo");
			break;

		case "d":
			heroi.movimenta("Direita");
			break;

		case "a":
			heroi.movimenta("Esquerda");
			break;

		case "k":
			heroi.equipaFlecha();
			break;

		case "c":
			heroi.capturaOuro();
			break;

		case "q": // O usu�rio sai do jogo.
			status.quit();
			estado = false;
			break;

		default:
			System.err.println("Entrada Inv�lida. Tente novamente. Os comandos Permitidos S�o: \n" + ComandosPermitidos);
			break;
		}

		return estado;

	}

}
