package NET_26_DatagramPacket;

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
		String collec = "\n\t DatagramPacket – Representa um pacote de dados para comunicação UDP. \n";
		System.err.println(collec);

		linhas.run_Caracteres();
		Import_1 import_1 = new Import_1();
		System.out.println(import_1.run_Import_1());

		// linhas.run_Caracteres();
		// Import_2 import_2 = new Import_2();
		// System.out.println(import_2.run_Import_2());

		// linhas.run_Caracteres();
		// Import_3 import_3 = new Import_3();
		// System.out.println(import_3.run_Import_3());

		// linhas.run_Caracteres();
		// Import_4t import_4t = new Import_4t();
		// System.out.println(import_4t.run_Import_4t());

		//linhas.run_Caracteres();
		//Import_5t import_5t = new Import_5t();
		//System.out.println(import_5t.run_Import_5t());

		linhas.run_Caracteres();
		Import_6t import_6t = new Import_6t();
		System.out.println(import_6t.run_Import_6t());
		return "_________________________________________";
	}
}

class Import_1 {
	public String run_Import_1() throws Exception {
		System.err.println("1. Enviar um DatagramPacket (Cliente UDP): \n");

		DatagramSocket socket = new DatagramSocket();
		InetAddress endereco = InetAddress.getByName("localhost");
		String mensagem = "Olá, servidor!";
		byte[] buffer = mensagem.getBytes();

		DatagramPacket pacote = new DatagramPacket(buffer, buffer.length, endereco, 9876);
		socket.send(pacote);

		socket.close();

		return "\n\n***** *****|_____| ***** *****";
	}
}

class Import_2 {
	public String run_Import_2() throws Exception {
		System.err.println("2. Receber um DatagramPacket (Servidor UDP): \n");

		DatagramSocket socket = new DatagramSocket(9876);
		byte[] buffer = new byte[1024];

		DatagramPacket pacote = new DatagramPacket(buffer, buffer.length);
		System.out.println("Servidor aguardando mensagens...");

		socket.receive(pacote);
		String mensagem = new String(pacote.getData(), 0, pacote.getLength());
		System.out.println("Mensagem recebida: " + mensagem);

		socket.close();

		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_3 {
	public String run_Import_3() throws Exception {
		System.err.println("3. Cliente UDP com resposta do servidor: \n");

		DatagramSocket socket = new DatagramSocket();
		InetAddress endereco = InetAddress.getByName("localhost");

		String mensagem = "Oi, servidor!";
		byte[] buffer = mensagem.getBytes();
		DatagramPacket pacoteEnvio = new DatagramPacket(buffer, buffer.length, endereco, 9876);
		socket.send(pacoteEnvio);

		byte[] bufferRecebido = new byte[1024];
		DatagramPacket pacoteRecebido = new DatagramPacket(bufferRecebido, bufferRecebido.length);
		socket.receive(pacoteRecebido);

		String resposta = new String(pacoteRecebido.getData(), 0, pacoteRecebido.getLength());
		System.out.println("Resposta do servidor: " + resposta);

		socket.close();

		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_4t {
	public String run_Import_4t() throws Exception {
		System.err.println("4. Servidor UDP que responde ao cliente: \n");

		DatagramSocket socket = new DatagramSocket(9876);
		byte[] buffer = new byte[1024];

		DatagramPacket pacoteRecebido = new DatagramPacket(buffer, buffer.length);
		System.out.println("Servidor aguardando...");

		socket.receive(pacoteRecebido);
		String mensagem = new String(pacoteRecebido.getData(), 0, pacoteRecebido.getLength());
		System.out.println("Mensagem recebida: " + mensagem);

		String resposta = "Recebido!";
		byte[] bufferResposta = resposta.getBytes();
		InetAddress enderecoCliente = pacoteRecebido.getAddress();
		int portaCliente = pacoteRecebido.getPort();
		DatagramPacket pacoteResposta = new DatagramPacket(bufferResposta, bufferResposta.length, enderecoCliente,
				portaCliente);

		socket.send(pacoteResposta);
		socket.close();

		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_5t {
	public String run_Import_5t() throws Exception {
		System.err.println("5. Cliente UDP que envia números e recebe soma: \n");

		DatagramSocket socket = new DatagramSocket();
		InetAddress endereco = InetAddress.getByName("localhost");

		String numeros = "10,20,30";
		byte[] buffer = numeros.getBytes();
		DatagramPacket pacoteEnvio = new DatagramPacket(buffer, buffer.length, endereco, 9876);
		socket.send(pacoteEnvio);

		byte[] bufferRecebido = new byte[1024];
		DatagramPacket pacoteRecebido = new DatagramPacket(bufferRecebido, bufferRecebido.length);
		socket.receive(pacoteRecebido);

		String resposta = new String(pacoteRecebido.getData(), 0, pacoteRecebido.getLength());
		System.out.println("Soma recebida do servidor: " + resposta);

		socket.close();

		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_6t {
	public String run_Import_6t() throws Exception {
		System.err.println("6. Cliente UDP que envia e recebe mensagens continuamente: \n");
		DatagramSocket socket = new DatagramSocket();
		InetAddress endereco = InetAddress.getByName("localhost");
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.print("Digite sua mensagem (ou 'sair' para encerrar): ");
			String mensagem = scanner.nextLine();
			if (mensagem.equalsIgnoreCase("sair"))
				break;

			byte[] buffer = mensagem.getBytes();
			DatagramPacket pacoteEnvio = new DatagramPacket(buffer, buffer.length, endereco, 9876);
			socket.send(pacoteEnvio);

			byte[] bufferRecebido = new byte[1024];
			DatagramPacket pacoteRecebido = new DatagramPacket(bufferRecebido, bufferRecebido.length);
			socket.receive(pacoteRecebido);

			String resposta = new String(pacoteRecebido.getData(), 0, pacoteRecebido.getLength());
			System.out.println("Servidor: " + resposta);
		}

		socket.close();
		scanner.close();

		return "\n\n***** ***** |_____| ***** *****";
	}
}