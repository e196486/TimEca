package conexaoComponent;

public interface IBuildConexao {
	
	public boolean conecta();
	public void iniciaServer();
	public void SetMar(String arq);
	public String getPlayer();
	public String getMarInimigo();
	public Conexao getThis();
	public void setNivel(String snivel);
	public String getNivelInimigo();

}


 