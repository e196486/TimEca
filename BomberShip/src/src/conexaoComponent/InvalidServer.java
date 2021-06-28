package conexaoComponent;

public class InvalidServer extends ConnectionError{

	private static final long serialVersionUID = -500257707705435741L;

	public InvalidServer(String mensagem) {
		super(mensagem);
	}
}
