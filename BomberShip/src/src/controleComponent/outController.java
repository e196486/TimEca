package controleComponent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import conexaoComponent.ICommandOut; 

public class outController implements ActionListener {

	// TODO passar os dados de Celula para cá

	public Time time;
	private ICommandOut conexao;

	public outController(ICommandOut conexao) {
		this.conexao = conexao;
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println("Clicou no Inimigo"); 
		conexao.enviaDados("Jogada");
	}

}
