package NET_10_SocketAddress;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

import util.Linhas;

public class Simples {
	public String Simples_Run() throws Exception {

		Linhas linhas = new Linhas();
		String collec = "\n\t SocketAddress – Classe abstrata que representa um endereço de socket. \n";
		System.err.println(collec);
		
		linhas.run_Caracteres();
		Import_1 import_1 = new Import_1();
		System.out.println(import_1.run_Import_1());
		
		linhas.run_Caracteres();
		Import_2 import_2 = new Import_2();
		System.out.println(import_2.run_Import_2());
		
		linhas.run_Caracteres();
		Import_3 import_3 = new Import_3();
		System.out.println(import_3.run_Import_3());
		
		linhas.run_Caracteres();
		Import_2t import_2t = new Import_2t();
		System.out.println(import_2t.run_Import_2t());
		
		linhas.run_Caracteres();
		Import_3t import_3t = new Import_3t();
		System.out.println(import_3t.run_Import_3t());
		
		linhas.run_Caracteres();
		Import_4t import_4t = new Import_4t();
		System.out.println(import_4t.run_Import_4t());
		return "_________________________________________";		
	}
}

class Import_1{
	public String run_Import_1() {
		System.err.println("1. Criar um InetSocketAddress (Endereço de Socket)\n");
		
	     InetSocketAddress address = new InetSocketAddress("localhost", 8080);
	        System.out.println("Endereço: " + address.getAddress());
	        System.out.println("Porta: " + address.getPort());
		return "\n\n***** ***** |_____| ***** *****";		
	}
}

class Import_2{
	public String run_Import_2() {
		System.err.println("2. Criar um Servidor com ServerSocket e SocketAddress\n");
		
        try (ServerSocket serverSocket = new ServerSocket()) {
            serverSocket.bind(new InetSocketAddress("localhost", 8080));
            System.out.println("Servidor aguardando conexões...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Cliente conectado: " + clientSocket.getRemoteSocketAddress());

        } catch (IOException e) {
            e.printStackTrace();
        }
		return "\n\n***** ***** |_____| ***** *****";	
	}
}

class Import_3{
	public String run_Import_3() throws Exception {
		System.err.println("3. Criar DatagramSocket e enviar um pacote UDP usando SocketAddress\n");
		
        DatagramSocket socket = new DatagramSocket();
        String message = "Hello UDP!";
        byte[] buffer = message.getBytes(StandardCharsets.UTF_8);
        InetSocketAddress address = new InetSocketAddress("localhost", 9876);
        
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address);
        socket.send(packet);
        
        System.out.println("Mensagem UDP enviada para " + address);
        socket.close();
		return "\n\n***** ***** |_____| ***** *****";	
	}
}

class Import_2t{
	public String run_Import_2t() {
		System.err.println("4. Obter Informações de um Socket Conectado\n");
		
        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress("example.com", 80));
            InetSocketAddress remoteAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
            System.out.println("Conectado a: " + remoteAddress.getHostName() + " na porta " + remoteAddress.getPort());
        } catch (IOException e) {
            e.printStackTrace();
        }
		return "\n\n***** ***** |_____| ***** *****";	
	}
}

class Import_3t{
	public String run_Import_3t() {
		System.err.println("5. Verificar se um Endereço e Porta estão Disponíveis\n");
		
        String host = "localhost";
        int port = 8082;
        
        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress(host, port), 2000);
            System.out.println("Porta " + port + " está aberta.");
        } catch (Exception e) {
            System.out.println("Porta " + port + " está fechada ou inacessível.");
        }
		return "\n\n***** ***** |_____| ***** *****";	
	}
}

class Import_4t{
	public String run_Import_4t() {
		System.err.println("6. Obter Endereço de um Nome de Domínio\n");
		
		InetSocketAddress address = new InetSocketAddress("google.com", 80);
        System.out.println("Endereço resolvido: " + address);
		return "\n\n***** ***** |_____| ***** *****";	
	}
}