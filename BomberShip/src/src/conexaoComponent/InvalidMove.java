package conexaoComponent;

public class InvalidMove extends ConnectionError{

	private static final long serialVersionUID = -3037470156121346575L;

	public InvalidMove(String mensagem) {
		super(mensagem);
	}

}
