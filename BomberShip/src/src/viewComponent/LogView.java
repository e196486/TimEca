package viewComponent;

import java.awt.Color; 
import java.awt.Dimension; 
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea; 

public class LogView extends JPanel implements ILogRefactor {
 
	private static final long serialVersionUID = -8692875603717573889L;
	
	private String texto;
	JTextArea campoLog;  
	
	public LogView() {
		texto = 
				"-------------------------------------------- campo de atualizações --------------------------------------------\n"
				+ " Jogo Iniciado";
	}

	public void updatePontos(int Pontos) {
		texto = "Pontos atualizados!! Quantidade atual: " + Pontos;
		updateLog(texto);
		
	}

	@Override
	public void updateMunicao(int Municao, String tipoCelula) {
		texto = "Munição utilizada. Quantidade restante: " + Municao;
		updateLog(texto);
	}

	@Override
	public void updateDicas(int Dicas) {
		texto = "Dica utilizada. Quantidade restante: " + Dicas;
		updateLog(texto);
	}
	
	public void updateLog(String mensagem) {  
		campoLog.setEditable(true);
		campoLog.append( "\n" + mensagem ); 
        campoLog.setCaretPosition(campoLog.getText().length() - 1);
		campoLog.setEditable(false);
		
	}

	public JPanel criaLog() {

		this.setPreferredSize(new Dimension(1000, 100)); 
		this.setLayout(null);

		campoLog = new JTextArea();
		campoLog.setEditable(false);
		campoLog.setForeground(Color.GRAY);
		campoLog.setText(texto); 
		
		JScrollPane scrollLog = new JScrollPane(campoLog);
		scrollLog.setBounds(10, 10, 1000, 55);
  
		
		
		this.add(scrollLog);
		this.setVisible(true);
		return this;
	}


}
