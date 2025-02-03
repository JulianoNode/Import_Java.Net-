package NET_21_PasswordAuthentication;

import util.Linhas;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Scanner;

public class Simples {
	public String Simples_Run() {

		Linhas linhas = new Linhas();
		String collec = "\n\t PasswordAuthentication – Contém credenciais de usuário (usuário e senha). \n";
		System.err.println(collec);

		linhas.run_Caracteres();
		Import_1 import_1 = new Import_1();
		System.out.println(import_1.run_Import_1());

		linhas.run_Caracteres();
		Import_2 import_2 = new Import_2();
		System.out.println(import_2.run_Import_2());

		linhas.run_Caracteres();
		Import_3 import_3 = new Import_3(collec, collec);
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
		System.err.println("\r\n"
				+ "Aqui estão três exemplos simples em Java que utilizam java.net.PasswordAuthentication:\r\n"
				+ "1. Autenticação Simples\r\n"
				+ "Este código cria um objeto PasswordAuthentication e exibe o nome de usuário e senha armazenados.\n");

		// Criando um objeto PasswordAuthentication
		PasswordAuthentication auth = new PasswordAuthentication("usuario", "senha123".toCharArray());

		// Exibindo os dados
		System.out.println("Usuário: " + auth.getUserName());
		System.out.println("Senha: " + new String(auth.getPassword())); // Convertendo de char[] para String

		return "\n\n***** *****|_____| ***** *****";
	}
}

class Import_2 {
	public String run_Import_2() {
		System.err.println("2. Autenticação em um Servidor\r\n"
				+ "Este exemplo simula a verificação de credenciais antes de acessar um recurso protegido.\n");

		Scanner scanner = new Scanner(System.in);

		// Solicitando credenciais ao usuário
		System.out.print("Usuário: ");
		String user = scanner.nextLine();

		System.out.print("Senha: ");
		String password = scanner.nextLine();

		// Criando o objeto PasswordAuthentication
		PasswordAuthentication auth = new PasswordAuthentication(user, password.toCharArray());

		// Simulando uma verificação de autenticação
		if (authenticate(auth)) {
			System.out.println("Acesso concedido para navegar!");
		} else {
			System.out.println("Acesso negado!");
		}

		scanner.close();
		return "\n\n***** ***** |_____| ***** *****";
	}

	private static boolean authenticate(PasswordAuthentication auth) {
		// Simulando um banco de dados de credenciais
		String correctUser = "admin";
		String correctPassword = "1234";

		return auth.getUserName().equals(correctUser) && new String(auth.getPassword()).equals(correctPassword);

	}
}

class Import_3 extends Authenticator {

	private String user;
	private String password;

	public Import_3(String user, String password) {
		this.user = user;
		this.password = password;
	}

	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(user, password.toCharArray());
	}

	public String run_Import_3() {
		System.err.println("3. Uso com Proxy (Exemplo mais avançado)\n");

		System.setProperty("http.proxyUser", user);
		System.setProperty("http.proxyPassword", password);

		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_4t {
	public String run_Import_4t() {
		System.err.println("4. Aqui está um exemplo simples em Java usando a classe PasswordAuthentication "
				+ "\npara armazenar e recuperar credenciais de login:\n");

		// Criando uma instância de PasswordAuthentication com usuário e senha
		PasswordAuthentication auth = new PasswordAuthentication("usuario", "senha123".toCharArray());

		// Recuperando e exibindo os dados
		System.out.println("Usuário: " + auth.getUserName());

		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_5t {
	public String run_Import_5t() {
		System.err.println("5. Esse código  java.net.PasswordAuthentication dentro de um "
				+ "\nloop do-while para solicitar autenticação do usuário:\n");

		 // Vetor para armazenar usuários e senhas (simulação de um pequeno banco de dados)
        String[][] credenciais = {
            {"usuario1", "senha123"},
            {"admin", "adminpass"},
            {"teste", "1234"}
        };

        Scanner scanner = new Scanner(System.in);

        // Solicita ao usuário as credenciais
        System.out.print("Digite o usuário: ");
        String usuario = scanner.nextLine();
        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();
        
        // Armazena as credenciais inseridas pelo usuário
        PasswordAuthentication auth = new PasswordAuthentication(usuario, senha.toCharArray());

        // Verifica se as credenciais são válidas
        boolean autenticado = false;
        for (String[] credencial : credenciais) {
            if (credencial[0].equals(auth.getUserName()) && 
                String.valueOf(auth.getPassword()).equals(credencial[1])) {
                autenticado = true;
                break;
            }
        }

        // Exibe o resultado da autenticação
        if (autenticado) {
            System.out.println("Acesso permitido! Bem-vindo, " + auth.getUserName() + "!");
        } else {
            System.out.println("Acesso negado! Usuário ou senha incorretos.");
        }

        scanner.close();
		return "\n\n***** ***** |_____| ***** *****";
	}
}