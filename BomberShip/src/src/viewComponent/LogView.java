package viewComponent;

import java.awt.Color; 
import java.awt.Dimension; 
import javax.swing.JPanel;
import javax.swing.JTextArea; 

public class LogView extends JPanel implements IItemRefactor {
 
	private static final long serialVersionUID = -8692875603717573889L;
	
	private String texto;
	JTextArea campoLog;
	int position = 2;
	
	public LogView() {
		texto = 
				"-------------------------------------------- campo de atualizações --------------------------------------------\n"
				+ " Jogo Iniciado";
	}

	public void setPontos(int Pontos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMunicao(int Municao) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDicas(int Dicas) {
		// TODO Auto-generated method stub
		
	}
	
	public void updateLog(String mensagem) { 
		position++;
		campoLog.setEditable(true);
		campoLog.append( "\n" + mensagem );
		campoLog.setEditable(false);
		campoLog.setCaretPosition(campoLog.getText().length());
		
	}

	public JPanel criaLog() {

		this.setPreferredSize(new Dimension(1000, 100)); 
		this.setLayout(null);

		campoLog = new JTextArea();
		campoLog.setEditable(false);
		campoLog.setForeground(Color.GRAY);
		campoLog.setText(texto);
		campoLog.setBounds(10, 10, 1000, 80);

		this.add(campoLog);
		this.setVisible(true);
		return this;
	}


}
