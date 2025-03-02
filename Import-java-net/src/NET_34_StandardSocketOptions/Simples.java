package NET_34_StandardSocketOptions;

import java.io.IOException;
import java.net.*;
import java.nio.channels.*;
import java.util.Set;
import java.nio.*;

import util.Linhas;

public class Simples {
	public String Simples_Run() throws Exception {

		Linhas linhas = new Linhas();
		String collec = "\n\t StandardSocketOptions – Define opções padrão de sockets. \n";
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
		Import_4t import_4t = new Import_4t();
		System.out.println(import_4t.run_Import_4t());

		linhas.run_Caracteres();
		Import_5t import_5t = new Import_5t();
		System.out.println(import_5t.run_Import_5t());
		return "_________________________________________";
	}
}

class Import_1 {
	public String run_Import_1() throws Exception {
		System.err.println("1: Configurando o tempo de espera (SO_TIMEOUT)\n");

		SocketChannel socketChannel = SocketChannel.open();
		socketChannel.configureBlocking(false);
		socketChannel.connect(new InetSocketAddress("example.com", 80));

		// Define o tempo de espera de 10 segundos
		socketChannel.setOption(StandardSocketOptions.SO_RCVBUF, 1024);

		System.out.println("Opções configuradas: " + socketChannel.getLocalAddress());

		return "\n\n***** *****|_____| ***** *****";
	}
}

class Import_2 {
	public String run_Import_2() throws Exception {
		System.err.println("2: Configurando o buffer de recepção\n");

		SocketChannel socketChannel = SocketChannel.open();
		socketChannel.configureBlocking(false);

		// Define o buffer de recepção (SO_RCVBUF)
		socketChannel.setOption(StandardSocketOptions.SO_RCVBUF, 2048);

		System.out.println("Buffer de recepção configurado.");

		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_3 extends Thread {

	private ServerSocket serverSocket;

	public void SocketTest() throws IOException {
		serverSocket = new ServerSocket(8008);
		serverSocket.setSoTimeout(10000);

		System.out.println(serverSocket + "\n");
	}

	public void run() {
		while (true) {
			try {
				System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
				Socket client = serverSocket.accept();

				System.out.println("Just connected to " + client.getRemoteSocketAddress());
				client.close();
			} catch (SocketTimeoutException s) {
				System.out.println("Socket timed out!");
				break;
			} catch (IOException e) {
				e.printStackTrace();
				break;
			}
		}
	}

	public String run_Import_3() throws Exception {
		System.err.println("3. Este exemplo deixou tudo claro para mim:\n");

		Thread t = new Thread();
		t.start();
		t.run();
		SocketTest();

		System.out.println(t);

		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_4t {
	public String run_Import_4t() {
		System.err.println("4. Verificar as Opções de Socket Atuais\n");

		try (SocketChannel socketChannel = SocketChannel.open()) {
			Set<SocketOption<?>> supportedOptions = socketChannel.supportedOptions(); // Obtendo opções suportadas

			System.out.println("Opções suportadas pelo socket:");
			for (SocketOption<?> option : supportedOptions) {
				System.out.println(option.name());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_5t {
	public String run_Import_5t() {
		System.err.println("5. Habilitar o Reuso de Endereço de Socket (SO_REUSEADDR)\n");
		
        try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()) {
            serverSocketChannel.setOption(StandardSocketOptions.SO_REUSEADDR, true); // Habilitando reuso de endereço

            System.out.println("Opção SO_REUSEADDR habilitada.");
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		return "\n\n***** ***** |_____| ***** *****";
	}
}