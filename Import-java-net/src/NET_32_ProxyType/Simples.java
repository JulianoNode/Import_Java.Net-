package NET_32_ProxyType;

import util.Linhas;
import java.net.*;

public class Simples {
	public String Simples_Run() throws Exception {

		Linhas linhas = new Linhas();
		String collec = "\n\t Proxy.Type – Define os tipos de proxy (DIRECT, HTTP, SOCKS). \n";
		System.err.println(collec);

		linhas.run_Caracteres();
		//Import_1 import_1 = new Import_1();
		//System.out.println(import_1.run_Import_1());

		linhas.run_Caracteres();
		//Import_2 import_2 = new Import_2();
		//System.out.println(import_2.run_Import_2());

		linhas.run_Caracteres();
		//Import_3 import_3 = new Import_3();
		//System.out.println(import_3.run_Import_3());

		linhas.run_Caracteres();
		//Import_4t import_4t = new Import_4t();
		//System.out.println(import_4t.run_Import_4t());

		linhas.run_Caracteres();
		//Import_5t import_5t = new Import_5t();
		//System.out.println(import_5t.run_Import_5t());
		return "_________________________________________";
	}
}

class Import_1 {
	@SuppressWarnings("deprecation")
	public String run_Import_1() throws Exception {
		System.err.println("\n");

		String proxyHost = "proxy.example.com";
		int proxyPort = 8080;

		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort));
		URL url = new URL("http://www.example.com");
		URLConnection connection = url.openConnection(proxy);
		connection.connect();
		System.out.println("Conexão estabelecida usando HTTP Proxy");
		return "\n\n***** *****|_____| ***** *****";
	}
}

class Import_2 {
	public String run_Import_2() throws Exception {
		System.err.println("\n");

		String proxyHost = "proxy.example.com";
		int proxyPort = 1080;

		Proxy proxy = new Proxy(Proxy.Type.SOCKS, new InetSocketAddress(proxyHost, proxyPort));
		@SuppressWarnings("deprecation")
		URL url = new URL("http://www.example.com");
		URLConnection connection = url.openConnection(proxy);
		connection.connect();
		System.out.println("Conexão estabelecida usando SOCKS Proxy");

		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_3 {
	public String run_Import_3() throws Exception {
		System.err.println("\n");

		String proxyHost = "proxy.example.com";
		int proxyPort = 8080;

		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort));
		@SuppressWarnings("deprecation")
		URL url = new URL("http://www.example.com");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection(proxy);
		connection.connect();
		System.out.println("Conexão com HTTP usando Proxy estabelecida.");

		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_4t {
	@SuppressWarnings("resource")
	public String run_Import_4t() throws Exception {
		System.err.println("\n");

		String proxyHost = "proxy.example.com";
		int proxyPort = 8080;

		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort));
		
		Socket socket = new Socket(proxy);
		socket.connect(new InetSocketAddress("www.example.com", 80));
		System.out.println("Conexão de Socket usando Proxy HTTP estabelecida.");

		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_5t {
	public String run_Import_5t() throws Exception {
		System.err.println("\n");

		String proxyHost = "proxy.example.com";
		int proxyPort = 8080;

		// Definir o proxy globalmente para todas as conexões
		System.setProperty("http.proxyHost", proxyHost);
		System.setProperty("http.proxyPort", String.valueOf(proxyPort));

		@SuppressWarnings("deprecation")
		URL url = new URL("http://www.example.com");
		URLConnection connection = url.openConnection();
		connection.connect();
		System.out.println("Conexão globalmente configurada com Proxy HTTP.");

		return "\n\n***** ***** |_____| ***** *****";
	}
}