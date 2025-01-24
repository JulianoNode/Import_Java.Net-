package NET_08_DatagramSocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

import util.Linhas;

public class Simples {
	public String Simples_Run() throws Exception {

		Linhas linhas = new Linhas();
		String collec = "\n\t DatagramSocket – Representa um socket para comunicação usando o protocolo UDP. \n";
		System.err.println(collec);

		// linhas.run_Caracteres();
		// Import_1 import_1 = new Import_1();
		// System.out.println(import_1.run_Import_1());

		linhas.run_Caracteres();
		Import_2 import_2 = new Import_2();
		System.out.println(import_2.run_Import_2());

		// linhas.run_Caracteres();
		// Import_3 import_3 = new Import_3();
		// System.out.println(import_3.run_Import_3());

		//linhas.run_Caracteres();
		//Import_2w import_2w = new Import_2w();
		//System.out.println(import_2w.run_Import_2w());

		linhas.run_Caracteres();
		Import_3t import_3t = new Import_3t();
		System.out.println(import_3t.run_Import_3t());
		return "_________________________________________";
	}
}

class Import_1 {
	public String run_Import_1() throws SocketException {
		System.err.println("1. Servidor UDP Simples\n");

		DatagramSocket socket = new DatagramSocket(1234);
		byte[] buffer = new byte[1024];

		System.out.println("Servidor UDP esperando mensagens...");

		while (true) {
			DatagramPacket pacoteRecebido = new DatagramPacket(buffer, buffer.length);
			try {
				socket.receive(pacoteRecebido);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String mensagem = new String(pacoteRecebido.getData(), 0, pacoteRecebido.getLength());

			System.out.println("Recebido: " + mensagem);
			if (mensagem.equalsIgnoreCase("sair"))
				break;
		}

		socket.close();
		return "\n\n***** |_____| *****";
	}
}

class Import_2 {
	public String run_Import_2() throws Exception {
		System.err.println("2. Cliente UDP Simples\n");

		DatagramSocket socket = new DatagramSocket();
		InetAddress endereco = InetAddress.getByName("localhost");

		Scanner scanner = new Scanner(System.in);
		System.out.print("Digite uma mensagem: ");
		String mensagem = scanner.nextLine();

		byte[] buffer = mensagem.getBytes();
		DatagramPacket pacote = new DatagramPacket(buffer, buffer.length, endereco, 12345);
		socket.send(pacote);

		socket.close();
		scanner.close();
		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_3 {
	public String run_Import_3() throws Exception {
		System.err.println("3. Servidor UDP que Responde. \n");
		DatagramSocket socket = new DatagramSocket(1234);
		byte[] buffer = new byte[1024];

		System.out.println("Servidor UDP aguardando mensagem...");

		while (true) {
			DatagramPacket pacoteRecebido = new DatagramPacket(buffer, buffer.length);
			socket.receive(pacoteRecebido);
			String mensagem = new String(pacoteRecebido.getData(), 0, pacoteRecebido.getLength());

			System.out.println("Recebido: " + mensagem);
			if (mensagem.equalsIgnoreCase("sair"))
				break;

			String resposta = "Mensagem recebida: " + mensagem;
			byte[] bufferResposta = resposta.getBytes();
			DatagramPacket pacoteResposta = new DatagramPacket(bufferResposta, bufferResposta.length,
					pacoteRecebido.getAddress(), pacoteRecebido.getPort());
			socket.send(pacoteResposta);
		}

		socket.close();

		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_2w {
	public String run_Import_2w() throws IOException {
		System.err.println("4. Cliente UDP que Recebe Resposta\n");

		DatagramSocket socket = new DatagramSocket();
		InetAddress endereco = InetAddress.getByName("localhost");

		Scanner scanner = new Scanner(System.in);
		System.out.print("Digite uma mensagem: ");
		String mensagem = scanner.nextLine();

		byte[] buffer = mensagem.getBytes();
		DatagramPacket pacoteEnvio = new DatagramPacket(buffer, buffer.length, endereco, 12345);
		socket.send(pacoteEnvio);

		byte[] bufferRecebido = new byte[1024];
		DatagramPacket pacoteRecebido = new DatagramPacket(bufferRecebido, bufferRecebido.length);
		socket.receive(pacoteRecebido);
		String resposta = new String(pacoteRecebido.getData(), 0, pacoteRecebido.getLength());

		System.out.println("Resposta do servidor: " + resposta);

		socket.close();
		scanner.close();
		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_3t {
	public String run_Import_3t() throws Exception {
		System.err.println("5. Cliente UDP de Broadcast\n");
		
		 DatagramSocket socket = new DatagramSocket();
	        socket.setBroadcast(true);

	        String mensagem = "Olá, servidores!";
	        byte[] buffer = mensagem.getBytes();
	        InetAddress endereco = InetAddress.getByName("➡️ 255.255.255.255");

	        DatagramPacket pacote = new DatagramPacket(buffer, buffer.length, endereco, 12345);
	        socket.send(pacote);

	        System.out.println("Mensagem de broadcast enviada!");
	        System.out.println(endereco);
	        socket.close();
		return "\n\n***** ***** |_____| ***** *****";
	}
}