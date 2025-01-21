package NET_URI;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

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

		linhas.run_Caracteres();
		Import_3 import_3 = new Import_3();
		System.out.println(import_3.run_Import_3());

		linhas.run_Caracteres();
		Import_4B import_4B = new Import_4B();
		System.out.println(import_4B.run_Import_4B());

		linhas.run_Caracteres();
		Import_5B import_5B = new Import_5B();
		System.out.println(import_5B.run_Import_5B());
		return "_________________________________________";
	}
}

class Import_1 {

	public String run_Import_1() {
		System.err.println("1. Criando uma URI e imprimindo os detalhes\n");
		try {
			URI uri = new URI("https://www.exemplo.com");
			System.out.println("Esquema: " + uri.getScheme());
			System.out.println("Host: " + uri.getHost());
			System.out.println("Caminho: " + uri.getPath());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return "\n\n***** |_____| *****";
	}
}

class Import_2 {
	public String run_Import_2() {
		System.err.println("2. Comparando duas URIs\n");
		try {
			URI uri1 = new URI("https://www.exemplo.com");
			URI uri2 = new URI("https://www.exemplo.com");

			if (uri1.equals(uri2)) {
				System.out.println("As URIs são iguais!");
			} else {
				System.out.println("As URIs são diferentes.");
			}
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return "\n\n***** ***** |_____| *****s *****";
	}
}

class Import_3 {
	public String run_Import_3() {
		System.err.println("3. Criando uma URI com parâmetros de consulta\n");
		try {
			URI uri = new URI("https://www.exemplo.com/pesquisa?nome=Joao&idade=25");
			System.out.println("URI: " + uri);
			System.out.println("Consulta: " + uri.getQuery());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_4B {
	public String run_Import_4B() {
		System.err.println("4. Convertendo uma URI para uma URL\n");
		try {
			URI uri = new URI("https://www.exemplo.com");
			URL url = uri.toURL();
			System.out.println("URL: " + url);
		} catch (URISyntaxException | IOException e) {
			e.printStackTrace();
		}
		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_5B {
	public String run_Import_5B() {
		System.err.println("5. Criando uma URI a partir de componentes\n");
		try {
			URI uri = new URI("https", "www.exemplo.com", "/path", "q=java", null);
			
			System.out.println("URI Completa: " + uri);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		return "\n\n***** ***** |_____| ***** *****";
	}
}