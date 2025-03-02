package NET_30_CookiePolicy;

import util.Linhas;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Simples {
	public String Simples_Run() {

		Linhas linhas = new Linhas();
		String collec = "\n\t CookiePolicy – Define políticas para aceitação de cookies. \n";
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
		System.err.println("\n");
		
        // Criando o CookieManager com a política ACCEPT_NONE
        CookieManager cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_NONE);

        // Criando o HttpClient com o CookieManager
        HttpClient client = HttpClient.newBuilder()
                .cookieHandler(cookieManager)
                .build();

        // Criando uma solicitação simples
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.example.com"))
                .build();

        // Enviando a solicitação e imprimindo a resposta
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Resposta: " + response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		return "\n\n***** *****|_____| ***** *****";
	}
}

class Import_2 implements CookiePolicy {

	@Override
	public boolean shouldAccept(URI uri, HttpCookie cookie) {
		return cookie.getName().equalsIgnoreCase("session"); // Aceita apenas cookies de sessão
	}

	public String run_Import_2() {
		System.err.println("2. Criando uma classe com política de cookies configurável\n");

		CookiePolicy policy = new Import_2();

		HttpCookie sessionCookie = new HttpCookie("session", "abc123");
		HttpCookie otherCookie = new HttpCookie("tracking", "xyz789");

		System.out.println(
				"Aceita cookie de sessão? " + policy.shouldAccept(URI.create("http://test.com"), sessionCookie));
		System.out.println(
				"Aceita cookie de rastreamento? " + policy.shouldAccept(URI.create("http://test.com"), otherCookie));

		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_3 {
	public String run_Import_3() {
		System.err.println("3. Aceitar todos os cookies\n");

		CookieManager manager = new CookieManager(null, CookiePolicy.ACCEPT_ALL);
		CookieHandler.setDefault(manager);
		System.out.println("Política de cookies: Rejeitar todos os cookies");

		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_4t {
	public String run_Import_4t() {
		System.err.println("4. Aceitar apenas cookies do mesmo domínio (DEFAULT)\n");

		CookieManager manager = new CookieManager(null, CookiePolicy.ACCEPT_ORIGINAL_SERVER);
		CookieHandler.setDefault(manager);
		System.out.println("Política de cookies: Aceitar apenas cookies do mesmo domínio");

		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_5t implements CookiePolicy {

	@Override
	public boolean shouldAccept(URI uri, HttpCookie cookie) {
		return uri.getHost().endsWith(".example.com"); // Aceita apenas cookies de example.com
	}

	public String run_Import_5t() {
		System.err.println("5. Criar uma política de cookies personalizada\n");

		CookieManager manager = new CookieManager(null, new Import_5t());
		CookieHandler.setDefault(manager);

		System.out.println("Política de cookies personalizada aplicada.");

		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Cookie1 {

	private String CookiePolicy;

	public String getCookiePolicy() {
		return CookiePolicy;
	}

	public void setCookiePolicy(String cookiePolicy) {
		CookiePolicy = cookiePolicy;
	}

}