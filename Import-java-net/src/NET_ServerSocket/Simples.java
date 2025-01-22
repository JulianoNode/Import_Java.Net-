package NET_ServerSocket;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import util.Linhas;

public class Simples {
	public String Simples_Run() {

		Linhas linhas = new Linhas();
		String collec = "\n\t Nome do comando \n";
		System.err.println(collec);

		linhas.run_Caracteres();
		Import_1 import_1 = new Import_1();
		System.out.println(import_1.run_Import_1());

		linhas.run_Caracteres();
		Import_2 import_2 = new Import_2();
		System.out.println(import_2.run_Import_2());

		//linhas.run_Caracteres();
		//Import_3 import_3 = new Import_3();
		//System.out.println(import_3.run_Import_3());

		linhas.run_Caracteres();
		Import_2p import_2p = new Import_2p();
		System.out.println(import_2p.run_Import_2p());

		linhas.run_Caracteres();
		Import_3o import_3o = new Import_3o();
		System.out.println(import_3o.run_Import_3o());
		return "_________________________________________";
	}
}

class Import_1 {
	public String run_Import_1() {
		System.err.println("1. Servidor Simples\r\n" + "Este servidor aguarda conexões na porta 9001 e exibe "
				+ "uma mensagem quando um cliente se conecta.port=9001\n");
		try (ServerSocket serverSocket = new ServerSocket(9001)) {
			System.out.println("Servidor aguardando conexões na porta 9001...");
			Socket socket = serverSocket.accept();
			System.out.println("Cliente conectado: " + socket.getInetAddress());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "\n\n***** |_____| *****";
	}
}

class Import_2 {
	public String run_Import_2() {
		System.err.println("2. Servidor que Envia uma Mensagem\r\n"
				+ "Este servidor envia uma mensagem ao cliente assim que ele se conecta. port=9002\n");

		try (ServerSocket serverSocket = new ServerSocket(9002)) {
			System.out.println("Aguardando conexão...");
			Socket socket = serverSocket.accept();
			System.out.println("Cliente conectado.");

			OutputStream output = socket.getOutputStream();
			PrintWriter writer = new PrintWriter(output, true);
			writer.println("Bem-vindo ao servidor!");

			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "\n\n***** ***** |_____| *****s *****";
	}
}

class Import_3 {
	public String run_Import_3() {
		System.err.println("3. Servidor que Recebe Mensagem do Cliente\r\n"
				+ "Este servidor recebe e exibe mensagens enviadas pelo cliente. port=9003\n");

		try (ServerSocket serverSocket = new ServerSocket(9003)) {
			System.out.println("Servidor aguardando conexão...");
			Socket socket = serverSocket.accept();
			System.out.println("Cliente conectado.");

			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String mensagem = reader.readLine();
			System.out.println("Mensagem recebida: " + mensagem);

			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_2p {
	public String run_Import_2p() {
		System.err.println("4. Servidor de Arquivos\r\n" 
	+ "Recebe um arquivo do cliente e o salva localmente. port=9090\n");
		// http://localhost:9090
		try (ServerSocket serverSocket = new ServerSocket(9090)) {
			System.out.println("Servidor aguardando arquivo...");
			System.err.println("Digite: http://localhost:9090");
			Socket socket = serverSocket.accept();
			System.out.println("Cliente conectado.");

			InputStream input = socket.getInputStream();
			FileOutputStream fileOutput = new FileOutputStream("arquivo_recebido.txt");

			// http://localhost:5000/arquivo_recebido.txt
			System.err.println("Enviando arquivo: http://localhost:9090/arquivo_recebido.txt");
			byte[] buffer = new byte[4096];
			int bytesRead;
			while ((bytesRead = input.read(buffer)) != -1) {
				fileOutput.write(buffer, 0, bytesRead);
			}

			System.out.println("Arquivo recebido com sucesso.");
			fileOutput.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_3o {
	public String run_Import_3o() {
		System.err.println("4. Servidor Multithread\r\n"
				+ "Permite múltiplos clientes simultâneos, "
				+ "criando uma nova thread para cada conexão. port=9091\n");
		
        try (ServerSocket serverSocket = new ServerSocket(9091)) {
            System.out.println("Servidor Echo rodando na porta 9091...");

            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(new EchoHandler(socket)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		return "\n\n***** ***** |_____| *****s *****";
	}
}

class EchoHandler implements Runnable {
    private Socket socket;

    public EchoHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true)
        ) {
            String mensagem;
            while ((mensagem = reader.readLine()) != null) {
                System.out.println("Recebido: " + mensagem);
                writer.println("Eco: " + mensagem);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}