package NET_18_CookieManager;

import util.Linhas;

import java.io.*;
import java.net.*;
import java.util.List;

public class Simples {
	public String Simples_Run() throws Exception {

		Linhas linhas = new Linhas();
		String collec = "\n\t CookieManager – Implementação padrão de CookieHandler. \n";
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
		System.err.println("1.Gerenciando cookies com CookieHandler\n");

		try {
			// Configurar um gerenciador de cookies global
			CookieManager cookieManager = new CookieManager();
			CookieHandler.setDefault(cookieManager);

			// Fazer uma requisição HTTP para um site que usa cookies
			String urlString = "https://www.example.com"; // Substitua por um site real
			@SuppressWarnings("deprecation")
			URL url = new URL(urlString);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			// Definir método da requisição
			connection.setRequestMethod("GET");

			// Ler a resposta
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String inputLine;
			StringBuilder response = new StringBuilder();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// Exibir a resposta
			System.out.println("Resposta do servidor:");
			System.out.println(response.length());
			System.out.println(response.indexOf(urlString));
			System.out.println(response.substring(1));

			// Exibir os cookies armazenados
			System.out.println("Cookies armazenados: " + cookieManager.getCookieStore().getCookies());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "\n\n***** *****|_____| ***** *****";
	}
}

class Import_2 {
	public String run_Import_2() {
		System.err.println("2. Recuperar o CookieHandler Padrão\n");
		
        CookieHandler handler = CookieHandler.getDefault();
        if (handler != null) {
            System.out.println("CookieHandler padrão recuperado: " + handler.getClass().getName());
        } else {
            System.out.println("Nenhum CookieHandler padrão definido.");
        }
		
		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_3 {
	public String run_Import_3() throws Exception {
		System.err.println("3. Adicionar Cookies Manualmente a um CookieManager\n");
		
        CookieManager cookieManager = new CookieManager();
        CookieHandler.setDefault(cookieManager);

        URI uri = new URI("http://exemplo.com");
        HttpCookie cookie = new HttpCookie("usuario", "Joao");
        cookie.setPath("/");
        cookie.setMaxAge(3600);

        cookieManager.getCookieStore().add(uri, cookie);

        System.out.println("Cookie adicionado: " + cookie);
        System.out.println("Cookie Nome: " + cookie.getName());
		
		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_4t {
	public String run_Import_4t() {
		System.err.println("4. Listar Todos os Cookies Armazenados\n");

		CookieManager cookieManager = new CookieManager();
		CookieHandler.setDefault(cookieManager);

		List<HttpCookie> cookies = cookieManager.getCookieStore().getCookies();

		if (cookies.isEmpty()) {
			System.out.println("Nenhum cookie armazenado.");
		} else {
			for (HttpCookie cookie : cookies) {
				System.out.println("Cookie: " + cookie);
			}
		}

		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_5t {
	public String run_Import_5t() throws Exception {
		System.err.println("5. Remover um Cookie Específico\n");

		CookieManager cookieManager = new CookieManager();
		CookieHandler.setDefault(cookieManager);

		URI uri = new URI("http://exemplo.com");
		HttpCookie cookie = new HttpCookie("usuario", "Joao");
		cookieManager.getCookieStore().add(uri, cookie);

		System.out.println("Antes da remoção: " + cookieManager.getCookieStore().getCookies());

		// Removendo o cookie
		cookieManager.getCookieStore().remove(uri, cookie);
		System.out.println("Após a remoção: " + cookieManager.getCookieStore().getCookies());

		return "\n\n***** ***** |_____| ***** *****";
	}
}