package conexaoComponent;

public interface ICommandIn {

	void aguardaServerRequest() throws InvalidClient;
	Object getPlayer();
	String recebeDados() throws InvalidEnemy;
	boolean getConexaoAceita();
	void enviaDados(String string) throws InvalidMove;

}
