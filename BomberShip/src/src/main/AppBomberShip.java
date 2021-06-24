package main;

import montadorComponent.Montador;
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

				new Montador(menu.getIP(), menu.getPorta(), menu.getNivel());

			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
