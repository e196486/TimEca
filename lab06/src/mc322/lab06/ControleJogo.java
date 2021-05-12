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

	public ControleJogo(Componente heroijogo, StatusJogo status) {
		this.heroi = heroijogo;
		this.status = status;
		status.JogoAtivo = true;

		System.out.println("Insira aqui seu nome: ");

		status.player = keyboard.nextLine();
		
		System.out.println("Comece a jogar");
		

	}

	public void leInput() {

		do {
			command = keyboard.nextLine();
			status.JogoAtivo = comando(command);
		} while (status.JogoAtivo);

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
			System.out.println("�Volte sempre !�");
			estado = false;
			break;

		default:
			System.err.println("Entrada Inv�lida. Tente novamente.");
			break;
		}

		return estado;

	}

}
