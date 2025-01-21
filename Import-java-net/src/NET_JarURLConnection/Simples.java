package NET_JarURLConnection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import util.Linhas;

public class Simples {
	public String Simples_Run() {

		Linhas linhas = new Linhas();
		String collec = "\n\t Nome do comando \n";
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
		Import_4d import_4d = new Import_4d();
		System.out.println(import_4d.run_Import_4d());
		
		linhas.run_Caracteres();
		Import_5c import_5c = new Import_5c();
		System.out.println(import_5c.run_Import_5c());
		return "_________________________________________";		
	}
}

class Import_1{
	public String run_Import_1() {
		System.err.println("1. Conectar e Exibir o Conteúdo de uma URL\n");
        try {
            @SuppressWarnings("deprecation")
			URL url = new URL("http://www.google.com");
            URLConnection connection = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		return "\n\n***** |_____| *****";		
	}
}

class Import_2{
	public String run_Import_2() {
		System.err.println("2. Conectar e Obter o Tipo de Conteúdo\n");
        try {
            @SuppressWarnings("deprecation")
			URL url = new URL("http://www.example.com");
            URLConnection connection = url.openConnection();

            System.out.println("Tipo de conteúdo: " + connection.getContentType());
        } catch (Exception e) {
            e.printStackTrace();
        }
		return "\n\n***** ***** |_____| *****s *****";	
	}
}

class Import_3{
	public String run_Import_3() {
		System.err.println("3. Configurar Cabeçalhos HTTP (User-Agent)\n");
        try {
            @SuppressWarnings("deprecation")
			URL url = new URL("http://www.example.com");
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
		return "\n\n***** ***** |_____| ***** *****";	
	}
}

class Import_4d{
	public String run_Import_4d() {
		System.err.println("4. Enviar Dados via POST\n");
        try {
            String urlParameters = "param1=value1&param2=value2";
            byte[] postData = urlParameters.getBytes();

            @SuppressWarnings("deprecation")
			URL url = new URL("http://www.example.com");
            URLConnection connection = url.openConnection();
            connection.setDoOutput(true);
            
            HttpURLConnection connectionPost = (HttpURLConnection) url.openConnection();
            connectionPost.setRequestMethod("POST");
            

            try (OutputStream os = connection.getOutputStream()) {
                os.write(postData);
                os.flush();
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
		return "\n\n***** ***** |_____| ***** *****";	
	}
}

class Import_5c{
	public String run_Import_5c() {
		System.err.println("5. Fazer uma Conexão com um Proxy\n");
		 try {
	            System.setProperty("http.proxyHost", "proxy.example.com");
	            System.setProperty("http.proxyPort", "8080");

	            @SuppressWarnings("deprecation")
				URL url = new URL("http://www.example.com");
	            URLConnection connection = url.openConnection();

	            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	            String inputLine;
	            while ((inputLine = in.readLine()) != null) {
	                System.out.println(inputLine);
	            }
	            in.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		return "\n\n***** ***** |_____| ***** *****";	
	}
}