package conexaoComponent;

public class InvalidClient extends ConnectionError{

	private static final long serialVersionUID = -5334358394967928623L;

	public InvalidClient(String mensagem) {
		super(mensagem);
	}

}
