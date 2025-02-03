package NET_19_CookieStore;

import util.Linhas;
import java.net.*;
import java.net.http.*;

public class Simples {
	public String Simples_Run() throws Exception {

		Linhas linhas = new Linhas();
		String collec = "\n\t CookieStore – Interface para armazenar cookies. \n";
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
		System.err.println("1. Aqui está um exemplo simples em Java usando java.net.CookieStore \n"
				+ "para armazenar e gerenciar cookies em conjunto com java.net.CookieManager:\n");
		// Criar um gerenciador de cookies
		CookieManager cookieManager = new CookieManager();
		CookieHandler.setDefault(cookieManager);
		CookieStore cookieStore = cookieManager.getCookieStore();

		// Criar um cookie
		HttpCookie cookie = new HttpCookie("usuario", "Joao");
		cookie.setDomain("example.com");
		cookie.setPath("/");
		cookie.setMaxAge(3600); // 1 hora

		// Adicionar cookie ao armazenamento
		try {
			URI uri = new URI("http://example.com");
			cookieStore.add(uri, cookie);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		// Listar cookies armazenados
		System.out.println("Cookies armazenados:");
		for (HttpCookie c : cookieStore.getCookies()) {
			System.out.println("Nome: " + c.getName() + ",\nValor: " + c.getValue());
		}

		return "\n\n***** *****|_____| ***** *****";
	}
}

class Import_2 {
	public String run_Import_2() throws URISyntaxException {
		System.err.println("2.  Adicionando um cookie manualmente\n");
		
        CookieStore cookieStore = new java.net.CookieManager().getCookieStore();
        URI uri = new URI("http://example.com");
        HttpCookie cookie = new HttpCookie("user", "john_doe");
        cookie.setDomain("example.com");
        cookieStore.add(uri, cookie);

        System.out.println("Cookies armazenados: " + cookieStore.getCookies());
		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_3 {
	public String run_Import_3() throws Exception{
		System.err.println("3. Usando CookieStore em HttpClient\n");

		CookieStore cookieStore = new java.net.CookieManager().getCookieStore();
		HttpClient client = HttpClient.newBuilder()
				.cookieHandler(new java.net.CookieManager(cookieStore, java.net.CookiePolicy.ACCEPT_ALL)).build();

		HttpRequest request = HttpRequest.newBuilder().uri(new URI("http://example.com")).build();

		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println("Response: " + response.body());
		System.out.println("Cookies armazenados: " + cookieStore.getCookies());

		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_4t {
	public String run_Import_4t() throws Exception {
		System.err.println("4. Definindo uma política de aceitação de cookies\n");

		CookieStore cookieStore = new java.net.CookieManager().getCookieStore();
		HttpClient client = HttpClient.newBuilder()
				.cookieHandler(new java.net.CookieManager(cookieStore, java.net.CookiePolicy.ACCEPT_ORIGINAL_SERVER))
				.build();

		HttpRequest request = HttpRequest.newBuilder().uri(new URI("http://example.com")).build();

		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println("Response: " + response.body());
		System.out.println("Cookies armazenados: " + cookieStore.getCookies());

		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_5t {
	public String run_Import_5t() throws Exception {
		System.err.println("5. Acessando cookies após a resposta de um servidor\n");

		CookieStore cookieStore = new java.net.CookieManager().getCookieStore();
		HttpClient client = HttpClient.newBuilder()
				.cookieHandler(new java.net.CookieManager(cookieStore, java.net.CookiePolicy.ACCEPT_ALL)).build();

		HttpRequest request = HttpRequest.newBuilder().uri(new URI("http://example.com")).build();

		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

		System.out.println("Response: " + response.body());
		System.out.println("Cookies armazenados após a resposta: " + cookieStore.getCookies());

		return "\n\n***** ***** |_____| ***** *****";
	}
}