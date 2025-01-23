package NET_InetSocketAddress;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

import util.Linhas;

public class Simples {
	public String Simples_Run() throws IOException {

		Linhas linhas = new Linhas();
		String collec = "\n\t Nome do comando \n";
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
		Import_4E import_4E = new Import_4E();
		System.out.println(import_4E.run_Import_4E());
		
		linhas.run_Caracteres();
		Import_5E import_5E = new Import_5E();
		System.out.println(import_5E.run_Import_5E());
		
		linhas.run_Caracteres();
		Import_6E import_6E = new Import_6E();
		System.out.println(import_6E.run_Import_6E());
		return "_________________________________________";		
	}
}

class Import_1{
	public String run_Import_1() {
		System.err.println("1. Criando um InetSocketAddress com IP e Porta\n");
		
        InetSocketAddress address = new InetSocketAddress("192.168.1.1", 8080);
        System.out.println("Endereço: " + address.getAddress());
        System.out.println("Porta: " + address.getPort());
		return "\n\n***** ***** |_____| ***** *****";		
	}
}

class Import_2{
	public String run_Import_2() {
		System.err.println("2. Criando um InetSocketAddress com Hostname\n");
		
        InetSocketAddress address = new InetSocketAddress("google.com", 80);
        System.out.println("Hostname: " + address.getHostName());
        System.out.println("Porta: " + address.getPort());
		return "\n\n***** ***** |_____| ***** *****";	
	}
}

class Import_3{
	public String run_Import_3() {
		System.err.println("3. Criando um InetSocketAddress sem definir IP "
				+ "(usando qualquer interface de rede)\n");
		
        InetSocketAddress address = new InetSocketAddress(9090);
        System.out.println("Endereço: " + address.getAddress());
        System.out.println("Porta: " + address.getPort());
        return "\n\n***** ***** |_____| ***** *****";	
	}
}

class Import_4E{
	public String run_Import_4E() {
		System.err.println("4. Verificando se um endereço é resolvível\n");
		
        InetSocketAddress address = new InetSocketAddress("vesdas", 8080);
        System.out.println("Host: " + address.getHostName());
        System.out.println("Endereço: " + address.getAddress()); // Pode retornar null se não for resolvível
   
		return "\n\n***** ***** |_____| ***** *****";		
	}
}

class Import_5E{
	public String run_Import_5E() throws IOException {
		System.err.println("5. Usando InetSocketAddress em um Servidor Socket\n");
		
        ServerSocket server = new ServerSocket();
        InetSocketAddress address = new InetSocketAddress("localhost", 5050);
        server.bind(address);
        System.out.println("Servidor rodando em: " + server.getLocalSocketAddress());
        System.out.println("Servidor rodando em: " + server.getLocalPort());
		return "\n\n***** ***** |_____| ***** *****";	
	}
}

class Import_6E{
	public String run_Import_6E() {
		System.err.println("6. Usando InetSocketAddress em um Cliente Socket\n");
		
        try (Socket socket = new Socket()) {
            InetSocketAddress address = new InetSocketAddress("google.com", 80);
            socket.connect(address);
            System.out.println("Conectado a: " + socket.getRemoteSocketAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
		return "\n\n***** ***** |_____| ***** *****";	
	}
}