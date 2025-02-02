package NET_17_CookieHandler;

import util.Linhas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class Simples {
	public String Simples_Run() throws IOException {

		Linhas linhas = new Linhas();
		String collec = "\n\t CookieHandler – Classe abstrata para manipulação de cookies. \n";
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
		System.err.println("1. Configura um CookieManager como manipulador global de cookies.\r\n"
				+ "2. Faz uma requisição HTTP GET para um site de exemplo.\r\n"
				+ "3. Lê e imprime a resposta do servidor.\r\n"
				+ "4. Exibe os cookies armazenados pelo CookieManager.\n");

		try {
			// Configurar um gerenciador de cookies global
			CookieManager cookieManager = new CookieManager();
			CookieHandler.setDefault(cookieManager);

			// Criar uma URL para fazer a requisição
			@SuppressWarnings("deprecation")
			URL url = new URL("https://www.example.com");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			// Ler a resposta do servidor
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			reader.close();

			// Exibir os cookies armazenados
			System.out.println("Cookies armazenados:");
			CookieStore cookieStore = cookieManager.getCookieStore();
			for (HttpCookie cookie : cookieStore.getCookies()) {
				System.out.println(cookie);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "\n\n***** *****|_____| ***** *****";
	}
}

class Import_2 {
	public String run_Import_2() {
		System.err.println(
				"Aqui está um exemplo simples de código em Java que usa "
				+ "java.net.CookieHandler para gerenciar cookies em requisições HTTP.\n");

		try {
			// Configurar o gerenciador de cookies global
			CookieManager cookieManager = new CookieManager();
			CookieHandler.setDefault(cookieManager);

			// Criar uma URL e abrir conexão
			@SuppressWarnings("deprecation")
			URL url = new URL("https://www.example.com");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setDoOutput(true);

			// Ler a resposta do servidor
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuilder response = new StringBuilder();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// Exibir resposta
			System.out.println("Resposta do Servidor: " + response.toString());

			// Exibir cookies armazenados
			System.out.println("Cookies armazenados: " + cookieManager.getCookieStore().getCookies());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_3 {
	public String run_Import_3() throws IOException {
		System.err.println("Utilizar Cookies em uma Segunda Requisição.\n");

		CookieManager manager = new CookieManager();
		CookieHandler.setDefault(manager);

		@SuppressWarnings("deprecation")
		URL url1 = new URL("https://www.google.com");
		HttpURLConnection conn1 = (HttpURLConnection) url1.openConnection();
		conn1.setRequestMethod("GET");

		System.out.println("Primeira requisição: " + conn1.getResponseCode());

		// Segunda requisição para verificar se o cookie foi armazenado
		@SuppressWarnings("deprecation")
		URL url2 = new URL("https://www.google.com");
		HttpURLConnection conn2 = (HttpURLConnection) url2.openConnection();
		conn2.setRequestMethod("GET");

		System.out.println("Segunda requisição: " + conn2.getResponseCode());

		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_4t {
	public String run_Import_4t() throws IOException {
		System.err.println("Enviar Requisição HTTP e Capturar Cookies\n");

		CookieManager manager = new CookieManager();
		CookieHandler.setDefault(manager);

		@SuppressWarnings("deprecation")
		URL url = new URL("https://www.google.com");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		conn.setRequestMethod("GET");

		System.out.println("Resposta: " + conn.getResponseCode());
		System.out.println("Cookies Recebidos: " + conn.getHeaderField("Set-Cookie"));

		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_5t {
	public String run_Import_5t() {
		System.err.println("Obter o CookieHandler Atual.\n");

		CookieHandler handler = CookieHandler.getDefault();
		if (handler != null) {
			System.out.println("CookieHandler atual: " + handler.getClass().getName());
		} else {
			System.out.println("Nenhum CookieHandler foi definido.");
		}

		return "\n\n***** ***** |_____| ***** *****";
	}
}