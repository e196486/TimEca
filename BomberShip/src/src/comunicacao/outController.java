package comunicacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import celulas.Time;

public class outController implements ActionListener {
	
	//TODO passar os dados de Celula para cá 
	
	Time time;
	Conexao conexao;

	public outController(Time time) {
		this.time = time;
	}

	public void actionPerformed(ActionEvent e) {
		if (time == Time.Aliado)
			System.out.println("você não pode mexer no seu tabuleiro");
		
	}

}
