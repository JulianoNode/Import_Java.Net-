package NET_28_SecureCacheResponse;

import util.Linhas;

import java.net.ResponseCache;
import java.net.SecureCacheResponse;
import java.net.URI;
import java.util.Map;

public class Simples {
	public String Simples_Run() throws Exception {

		Linhas linhas = new Linhas();
		String collec = "\nSecureCacheResponse – Resposta em cache para conexões seguras (HTTPS). \n";
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
		System.err.println("1: Implementação personalizada de SecureCacheResponse: \n");

		try {
			// Criando um URI de exemplo (HTTPS)
			URI uri = new URI("https://example.com");

			// Obtendo a resposta do cache, se existir
			SecureCacheResponse secureResponse = (SecureCacheResponse) ResponseCache.getDefault().get(uri, "GET", null);

			if (secureResponse != null) {
				System.out.println("Resposta segura encontrada no cache!");
				Map<String, java.util.List<String>> headers = secureResponse.getHeaders();
				System.out.println("Cabeçalhos armazenados: " + headers);
			} else {
				System.out.println("Nenhuma resposta segura encontrada no cache.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "\n\n***** *****|_____| ***** *****";
	}

}

class Import_2 {
	public String run_Import_2() {
		System.err.println("\n");
		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_3 {
	public String run_Import_3() {
		System.err.println("\n");
		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_4t {
	public String run_Import_4t() {
		System.err.println("\n");
		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_5t {
	public String run_Import_5t() {
		System.err.println("\n");
		return "\n\n***** ***** |_____| ***** *****";
	}
}