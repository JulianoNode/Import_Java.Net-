package NET_04_HttpURLConnection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import util.Linhas;

public class Simples {
	public String Simples_Run() {

		Linhas linhas = new Linhas();
		String collec = "\n\t HttpURLConnection – Subclasse de URLConnection usada para conexões HTTP. \n";
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
		Import_4v import_4v = new Import_4v();
		System.out.println(import_4v.run_Import_4v());

		linhas.run_Caracteres();
		Import_5v import_5v = new Import_5v();
		System.out.println(import_5v.run_Import_5v());
		
		linhas.run_Caracteres();
		Import_6v import_6v = new Import_6v();
		System.out.println(import_6v.run_Import_6v());
		return "_________________________________________";
	}
}

class Import_1 {

	public String run_Import_1() {
		System.err.println("1. Requisição GET Simples\n");
		try {
			@SuppressWarnings("deprecation")
			URL url = new URL("https://jsonplaceholder.typicode.com/posts/1");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");

			int responseCode = con.getResponseCode();
			System.out.println("Response Code: " + responseCode);

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuilder response = new StringBuilder();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			System.out.println("Response: " + response.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "\n\n***** |_____| *****";
	}
}

class Import_2 {
	public String run_Import_2() {
		System.err.println("\n");

		try {
			@SuppressWarnings("deprecation")
			URL url = new URL("https://jsonplaceholder.typicode.com/posts/1");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("PUT");
			con.setRequestProperty("Content-Type", "application/json; utf-8");
			con.setDoOutput(true);

			String jsonInputString = "{\"id\": 1, \"title\": \"updated title\", \"body\": \"updated body\", \"userId\": 1}";
			try (OutputStream os = con.getOutputStream()) {
				byte[] input = jsonInputString.getBytes("utf-8");
				os.write(input, 0, input.length);
			}

			System.out.println("Response Code: " + con.getResponseCode());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_3 {
	public String run_Import_3() {
		System.err.println("3. Tratamento de Erros HTTP\n");

		try {
			@SuppressWarnings("deprecation")
			URL url = new URL("https://jsonplaceholder.typicode.com/posts/invalid");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");

			int responseCode = con.getResponseCode();
			if (responseCode >= 200 && responseCode < 300) {
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuilder response = new StringBuilder();
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();
				System.out.println("Response: " + response.toString());
			} else {
				System.out.println("Error: HTTP " + responseCode);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_4v {
	public String run_Import_4v() {
		System.err.println("4. Timeouts para Conexão e Leitura\n");

		try {
			@SuppressWarnings("deprecation")
			URL url = new URL("https://jsonplaceholder.typicode.com/posts/1");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setConnectTimeout(5000); // 5 segundos para conexão
			con.setReadTimeout(5000); // 5 segundos para leitura da resposta

			System.out.println("Response Code: " + con.getResponseCode());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_5v {
	public String run_Import_5v() {
		System.err.println("5. Definição de Headers Personalizados\n");

		try {
			@SuppressWarnings("deprecation")
			URL url = new URL("https://jsonplaceholder.typicode.com/posts/1");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", "Mozilla/5.0");
			con.setRequestProperty("Authorization", "Bearer token_exemplo");

			System.out.println("Response Code: " + con.getResponseCode());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_6v {
	public String run_Import_6v() {
		System.err.println("6. Requisição POST Simples\n");

		try {
			@SuppressWarnings("deprecation")
			URL url = new URL("https://jsonplaceholder.typicode.com/posts");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json; utf-8");
			con.setDoOutput(true);

			String jsonInputString = "{\"title\": \"foo\", \"body\": \"bar\", \"userId\": 1}";
			try (OutputStream os = con.getOutputStream()) {
				byte[] input = jsonInputString.getBytes("utf-8");
				os.write(input, 0, input.length);
			}

			System.out.println("Response Code: " + con.getResponseCode());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "\n\n***** ***** |_____| ***** *****";
	}
}
