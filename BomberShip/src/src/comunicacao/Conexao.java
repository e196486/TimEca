package comunicacao;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket; 
public class Conexao {

	public DataOutputStream dos;
	public DataInputStream dis;
	ServerSocket serverSocket;
	Socket socket;

	public boolean conexaoAceita;

	public String Player = "";

	String ip = "localhost";
	int porta = 1234;

	int erros = 0;

	public Conexao(String ip, int porta) {
		this.ip = ip;
		this.porta = porta;
		conexaoAceita = false;

	}

	public boolean conecta() {
		try {
			socket = new Socket(ip, porta);
			dos = new DataOutputStream(socket.getOutputStream());
			dis = new DataInputStream(socket.getInputStream());
			// TODO : enviar feedback para o jogo dizendo que está conectado
		} catch (IOException e) {
			System.out.println("Ainda nao existe: " + ip + ":" + porta + " | Estamos criando um Server...");
			return false;
		}
		conexaoAceita = true;
		System.out.println("Estamos conectados!");
		return true;
	}

	public void iniciaServer() {

		try {
			serverSocket = new ServerSocket(porta, 8, InetAddress.getByName(ip));
			System.out
					.println("Server Aberto. Chame seu amigo pelos dados: \n --ip: >" + ip + "< \n --porta: " + porta);
			this.Player = "Host";
			aguardaServerRequest();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void aguardaServerRequest() {
		Socket socket = null;

		try {
			socket = serverSocket.accept();
			dos = new DataOutputStream(socket.getOutputStream());
			dis = new DataInputStream(socket.getInputStream());
			conexaoAceita = true;
			System.out.println("Aceitamos o cliente");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void enviaDados(String jogada) {

		try {
			dos.writeUTF(jogada);
			dos.flush();
			System.out.println("DATA WAS SENT");
		} catch (IOException e) {
			erros++;
			e.printStackTrace();
		}

	}

	public String recebeDados() {

		try {
			if (conexaoAceita) {
				return dis.readUTF();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return "";

	}

	public String getMarInimigo() {
		return recebeDados();
	}

	public void SetMar(String Mar) {
		enviaDados(Mar);
		
	}

}
