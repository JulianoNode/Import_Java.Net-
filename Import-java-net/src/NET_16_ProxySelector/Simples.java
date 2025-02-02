package NET_16_ProxySelector;

import java.io.*;
import java.net.*;
import java.util.*;

import util.Linhas;

public class Simples {
	public String Simples_Run() throws IOException {

		Linhas linhas = new Linhas();
		String collec = "\n\t ProxySelector – Seletor que determina qual proxy deve ser usado para conexões. \n";
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
		//Import_4t import_4t = new Import_4t();
		//System.out.println(import_4t.run_Import_4t());

		//linhas.run_Caracteres();
		//Import_5t import_5t = new Import_5t();
		//System.out.println(import_5t.run_Import_5t());
		
		linhas.run_Caracteres();
		Import_6t import_6t = new Import_6t();
		System.out.println(import_6t.run_Import_6t());
		return "_________________________________________";
	}
}

class Import_1 {
	public String run_Import_1() throws IOException {
		System.err.println("Aqui está um exemplo simples de como usar o ProxySelector em Java para configurar uma "
				+ "autenticação com proxy:\n");

		// Definindo as configurações do proxy
		String proxyHost = "proxy.example.com";
		int proxyPort = 8080;
		String username = "user";
		String password = "password";

		// Configurando o ProxySelector
		ProxySelector.setDefault(new ProxySelector() {
			@Override
			public java.util.List<Proxy> select(URI uri) {
				// Configura o proxy para a URL de destino
				Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort));
				return java.util.Collections.singletonList(proxy);
			}

			@Override
			public void connectFailed(URI uri, SocketAddress sa, IOException ioe) {
				System.out.println("Falha na conexão com o proxy: " + ioe.getMessage());
			}
		});

		// URL de exemplo
		String url = "http://example.com";

		// Conectando-se com autenticação via proxy
		@SuppressWarnings("deprecation")
		URLConnection connection = new URL(url).openConnection();
		connection.setDoOutput(true);

		// Adicionando as credenciais de autenticação ao cabeçalho
		String auth = "Basic " + new String(Base64.getEncoder().encode((username + ":" + password).getBytes()));
		connection.setRequestProperty("Authorization", auth);

		// Enviando a requisição
		try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
			String inputLine;
			StringBuilder content = new StringBuilder();

			while ((inputLine = in.readLine()) != null) {
				content.append(inputLine);
			}

			// Exibe o conteúdo da resposta
			System.out.println(content.toString());
		} catch (IOException e) {
			System.out.println("Erro ao acessar a URL: " + e.getMessage());
		}
		return "\n\n***** *****|_____| ***** *****";
	}
}

class Import_2 {
	public String run_Import_2() throws IOException {
		System.err.println("Proxy com Autenticação e Customização\r\n"
				+ "Este exemplo configura o ProxySelector e adiciona uma autenticação básica.\n");
		ProxySelector.setDefault(new ProxySelector() {
			@Override
			public List<Proxy> select(URI uri) {
				return List.of(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy.example.com", 8080)));
			}

			@Override
			public void connectFailed(URI uri, SocketAddress sa, IOException ioe) {
				System.out.println("Failed to connect to proxy");
			}
		});

		@SuppressWarnings("deprecation")
		URL url = new URL("http://www.example.com");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		String encoded = new String(Base64.getEncoder().encode("username:password".getBytes()));
		connection.setRequestProperty("Proxy-Authorization", "Basic " + encoded);
		connection.setRequestMethod("GET");
		connection.connect();
		System.out.println("Response Code: " + connection.getResponseCode());

		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_3 {
	public String run_Import_3() throws IOException {
		System.err.println(" Proxy com Autenticação Digest\r\n"
				+ "Este exemplo usa uma autenticação digest para comunicação com o servidor proxy.\n");
		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy.example.com", 8080));
		@SuppressWarnings("deprecation")
		URL url = new URL("http://www.example.com");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection(proxy);
		connection.setRequestMethod("GET");
		// Este exemplo não inclui a lógica de autenticação Digest, que normalmente
		// envolve um processo mais complexo.
		connection.connect();
		System.out.println("Response Code: " + connection.getResponseCode());

		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_4t {
	public String run_Import_4t() throws IOException {
		System.err.println("Configuração de Proxy em Rede Local com Autenticação\r\n"
				+ "Aqui, configuramos um proxy para redes locais com autenticação.\n");

		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("192.168.1.1", 8080));
		@SuppressWarnings("deprecation")
		URL url = new URL("http://www.example.com");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection(proxy);
		String encoded = new String(Base64.getEncoder().encode("user:password".getBytes()));
		connection.setRequestProperty("Proxy-Authorization", "Basic " + encoded);
		connection.setRequestMethod("GET");
		connection.connect();
		System.out.println("Response Code: " + connection.getResponseCode());
		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_5t {
	public String run_Import_5t() throws IOException {
		System.err.println("Este exemplo configura um proxy com autenticação e timeout para a conexão.\n");

		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy.example.com", 8080));
		@SuppressWarnings("deprecation")
		URL url = new URL("http://www.example.com");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection(proxy);
		connection.setConnectTimeout(5000); // 5 segundos de timeout
		connection.setReadTimeout(5000);
		String encoded = new String(Base64.getEncoder().encode("username:password".getBytes()));
		connection.setRequestProperty("Proxy-Authorization", "Basic " + encoded);
		connection.setRequestMethod("GET");
		connection.connect();
		System.out.println("Response Code: " + connection.getResponseCode());
		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_6t {
	public String run_Import_6t() throws IOException {
		System.err.println("Este exemplo configura um proxy com autenticação e timeout para a conexão.\n");

		   try {
	            // Definindo um ProxySelector personalizado
	            ProxySelector.setDefault(new ProxySelector() {
	                @Override
	                public java.util.List<Proxy> select(URI uri) {
	                    // Definindo um proxy HTTP (altere o IP e a porta conforme necessário)
	                    Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 8080));
	                    return java.util.Collections.singletonList(proxy);
	                }

	                @Override
	                public void connectFailed(URI uri, SocketAddress sa, IOException ioe) {
	                    System.out.println("Falha ao conectar ao proxy: " + ioe.getMessage());
	                    System.out.println("Tente novamente mais tarde!");
	                }
	            });

	            // Criando uma URL de teste
	            @SuppressWarnings("deprecation")
				URL url = new URL("http://www.google.com");
	            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	            
	            // Configurando a requisição
	            conn.setRequestMethod("GET");

	            // Lendo a resposta
	            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	            String line;
	            while ((line = reader.readLine()) != null) {
	                System.out.println(line);
	            }
	            reader.close();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		return "\n\n***** ***** |_____| ***** *****";
	}
}