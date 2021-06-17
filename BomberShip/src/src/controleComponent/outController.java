package controleComponent;
 
import conexaoComponent.ICommandOut; 

public class outController implements IMarListener {

	// TODO passar os dados de Celula para cá

	public Time time;
	private ICommandOut conexao;
	int i;
	int j;
	
	public outController(ICommandOut conexao) {
		this.conexao = conexao; 
	}

	public void celulaAcionada(int i, int j) {
		System.out.println("Clicou no Inimigo i: "+i+"  j:"+j); 
		conexao.enviaDados("Jogada");
	}

}
