package NET_28_SecureCacheResponse;

import util.Linhas;

import java.io.IOException;
import java.io.InputStream;
import java.net.SecureCacheResponse;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLPeerUnverifiedException;

import java.net.CacheRequest;
import java.net.ResponseCache;
import java.net.URI;
import java.net.URLConnection;
import java.security.Principal;

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
		System.err.println(" 2: Simulando uma resposta segura personalizada (classe anônima) \n");

		SecureCacheResponse response = new SecureCacheResponse() {
			@Override
			public String getCipherSuite() {
				return "TLS_AES_128_GCM_SHA256";
			}

			@Override
			public List<java.security.cert.Certificate> getLocalCertificateChain() {
				return Collections.emptyList();
			}

			@Override
			public List<java.security.cert.Certificate> getServerCertificateChain() {
				return Collections.emptyList();
			}

			@Override
			public Map<String, List<String>> getHeaders() {
				return Collections.singletonMap("Content-Type", Collections.singletonList("text/html"));
			}

			@Override
			public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Principal getLocalPrincipal() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public InputStream getBody() throws IOException {
				// TODO Auto-generated method stub
				return null;
			}
		};

		try {
			System.out.println("Cipher Suite: " + response.getCipherSuite());
			System.out.println("Cabeçalhos: " + response.getHeaders());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_3 extends ResponseCache {

	@Override
	public SecureCacheResponse get(URI uri, String requestMethod, Map<String, List<String>> requestHeaders)
			throws IOException {
		System.out.println("Interceptando solicitação para URI: " + uri);
		return null; // Simula um cache vazio
	}

	@Override
	public CacheRequest put(URI uri, URLConnection conn) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	public String run_Import_3() {
		System.err.println("3: Criando um ResponseCache personalizado\n");
		
		ResponseCache.setDefault(new Import_3());
		System.out.println("Cache personalizado configurado.");

		return "\n\n***** ***** |_____| ***** *****";
	}

}
