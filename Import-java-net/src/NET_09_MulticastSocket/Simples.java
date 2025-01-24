package NET_09_MulticastSocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.net.UnknownHostException;

import util.Linhas;

public class Simples {
	public String Simples_Run() throws Exception {

		Linhas linhas = new Linhas();
		String collec = "\n\t MulticastSocket – Extensão de DatagramSocket usada para comunicação multicast. \n";
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

		linhas.run_Caracteres();
		Import_2q import_2q = new Import_2q();
		System.out.println(import_2q.run_Import_2q());

		linhas.run_Caracteres();
		Import_3q import_3q = new Import_3q();
		System.out.println(import_3q.run_Import_3q());
		return "_________________________________________";
	}
}

class Import_1 {
	@SuppressWarnings("deprecation")
	public String run_Import_1() throws IOException {
		System.err.println("1. Criar um Socket Multicast (Servidor)\n");

		MulticastSocket socket = new MulticastSocket(5000);
		InetAddress group = InetAddress.getByName("230.0.0.0");
		socket.joinGroup(group);

		byte[] buffer = new byte[1024];
		DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

		System.out.println("Servidor aguardando mensagens...");
		socket.receive(packet);
		System.out.println("Mensagem recebida: " + new String(packet.getData()).trim());

		socket.leaveGroup(group);
		socket.close();
		return "\n\n***** |_____| *****";
	}
}

class Import_2 {
	public String run_Import_2() throws IOException {
		System.err.println("2. Enviar Mensagem Multicast (Cliente)\n");

		DatagramSocket socket = new DatagramSocket();
		InetAddress group = InetAddress.getByName("230.0.0.0");

		String message = "Olá, Multicast!";
		byte[] buffer = message.getBytes();
		DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, 8070);

		socket.send(packet);
		System.out.println(group);
		System.out.println("Mensagem enviada!");
		socket.close();
		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_3 {
	public String run_Import_3() throws IOException {
		System.err.println("3. Servidor que Escuta Múltiplas Mensagens\n");

		MulticastSocket socket = new MulticastSocket(8071);
		InetAddress group = InetAddress.getByName("230.0.0.0");
		socket.joinGroup(group);

		byte[] buffer = new byte[1024];

		while (true) {
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
			socket.receive(packet);
			String message = new String(packet.getData(), 0, packet.getLength());
			System.out.println("Recebido: " + message);

			if ("sair".equalsIgnoreCase(message.trim())) {
				break;
			}
		}

		socket.leaveGroup(group);
		socket.close();
		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_2q {
	public String run_Import_2q() throws Exception {
		System.err.println("4. Cliente que Envia Mensagem a Cada 5 Segundos\n");
		DatagramSocket socket = new DatagramSocket();
		InetAddress group = InetAddress.getByName("230.0.0.0");

		for (int i = 1; i <= 5; i++) {
			String message = "Mensagem " + i;
			byte[] buffer = message.getBytes();
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, 5000);

			socket.send(packet);
			System.out.println("Enviado: " + message);
			Thread.sleep(5000);
		}

		socket.close();
		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_3q {
	public String run_Import_3q() throws Exception {
		System.err.println("5. Cliente Que Recebe Mensagens com TTL Ajustado\n");
		
	     MulticastSocket socket = new MulticastSocket(5000);
	        InetAddress group = InetAddress.getByName("230.0.0.0");

	        socket.setTimeToLive(2);
	        socket.joinGroup(group);

	        byte[] buffer = new byte[1024];
	        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
	        socket.receive(packet);

	        System.out.println("Recebido: " + new String(packet.getData()).trim());
	        socket.leaveGroup(group);
	        socket.close();
	    
		return "\n\n***** ***** |_____| ***** *****";
	}
}