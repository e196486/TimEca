package conexaoComponent;

public interface IBuildConexao {
	
	public boolean conecta();
	public void iniciaServer(); 
	public String getPlayer(); 
	public Conexao getThis(); 
	public void enviaDados(String info);
	public String recebeDados();

}


 