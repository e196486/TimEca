package comunicacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class outController implements ActionListener {

	// TODO passar os dados de Celula para cá

	public Time time;
	private Conexao conexao;

	public outController(Conexao conexao) {
		this.conexao = conexao;
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println("Clicou no Inimigo");

	}

}
