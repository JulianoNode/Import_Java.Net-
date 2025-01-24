package NET_01_URL;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.URL;
import java.util.Scanner;

import util.Linhas;

public class Simples {
	public String Simples_Run() {

		Linhas linhas = new Linhas();
		String collec = "\n\t URL – Representa um endereço de recurso na web. \n";
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
		Import_4A import_4A = new Import_4A();
		System.out.println(import_4A.run_Import_4A());
		
		linhas.run_Caracteres();
		Import_5A import_5A = new Import_5A();
		System.out.println(import_5A.run_Import_5A());
		return "_________________________________________";
	}
}

class Import_1 {
 
	public String run_Import_1() {		
		System.err.println("Descrição: Este código acessa a URL informada e imprime seu conteúdo no console.\n");
		try {
			@SuppressWarnings("deprecation")
			URL url = new URL("https://www.example.com");
			Scanner scanner = new Scanner(url.openStream());

			while (scanner.hasNext()) {
				System.out.println(scanner.nextLine());
			}

			scanner.close();
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
		return "\n\n***** |_____| *****";
	}
}

class Import_2 {
	public String run_Import_2() {
		System.err.println("Descrição: Esse código decompõe uma URL em suas partes (protocolo, host, porta, caminho, query string e fragmento).\n");
		try {
			@SuppressWarnings("deprecation")
			URL url = new URL("https://www.exemplo.com:8080/caminho/recurso?parametro=valor#ancora");

			System.out.println("Protocolo: " + url.getProtocol());
			System.out.println("Host: " + url.getHost());
			System.out.println("Porta: " + url.getPort());
			System.out.println("Caminho: " + url.getPath());
			System.out.println("Query: " + url.getQuery());
			System.out.println("Fragmento: " + url.getRef());
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}

		return "\n\n***** ***** |_____| *****s *****";
	}
}

class Import_3 {
	public String run_Import_3() {

		System.err.println("Descrição: O programa tenta criar um objeto URL e imprime uma mensagem se a URL for válida ou inválida.\n");
		String endereco = "https://www.google.com";

		try {
			@SuppressWarnings("deprecation")
			URL url = new URL(endereco);
			System.out.println("A URL é válida: " + url.toString());
		} catch (Exception e) {
			System.out.println("URL inválida: " + endereco);
		}

		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_4A {
	public String run_Import_4A() {
		System.err.println("Descrição: Esse código baixa um arquivo (imagem, PDF, etc.) de uma URL e o salva no computador.\n");
		try {
			@SuppressWarnings("deprecation")
			URL url = new URL("https://www.example.com/imagem.jpg");
			InputStream inputStream = url.openStream();
			FileOutputStream outputStream = new FileOutputStream("imagem.jpg");

			byte[] buffer = new byte[2048];
			int bytesRead;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}

			inputStream.close();
			outputStream.close();
			System.out.println("Download concluído!");
		} catch (Exception e) {
			System.out.println("Erro ao baixar o arquivo: " + e.getMessage());
		}
		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_5A {
	public String run_Import_5A() {
		System.err.println("Descrição: O código extrai o endereço IP associado a um domínio usando a classe InetAddress.\n");
		try {
			@SuppressWarnings("deprecation")
			URL url = new URL("https://www.google.com");
			InetAddress endereco = InetAddress.getByName(url.getHost());
			System.out.println("Endereço IP Google: " + endereco.getHostAddress());
			
			@SuppressWarnings("deprecation")
			URL url1 = new URL("https://www.facebook.com");
			InetAddress endereco1 = InetAddress.getByName(url1.getHost());
			System.out.println("Endereço IP Facebook: " + endereco1.getHostAddress());
			
			@SuppressWarnings("deprecation")
			URL url2 = new URL("https://www.udemy.com/");
			InetAddress endereco2 = InetAddress.getByName(url2.getHost());
			System.out.println("Endereço IP Udemy: " + endereco2.getHostAddress());
		} catch (Exception e) {
			System.out.println("Erro ao obter IP: " + e.getMessage());
		}
		return "\n\n***** ***** |_____| ***** *****";
	}
}