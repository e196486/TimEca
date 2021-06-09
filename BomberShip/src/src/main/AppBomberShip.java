package main;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

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

				URL res = getClass().getClassLoader().getResource("/BomberShip/data/arq0001.csv");
				File file = Paths.get(res.toURI()).toFile();
				String arquivo1 = file.getAbsolutePath();
				
				
				System.out.println(arquivo1);
				new Construtor(menu.getIP(), menu.getPorta(), arquivo1);

			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} 

	}

}
