package mc322.lab05;

public class Coordenada {

	int coluna, linha;
	String coordenada; 
	
	public Coordenada(String s) {
		
		this.coordenada = s;
 
		this.coluna  = Coluna(coordenada);
		this.linha  = Linha(coordenada);

	}
	
	public int Coluna (String coordenada) {
		switch (coordenada.substring(0, 1)) {
		case "a":
			coluna = 1;
			break;
		case "b":
			coluna = 2;
			break;
		case "c":
			coluna = 3;
			break;
		case "d":
			coluna = 4;
			break;
		case "e":
			coluna = 5;
			break;
		case "f":
			coluna = 6;
			break;
		case "g":
			coluna = 7;
			break;
		}
		
		return (coluna);
	}
	
	public int Linha (String coordenada) {

		linha = Integer.parseInt(coordenada.substring(1, 2));
		
		return (linha);
		
	}

}