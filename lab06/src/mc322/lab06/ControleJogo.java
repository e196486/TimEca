package mc322.lab06;

import java.util.Scanner;

/*
 * recebe inputs e se comunica com os objetos componentes Verificar se o usuário
 * digitou uma saída inválida, ou seja qualquer caractere não compreendido pelas
 * teclas de ação. 
 */

public class ControleJogo {
	Scanner keyboard = new Scanner(System.in);
	Componente heroi;
	String command = "";
	StatusJogo status;
	String ComandosPermitidos = 
			  " w -> Herói movimenta para a sala acima,\n"
			+ " s -> Herói movimenta para a sala abaixo,\n"
			+ " d -> Herói movimenta para a sala a direita,\n"
			+ " a -> Herói movimenta para a sala a esquerda,\n"
			+ " k -> Herói equipa a flecha,\n"
			+ " c -> Herói captura o ouro,\n"
			+ " q -> O usuário sai do jogo.\n";

	public ControleJogo(Componente heroijogo, StatusJogo status) {
		this.heroi = heroijogo;
		this.status = status;
		status.JogoAtivo = true;

		System.out.println("Insira aqui seu nome: ");

		status.player = keyboard.nextLine();
		
		System.out.println("Comece a jogar. Os comandos permitidos são : \n" + ComandosPermitidos);
		
		
		

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

		case "q": // O usuário sai do jogo.
			status.quit();
			estado = false;
			break;

		default:
			System.err.println("Entrada Inválida. Tente novamente. Os comandos Permitidos São: \n" + ComandosPermitidos);
			break;
		}

		return estado;

	}

}
