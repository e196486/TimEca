package mc322.lab06;

public class Coordenada {
	int linha;
	int coluna;
	char componente;
	
	
	public Coordenada ( String str[] ) {
		
		String coordenadaComposta = str[0];
		

		linha = Integer.parseInt(coordenadaComposta.substring(0, 1));
		coluna = Integer.parseInt(coordenadaComposta.substring(2, 3));
		componente = str[1].charAt(0);		
	}

}
