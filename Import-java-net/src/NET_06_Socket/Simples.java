package NET_06_Socket;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import util.Linhas;

public class Simples {
	public String Simples_Run() throws Exception {

		Linhas linhas = new Linhas();
		String collec = "\n\t Socket – Representa um socket do cliente para comunicação com um servidor. \n";
		System.err.println(collec);
		
		linhas.run_Caracteres();
		Import_1 import_1 = new Import_1();
		System.out.println(import_1.run_Import_1());
		
		//linhas.run_Caracteres();
		//Import_2 import_2 = new Import_2();
		//System.out.println(import_2.run_Import_2());
		
		//linhas.run_Caracteres();
		//Import_3 import_3 = new Import_3();
		//System.out.println(import_3.run_Import_3());
		
		//linhas.run_Caracteres();
		//Import_4Y import_4Y = new Import_4Y();
		//System.out.println(import_4Y.run_Import_4Y());
		
		linhas.run_Caracteres();
		Import_5T import_5T = new Import_5T();
		System.out.println(import_5T.run_Import_5T());
		return "_________________________________________";		
	}
}

class Import_1{
	public String run_Import_1() throws Exception {
		System.err.println("1. Cliente UDP\n");
		
        DatagramSocket socket = new DatagramSocket();
        InetAddress endereco = InetAddress.getByName("localhost");

        String mensagem = "Olá, servidor UDP!";
        byte[] buffer = mensagem.getBytes();

        DatagramPacket pacote = new DatagramPacket(buffer, buffer.length, endereco, 8084);
        socket.send(pacote);
        System.out.println("Mensagem enviada.");

        socket.close();
		return "\n\n***** ***** |_____| ***** *****";		
	}
}

class Import_2{
	public String run_Import_2() throws IOException {
		System.err.println("2. Servidor UDP e Cliente\n"
				+ "Servidor UDP\n");
        DatagramSocket socket = new DatagramSocket(8083);
        byte[] buffer = new byte[1024];

        DatagramPacket pacoteRecebido = new DatagramPacket(buffer, buffer.length);
        System.out.println("Servidor aguardando mensagens...");
        socket.receive(pacoteRecebido);

        String mensagem = new String(pacoteRecebido.getData(), 0, pacoteRecebido.getLength());
        System.out.println("Recebido: " + mensagem);

        socket.close();
    
		return "\n\n***** ***** |_____| ***** *****";	
	}
}

class Import_3{
	public String run_Import_3() throws IOException{
		System.err.println("3. Cliente de Arquivos\n");
		
        Socket socket = new Socket("localhost", 8081);
        InputStream is = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream("arquivo_recebido.txt");

        byte[] buffer = new byte[4096];
        int bytesRead;
        while ((bytesRead = is.read(buffer)) != -1) {
            fos.write(buffer, 0, bytesRead);
        }

        fos.close();
        is.close();
        socket.close();
        System.out.println("Arquivo recebido!");
    
		return "\n\n***** ***** |_____| ***** *****";	
	}
}

class Import_4Y{
	public String run_Import_4Y() throws IOException {
		System.err.println("4. Envio de Arquivo via Socket\r\n"
				+ "Servidor de Arquivos\n");
		
        ServerSocket serverSocket = new ServerSocket(8082);
        System.out.println("Aguardando conexão...");

        Socket socket = serverSocket.accept();
        System.out.println("Cliente conectado!");

        File file = new File("arquivo.txt");
        FileInputStream fis = new FileInputStream(file);
        OutputStream os = socket.getOutputStream();

        byte[] buffer = new byte[4096];
        int bytesRead;
        while ((bytesRead = fis.read(buffer)) != -1) {
            os.write(buffer, 0, bytesRead);
        }

        fis.close();
        os.close();
        socket.close();
        serverSocket.close();
		return "\n\n***** ***** |_____| ***** *****";	
	}
}

class Import_5T{
	public String run_Import_5T() throws IOException {
		System.err.println("\n");
		
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Servidor aguardando conexão...");

        Socket socket = serverSocket.accept();
        System.out.println("Cliente conectado!");

        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

        String mensagem = input.readLine();
        System.out.println("Cliente: " + mensagem);
        output.println("Mensagem recebida: " + mensagem);

        socket.close();
        serverSocket.close();
		return "\n\n***** ***** |_____| ***** *****";	
	}
}