package NET_25_SocketPermission;

import util.Linhas;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketPermission;
import java.security.*;

public class Simples {
	public String Simples_Run() {

		Linhas linhas = new Linhas();
		String collec = "\n\t SocketPermission – Representa permissões para acessar sockets de rede. \n";
		System.err.println(collec);

		linhas.run_Caracteres();
		Import_1 import_1 = new Import_1();
		System.out.println(import_1.run_Import_1());

		linhas.run_Caracteres();
		Import_2 import_2 = new Import_2();
		System.out.println(import_2.run_Import_2());

		// linhas.run_Caracteres();
		// Import_3 import_3 = new Import_3();
		// System.out.println(import_3.run_Import_3());

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
		System.err.println("1. Concedendo Permissão a um Domínio Específico: \n");

		// Concede permissão para conectar-se a example.com na porta 80
		Permission permission = new SocketPermission("example.com:80", "connect");
		System.out.println("Permissão concedida para: " + permission);

		return "\n\n***** *****|_____| ***** *****";
	}
}

class Import_2 {

	public String run_Import_2() {
		System.err.println("2. Verificando Permissão no Gerenciador de Segurança: \n");

		Permission permission = new SocketPermission("example.com:80", "connect");

		try {
			AccessController.checkPermission(permission);
			System.out.println("Acesso permitido!");
		} catch (AccessControlException e) {
			System.out.println("Acesso negado: " + e.getMessage());
		}

		return "\n\n***** ***** |_____| ***** *****";
	}
}

@SuppressWarnings("removal")
class Import_3 extends SecurityManager {

	public void checkPermission(Permission perm) {
		if (perm instanceof SocketPermission) {
			System.out.println("Tentativa de acesso ao socket: " + perm);
		}
	}

	public String run_Import_3() {
		System.err.println("3. Criando um SecurityManager Personalizado \n");

		System.setSecurityManager(new Import_3());

		Permission permission = new SocketPermission("example.com:80", "connect");
		System.getSecurityManager().checkPermission(permission);

		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_4t {
	public String run_Import_4t() {
		System.err.println("4. Permissão para Vários Hosts e Portas\n");

		// Permissão para várias portas e hosts
		SocketPermission permission1 = new SocketPermission("example.com:80", "connect");
		SocketPermission permission2 = new SocketPermission("*.google.com:443", "connect,resolve");

		System.out.println("Permissão 1: " + permission1);
		System.out.println("Permissão 2: " + permission2);

		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_5t {
	public String run_Import_5t() {
		System.err.println("5. Tentativa de Conexão com Permissão Negada\n");

		try {
			Socket socket = new Socket("restricted.com", 8080);
			System.out.println("Conectado com sucesso!");
			socket.close();
		} catch (IOException e) {
			System.out.println("Falha na conexão: " + e.getMessage());
		}

		return "\n\n***** ***** |_____| ***** *****";
	}
}