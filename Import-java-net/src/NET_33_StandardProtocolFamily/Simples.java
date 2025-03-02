package NET_33_StandardProtocolFamily;

import util.Linhas;

import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.io.*;

public class Simples {
	public String Simples_Run() {

		Linhas linhas = new Linhas();
		String collec = "\n\t StandardProtocolFamily – Define famílias de protocolo (INET, INET6). \n";
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
	public String run_Import_1() {
		System.err.println("1. Usando StandardProtocolFamily para criar um Socket\n");

		try {
			DatagramChannel channel = DatagramChannel.open(StandardProtocolFamily.INET);
			System.out.println("Socket created using INET protocol family.");
			channel.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "\n\n***** *****|_____| ***** *****";
	}
}

class Import_2 {
	public String run_Import_2() {
		System.err.println("2.  Criando um Socket para IPv6 usando StandardProtocolFamily\n");
		try {
			DatagramChannel channel = DatagramChannel.open(StandardProtocolFamily.INET6);
			System.out.println("Socket created using INET6 protocol family.");
			channel.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_3 {
	public String run_Import_3() {
		System.err.println("3. Criando Socket com StandardProtocolFamily para comunicação UDP\n");

		try {
			DatagramChannel channel = DatagramChannel.open(StandardProtocolFamily.INET);
			channel.bind(new InetSocketAddress(9876));
			System.out.println("UDP socket bound to port 9876.");
			channel.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_4t {
	public String run_Import_4t() {
		System.err.println("4. Usando StandardProtocolFamily para criar um socket IPv4 e enviar dados\n");
		
        try {
            DatagramChannel channel = DatagramChannel.open(StandardProtocolFamily.INET);
            String message = "Hello, world!";
            byte[] buffer = message.getBytes();
            InetSocketAddress address = new InetSocketAddress("localhost", 12345);
            channel.send(ByteBuffer.wrap(buffer), address);
            System.out.println("Data sent to localhost:12345");
            channel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_5t {
	public String run_Import_5t() {
		System.err.println("5 Verificando a Disponibilidade de Protocólos\n");
		
        System.out.println("Available protocol families:");
        for (StandardProtocolFamily family : StandardProtocolFamily.values()) {
            System.out.println(family);
        }
		
		return "\n\n***** ***** |_____| ***** *****";
	}
}