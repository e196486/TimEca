package conexaoComponent;

public interface ICommandIn {

	void aguardaServerRequest();
	Object getPlayer();
	String recebeDados();
	boolean getConexaoAceita();

}
