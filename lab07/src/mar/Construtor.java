package mar;

import Comunicacao.*;
import main.*;

public class Construtor {

	Conexao conexao;

	public Construtor(String ip, int porta) {

		conexao = new Conexao(ip, porta);

		if (!conexao.conecta())
			conexao.iniciaServer();

		new TelaJogo();

	}

}
