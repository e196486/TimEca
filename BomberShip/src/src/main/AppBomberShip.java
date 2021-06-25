package main;

import montadorComponent.Montador;
import viewComponent.TelaExplicativa;
import viewComponent.TelaMenu;

public class AppBomberShip implements Runnable {

	static TelaMenu menu;

	public static void main(String[] args) {
		new AppBomberShip();

	}

	public AppBomberShip() {
		menu = new TelaMenu();
		menu.setVisible(true);
		Thread app = new Thread(this);
		app.start();
	}

	public void run() {

		try {
			if (menu.aguardaIniciaJogo()) {

				new TelaExplicativa(menu.getNivel()); 
				
				new Montador(menu.getIP(), menu.getPorta(), menu.getNivel(), menu.getNomeJogador());

			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
