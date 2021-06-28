package conexaoComponent;

public class ConnectionError extends Exception{

	private static final long serialVersionUID = 6282230830622969892L;
	
	public ConnectionError(String mensagem) {
		super(mensagem);
	}
}
