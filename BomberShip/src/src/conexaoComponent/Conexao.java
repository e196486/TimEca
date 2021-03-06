package conexaoComponent;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Conexao implements ICommandIn,ICommandOut {

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

	public String getPlayer() {
		return Player;
	}

	public boolean conecta() throws NullServer{
		try {
			socket = new Socket(ip, porta);
			dos = new DataOutputStream(socket.getOutputStream());
			dis = new DataInputStream(socket.getInputStream());
			conexaoAceita = true;
			System.out.println("Estamos conectados!");

		} catch (IOException e) { // nullServer
			System.out.println("Ainda nao existe: " + ip + ":" + porta + " | Estamos criando um Server...");
			return false;
		}

		return true;
	}

	public void iniciaServer() throws InvalidServer{

		try {
			serverSocket = new ServerSocket(porta, 8, InetAddress.getByName(ip));
			System.out
					.println("Server Aberto. Chame seu amigo pelos dados: \n --ip: >" + ip + "< \n --porta: " + porta);
			this.Player = "Host";
			aguardaServerRequest();

		} catch (Exception e) { // invalidServer
			e.printStackTrace();
		}

	}

	public void aguardaServerRequest() throws InvalidClient{
		Socket socket = null;

		try {
			socket = serverSocket.accept();
			dos = new DataOutputStream(socket.getOutputStream());
			dis = new DataInputStream(socket.getInputStream());
			conexaoAceita = true;
			System.out.println("Aceitamos o cliente");

		} catch (IOException e) { // InvalidClient
			e.printStackTrace();
		}
	}

	public void enviaDados(String info) throws InvalidMove{

		try {
			dos.writeUTF(info);
			dos.flush(); 
		} catch (IOException e) { // InvalidMove && InvalidEnemy
			erros++; 
		}

	}

	public String recebeDados() throws InvalidEnemy{

		try {
			if (conexaoAceita) {
				return dis.readUTF();
			}

		} catch (IOException e) { // InvalidEnemy
			System.out.println("o Outro usuario saiu da partida, Fim de Jogo!");
			return "fimDeJogo";
		}

		return "";

	}
  

	public Conexao getThis() {
		return this;
	}

	@Override
	public boolean getConexaoAceita() {
		return conexaoAceita;
	}

}
