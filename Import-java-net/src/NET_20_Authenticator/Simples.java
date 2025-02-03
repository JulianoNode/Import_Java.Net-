package NET_20_Authenticator;

import util.Linhas;

import java.net.*;
import java.io.*;

public class Simples {
	public String Simples_Run() {

		Linhas linhas = new Linhas();
		String collec = "\n\t Authenticator – Classe usada para fornecer autenticação ao acessar recursos protegido \n";
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
		
		linhas.run_Caracteres();
		Import_6t import_6t = new Import_6t();
		System.out.println(import_6t.run_Import_6t());
		
		linhas.run_Caracteres();
		Import_7t import_7t = new Import_7t();
		System.out.println(import_7t.run_Import_7t());
		
		linhas.run_Caracteres();
		Import_8t import_8t = new Import_8t();
		System.out.println(import_8t.run_Import_8t());
		return "_________________________________________";
	}
}

class Import_1 {
	public String run_Import_1() {
		System.err.println("1. Autenticação com Authenticator e URLConnection\n");

		Authenticator.setDefault(new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("usuario", "senha".toCharArray());
			}
		});

		try {
			@SuppressWarnings("deprecation")
			URL url = new URL("http://www.exemplo.com");
			URLConnection connection = url.openConnection();
			connection.connect();
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "\n\n***** *****|_____| ***** *****";
	}
}

class Import_2 {
	public String run_Import_2() {
		System.err.println("2. Autenticação para Conexão com FTP\n");

		Authenticator.setDefault(new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("ftpUser", "ftpPass".toCharArray());
			}
		});

		try {
			@SuppressWarnings("deprecation")
			URL url = new URL("ftp://ftp.example.com/file.txt");
			URLConnection connection = url.openConnection();
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_3 {
	public String run_Import_3() {
		System.err.println("3. Autenticação em um Proxy HTTPS\n");

		Authenticator.setDefault(new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("proxyUser", "proxyPass".toCharArray());
			}
		});

		System.setProperty("https.proxyHost", "proxy.example.com");
		System.setProperty("https.proxyPort", "443");

		try {
			@SuppressWarnings("deprecation")
			URL url = new URL("https://www.exemplo.com");
			URLConnection connection = url.openConnection();
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_4t {
	public String run_Import_4t() {
		System.err.println("4. Autenticação para Conectar-se ao Google\n");

		Authenticator.setDefault(new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("user", "password".toCharArray());
			}
		});

		try {
			@SuppressWarnings("deprecation")
			URL url = new URL("https://www.google.com");
			URLConnection connection = url.openConnection();
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_5t {
	public String run_Import_5t() {
		System.err.println("5. Autenticação com Protocolo HTTP e Authenticator Customizado\n");

		Authenticator.setDefault(new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				String user = System.getenv("USER_NAME");
				String pass = System.getenv("PASSWORD");
				return new PasswordAuthentication(user, pass.toCharArray());
			}
		});

		try {
			@SuppressWarnings("deprecation")
			URL url = new URL("http://www.exemplo.com");
			URLConnection connection = url.openConnection();
			connection.connect();
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_6t{
	public String run_Import_6t() {
		System.err.println("6 Usando Authenticator para Proxies\n");
		
        Authenticator.setDefault(new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("proxyUser", "proxyPass".toCharArray());
            }
        });

        System.setProperty("http.proxyHost", "proxy.example.com");
        System.setProperty("http.proxyPort", "8080");

        try {
            @SuppressWarnings("deprecation")
			URL url = new URL("http://www.exemplo.com");
            URLConnection conn = url.openConnection();
            InputStreamReader isr = new InputStreamReader(conn.getInputStream());
            BufferedReader reader = new BufferedReader(isr);
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		return "\n\n***** ***** |_____| ***** *****";	
	}
}

class Import_7t{
	public String run_Import_7t() {
		System.err.println("7. Usando o Authenticator para HTTP Básico\n");
		
        Authenticator.setDefault(new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("usuario", "senha".toCharArray());
            }
        });

        try {
            @SuppressWarnings("deprecation")
			URL url = new URL("http://www.exemplo.com");
            URLConnection conn = url.openConnection();
            InputStreamReader isr = new InputStreamReader(conn.getInputStream());
            BufferedReader reader = new BufferedReader(isr);
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		return "\n\n***** ***** |_____| ***** *****";	
	}
}


class Import_8t{
	public String run_Import_8t() {
		System.err.println("8. Esse código configura um autenticador global que pode ser usado para "
				+ "\nautenticar conexões HTTP ou HTTPS que exijam nome de usuário e senha.\n");
		
		  // Configura um autenticador global
        Authenticator.setDefault(new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("usuario", "senha".toCharArray());
            }
        });

        try {
            // URL protegida por autenticação
            @SuppressWarnings("deprecation")
			URL url = new URL("https://exemplo.com/protegido");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Faz a requisição
            int responseCode = connection.getResponseCode();
            System.out.println("Código de resposta: " + responseCode);

            // Lendo a resposta, se necessário
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
                reader.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		return "\n\n***** ***** |_____| ***** *****";	
	}
}


