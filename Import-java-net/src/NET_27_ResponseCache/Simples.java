package NET_27_ResponseCache;

import util.Linhas;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.*;
import java.util.List;
import java.util.Map;

public class Simples {
	public String Simples_Run() throws Exception {

		Linhas linhas = new Linhas();
		String collec = "\n\t ResponseCache – Classe abstrata para implementação de cache de respostas de rede. \n";
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
		System.err.println("1. Configurar um ResponseCache Customizado:\n");

		ResponseCache.setDefault(new CustomResponseCache());
		URL url = new URL("http://example.com");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.getResponseCode(); // Força a requisição

		System.out.println("Força a requisição:" + url);
		return "\n\n***** *****|_____| ***** *****";
	}
}

class Import_2 {
	public String run_Import_2() throws Exception {
		System.err.println("2. Verificando a Resposta do Cache:\n");

		ResponseCache.setDefault(new CustomResponseCache());
		URL url = new URL("http://example.com");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		int responseCode = connection.getResponseCode();

		if (responseCode == HttpURLConnection.HTTP_OK) {
			System.out.println("Resposta obtida com sucesso!");
		}

		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_3 {
	public String run_Import_3() throws Exception {
		System.err.println("3. Utilizando ResponseCache com Cabeçalhos HTTP:\n");

		ResponseCache.setDefault(new CustomResponseCache());

		URL url = new URL("http://example.com");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");

		// Configurar cabeçalhos de requisição
		connection.setRequestProperty("User-Agent", "Java");
		connection.getResponseCode(); // Realiza a requisição
		
		System.out.println( "Realiza a requisição:  " + url);

		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_4t {
	public String run_Import_4t() throws Exception {
		System.err.println("4. Usando o Cache com Várias Requisições\n");

		ResponseCache.setDefault(new CustomResponseCache());

		URL url1 = new URL("http://example1.com");
		URL url2 = new URL("http://example2.com");

		// Primeira requisição
		HttpURLConnection connection1 = (HttpURLConnection) url1.openConnection();
		connection1.getResponseCode();

		// Segunda requisição
		HttpURLConnection connection2 = (HttpURLConnection) url2.openConnection();
		connection2.getResponseCode();

		System.out.println("!Usando o Cache com Várias Requisições:");
		System.out.println(url1);
		System.out.println(url2);
		
		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_5t {
	public String run_Import_5t() throws Exception {
		System.err.println("5. Exemplo Simples de Cache com Custom CacheResponse\n");
		
        ResponseCache.setDefault(new SimpleResponseCache());
        URL url = new URL("http://example.com");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.getResponseCode(); // A resposta será armazenada no cache
        
        System.out.println("A resposta será armazenada no cache!");
		
		return "\n\n***** ***** |_____| ***** *****";
	}
}

// Classes adaptadas no pregeto acima ____________________________

class CustomResponseCache extends ResponseCache {
	@Override
	public CacheResponse get(URI uri, String requestMethod, Map<String, List<String>> requestHeaders)
			throws IOException {
		// Implementação do método para obter resposta do cache
		return null; // Retorne uma resposta do cache ou nulo se não houver no cache
	}

	@Override
	public CacheRequest put(URI uri, URLConnection conn) throws IOException {
		// Implementação do método para armazenar resposta no cache
		return null; // Retorne um objeto CacheRequest para armazenar no cache
	}
}






class SimpleResponseCache extends ResponseCache {
    @Override
    public CacheResponse get(URI uri, String requestMethod, Map<String, List<String>> requestHeaders) {
        // Retorna uma resposta do cache se disponível
        return null;
    }

    @Override
    public CacheRequest put(URI uri, URLConnection conn) {
        // Armazena a resposta no cache
        return new SimpleCacheRequest();
    }
}

class SimpleCacheRequest extends CacheRequest {
    @Override
    public OutputStream getBody() {
        return new ByteArrayOutputStream();
    }

    @Override
    public void abort() {
        // Lógica para abortar a escrita no cache
    }
}
