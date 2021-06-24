package viewComponent;

public interface ILogRefactor {
	
	void updatePontos(int Pontos);
	public void updateMunicao(int Municao, String tipoCelula, String nomeJogador);
	void updateDicas(int Dicas, String nomeJogador);
	void updateLog(String mensagem);

}
