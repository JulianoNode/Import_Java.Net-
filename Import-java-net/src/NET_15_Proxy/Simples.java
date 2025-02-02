package NET_15_Proxy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.URL;

import java.lang.reflect.*;

import util.Linhas;

public class Simples {
	public String Simples_Run() {

		Linhas linhas = new Linhas();
		String collec = "\n\t Proxy – Representa um servidor proxy. \n";
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

		return "_________________________________________";
	}
}

class Import_1 {
	// Interface comum para o objeto real e o proxy
	interface Servico {
		void operacao();
	}

	// Implementação real do serviço
	class ServicoReal implements Servico {
		@Override
		public void operacao() {
			System.out.println("Executando operação no serviço real.");
		}
	}

	// Proxy para controlar o acesso ao serviço real
	class ServicoProxy implements Servico {
		private ServicoReal servicoReal;
		private boolean autenticado;

		public ServicoProxy(String usuario, String senha) {
			// Simula uma autenticação
			if ("admin".equals(usuario) && "1234".equals(senha)) {
				autenticado = true;
			}
		}

		@Override
		public void operacao() {
			if (autenticado) {
				if (servicoReal == null) {
					servicoReal = new ServicoReal();
				}
				System.out.println("Proxy: Acesso concedido. Chamando o serviço real...");
				servicoReal.operacao();
			} else {
				System.out.println("Proxy: Acesso negado. Usuário não autenticado.");
			}
		}
	}

	public String run_Import_1() {
		System.err.println("Uso do Proxy\r\n" + "Código que testa o proxy.\n");

		Servico servico1 = new ServicoProxy("admin", "1234");
		servico1.operacao(); // Deve permitir o acesso

		Servico servico2 = new ServicoProxy("user", "senhaErrada");
		servico2.operacao(); // Deve negar o acesso
		return "\n\n***** *****|_____| ***** *****";
	}
}

class Import_2 {
	public String run_Import_2() {
		System.err.println("\n");

		try {
			// Definir o proxy e a porta
			String proxyHost = "proxy.exemplo.com";
			int proxyPort = 8080;

			// Definir as credenciais do proxy
			String proxyUser = "usuario";
			String proxyPassword = "senha";

			// Configurar a autenticação do proxy
			Authenticator.setDefault(new Authenticator() {
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(proxyUser, proxyPassword.toCharArray());
				}
			});

			// Criar um Proxy
			Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort));

			// Criar a URL de destino
			@SuppressWarnings("deprecation")
			URL url = new URL("http://www.google.com");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection(proxy);

			// Configurar a conexão
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);

			// Ler a resposta
			int responseCode = connection.getResponseCode();
			System.out.println("Response Code: " + responseCode);

			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String inputLine;
			StringBuilder response = new StringBuilder();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// Exibir o conteúdo da resposta
			System.out.println("Response: " + response.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "\n\n***** ***** |_____| ***** *****";
	}
}
//___________________________________________________

//Interface para autenticação
interface Autenticavel {
	boolean login(String usuario, String senha);
}

//Implementação real do objeto autenticável
class Usuario implements Autenticavel {
	private final String usuarioCorreto = "admin";
	private final String senhaCorreta = "1234";

	@Override
	public boolean login(String usuario, String senha) {
		return usuarioCorreto.equals(usuario) && senhaCorreta.equals(senha);
	}
}

//Proxy para autenticação
class ProxyAutenticacao implements InvocationHandler {
	private final Autenticavel usuarioReal;

	public ProxyAutenticacao(Autenticavel usuarioReal) {
		this.usuarioReal = usuarioReal;
	}

	@Override
	public Object invoke(Object proxy, Method metodo, Object[] args) throws Throwable {
		if (metodo.getName().equals("login")) {
			String usuario = (String) args[0];
			String senha = (String) args[1];

			System.out.println("Tentando autenticar usuário: " + usuario);
			boolean autenticado = (boolean) metodo.invoke(usuarioReal, usuario, senha);

			if (autenticado) {
				System.out.println("Autenticação bem-sucedida!");
			} else {
				System.out.println("Falha na autenticação!");
			}

			return autenticado;
		}
		return metodo.invoke(usuarioReal, args);
	}
}

class Import_3 {
	public String run_Import_3() {
		System.err.println("Usa Authenticator para fornecer usuário e senha do proxy.\n");

		// Criando instância real
		Autenticavel usuarioReal = new Usuario();

		Autenticavel proxy = (Autenticavel) java.lang.reflect.Proxy.newProxyInstance(usuarioReal.getClass().getClassLoader(),
				new Class[] { Autenticavel.class }, (proxyObj, method, args) -> {
					if (method.getName().equals("login")) {
						String usuario = (String) args[0];
						String senha = (String) args[1];

						System.out.println("Tentando autenticar usuário: " + usuario);
						boolean autenticado = (boolean) method.invoke(usuarioReal, usuario, senha);

						System.out.println(autenticado ? "Autenticação bem-sucedida!" : "Falha na autenticação!");
						return autenticado;
					}
					return method.invoke(usuarioReal, args);
				});

		// Testando autenticação
		proxy.login("admin", "1234"); // Sucesso
		proxy.login("user", "wrongpass"); // Falha
		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_4t {
	public String run_Import_4t() {
		System.err.println("Código de autenticação com proxy em Java\n");
		
		   // Configuração do proxy
        String proxyIp = "192.168.1.100"; // IP do proxy
        int proxyPort = 8080; // Porta do proxy
        String proxyUser = "usuario"; // Usuário do proxy
        String proxyPass = "senha"; // Senha do proxy

        // Definir autenticação para o proxy
        Authenticator.setDefault(new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(proxyUser, proxyPass.toCharArray());
            }
        });

        try {
            // Criar objeto Proxy
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyIp, proxyPort));

            // URL para conexão
            @SuppressWarnings("deprecation")
			URL url = new URL("http://httpbin.org/ip"); // Endpoint de teste
            HttpURLConnection conn = (HttpURLConnection) url.openConnection(proxy);
            conn.setRequestMethod("GET");

            // Ler resposta
            int responseCode = conn.getResponseCode();
            System.out.println("Código de resposta: " + responseCode);

            if (responseCode == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                System.out.println("Resposta: " + response.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		return "\n\n***** ***** |_____| ***** *****";
	}
}
