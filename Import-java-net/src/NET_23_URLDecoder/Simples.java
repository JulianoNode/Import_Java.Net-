package NET_23_URLDecoder;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import util.Linhas;

public class Simples {
	public String Simples_Run() {

		Linhas linhas = new Linhas();
		String collec = "\n\tURLDecoder – Decodifica strings codificadas em URLs. \n";
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
		
		linhas.run_Caracteres();
		Import_6t import_6t = new Import_6t();
		System.out.println(import_6t.run_Import_6t());
		
		linhas.run_Caracteres();
		Import_7t import_7t = new Import_7t();
		System.out.println(import_7t.run_Import_7t());
		return "_________________________________________";
	}
}

class Import_1 {
	public String run_Import_1() {
		System.err.println("1. Decodificar uma URL simples: \n");

		String encodedUrl = "Hello%20World%21";
		String decodedUrl = URLDecoder.decode(encodedUrl, StandardCharsets.UTF_8);
		System.out.println("Decodificado: " + decodedUrl);

		return "\n\n***** *****|_____| ***** *****";
	}
}

class Import_2 {
	public String run_Import_2() {
		System.err.println("2. Decodificar uma URL com caracteres especiais: \n");

		String encoded = "C%C3%A3o%20e%20gato";
		String decoded = URLDecoder.decode(encoded, StandardCharsets.UTF_8);
		System.out.println(decoded); // Cão e gato

		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_3 {
	public String run_Import_3() {
		System.err.println("3. Decodificar uma query string de URL: \n");

		String query = "name=Jo%C3%A3o&age=25";
		String decodedQuery = URLDecoder.decode(query, StandardCharsets.UTF_8);
		System.out.println(decodedQuery); // name=João&age=25

		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_4t {
	public String run_Import_4t() {
		System.err.println("4. Decodificar múltiplos parâmetros de uma URL: \n");

		String encodedParams = "nome=Ana%20Maria&cidade=S%C3%A3o%20Paulo&pais=Brasil";
		String decodedParams = URLDecoder.decode(encodedParams, StandardCharsets.UTF_8);
		Arrays.stream(decodedParams.split("&")).forEach(System.out::println);

		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_5t {
	public String run_Import_5t() {
		System.err.println("5. Decodificar uma URL com espaços e símbolos: \n");

		String encoded = "10%25%20de%20desconto%20em%20compras%20online";
		String decoded = URLDecoder.decode(encoded, StandardCharsets.UTF_8);
		System.out.println(decoded); // 10% de desconto em compras online

		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_6t {
	public String run_Import_6t() {
		System.err.println("6. Tratar erros ao decodificar: \n");

		try {
			String encoded = "Teste%20inv%C3%A1lido";
			String decoded = URLDecoder.decode(encoded, StandardCharsets.UTF_8);
			System.out.println(decoded);
		} catch (Exception e) {
			System.out.println("Erro ao decodificar: " + e.getMessage());
		}

		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_7t {
	public String run_Import_7t() {
		System.err.println("7. Decodificar uma URL completa: \n");
		
        String encodedUrl = "https%3A%2F%2Fwww.exemplo.com%2Fsearch%3Fq%3DJava%20URLDecoder";
        String decodedUrl = URLDecoder.decode(encodedUrl, StandardCharsets.UTF_8);
        System.out.println(decodedUrl); // https://www.exemplo.com/search?q=Java URLDecoder
		
		return "\n\n***** ***** |_____| ***** *****";
	}
}