package main;

import mar.Construtor;

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
			if (!menu.aguardaIniciaJogo())
				;

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		String Arquivo = "C://users//henri//OneDrive//ÁreadeTrabalho//arq0001.csv";
		
		new Construtor(menu.getIP(), menu.getPorta(), Arquivo);

	}

}
