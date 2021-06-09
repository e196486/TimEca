package main;


//teste

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
			if (menu.aguardaIniciaJogo()) {
				
				String Arquivo = "C:\\Users\\muril\\Desktop\\TimECA (mc322)\\BomberShip\\data\\arq0001.csv";
				new Construtor(menu.getIP(), menu.getPorta(), Arquivo);
				
			}
				

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//TODO: Adicionar um catch exception da leitura do arquivo aqui 

		

	}

}
