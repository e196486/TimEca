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
	String Jogada;
	
	public outController(ICommandOut conexao, Bomba bomba) {
		this.conexao = conexao;
		this.bomba = bomba;
	}
	public void setMar(IBuildMar mar) {
		this.mar = mar;	
	}

	//Adicionei mar e bomba nessa classe para controlar as açoes.
	public void celulaAcionada(int i, int j) {
		
		System.out.println("Clicou no Inimigo i: "+i+"  j:"+j); 
		Jogada = "("+i+":"+j+")";
		
		conexao.enviaDados(Jogada);
		
		
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
