package controleComponent;
 
import conexaoComponent.ICommandOut;
import marComponent.Mar.IBuildMar;

public class outController implements IMarListener {

	// TODO passar os dados de Celula para cá
	
	IBuildMar mar;
	Bomba bomba;
	
	public Time time;
	private ICommandOut conexao;
	int i;
	int j;
	
	public outController(ICommandOut conexao, IBuildMar mar, Bomba bomba) {
		this.conexao = conexao;
		this.mar = mar;
		this.bomba = bomba;
	}

	//Adicionei mar e bomba nessa classe para controlar as açoes.
	public void celulaAcionada(int i, int j) {
		System.out.println("Clicou no Inimigo i: "+i+"  j:"+j); 
		conexao.enviaDados("Jogada");
		if (bomba.getBombas() > 0)
			mar.getCelula(i, j).explode(bomba);
		if (bomba.dicaEquipada()) {
			mar.getCelula(i+1, j).setCelulaRevelada(true);
			mar.getCelula(i, j+1).setCelulaRevelada(true);
			mar.getCelula(i-1, j).setCelulaRevelada(true);
			mar.getCelula(i, j-1).setCelulaRevelada(true);
		}
	}

}
