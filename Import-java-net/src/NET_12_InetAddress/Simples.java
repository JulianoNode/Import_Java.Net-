package NET_12_InetAddress;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import util.Linhas;

public class Simples {
	public String Simples_Run() throws IOException {

		Linhas linhas = new Linhas();
		String collec = "\n\t InetAddress – Representa um endereço IP (IPv4 ou IPv6). \n";
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

class Import_1{
	public String run_Import_1() throws UnknownHostException {
		System.err.println("1. Verificar se um IP pertence ao localhost\n");
		
        InetAddress address = InetAddress.getByName("127.0.0.1");
        if (address.isLoopbackAddress()) {
            System.out.println("O endereço pertence ao localhost.");
        } else {
            System.out.println("O endereço não pertence ao localhost.");
        }
		return "\n\n***** *****|_____| ***** *****";		
	}
}

class Import_2{
	public String run_Import_2() throws UnknownHostException {
		System.err.println("2. Obter o endereço IP do sistema pelo nome do host\n");
		
        String hostname = InetAddress.getLocalHost().getHostName();
        InetAddress address = InetAddress.getByName(hostname);
        System.out.println("Endereço IP do sistema: " + address.getHostAddress());
		return "\n\n***** ***** |_____| ***** *****";	
	}
}

class Import_3{
	public String run_Import_3() throws UnknownHostException {
		System.err.println("3. Exibir o nome do host e o endereço IP do sistema\n");
		
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println("Nome do Host: " + localHost.getHostName());
        System.out.println("Endereço IP: " + localHost.getHostAddress());
		return "\n\n***** ***** |_____| ***** *****";	
	}
}

class Import_4t{
	public String run_Import_4t() throws IOException {
		System.err.println("4. Verificar se um endereço IP é alcançável\n");
		
        InetAddress address = InetAddress.getByName("www.google.com");
        if (address.isReachable(3000)) {
            System.out.println("O endereço é alcançável.");
        } else {
            System.out.println("O endereço não é alcançável.");
        }
		return "\n\n***** ***** |_____| ***** *****";	
	}
}

class Import_5t{
	public String run_Import_5t() throws UnknownHostException {
		System.err.println("5_1. Obter o endereço IP do localhost\n");
        InetAddress localhost = InetAddress.getLocalHost();
        System.out.println("Endereço IP do localhost: " + localhost.getHostAddress());
        
		System.err.println("\n5_2. Obter o IP de um site específico\n");
        InetAddress site = InetAddress.getByName("www.google.com");
        System.out.println("Endereço IP do Google: " + site.getHostAddress());
        
		System.err.println("\n5_3. Obter o nome do host a partir de um IP\n");		
        InetAddress address = InetAddress.getByName("8.8.8.8");
        System.out.println("Nome do host: " + address.getHostName());
        
        System.err.println("\n5_4. Exibir o nome do host e o endereço IP do sistema\n");        
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println("Nome do Host: " + localHost.getHostName());
        System.out.println("Endereço IP: " + localHost.getHostAddress());
        System.out.println("Nome da Maquina ou Host: " + localHost.getCanonicalHostName());
        
		return "\n\n***** ***** |_____| ***** *****";	
	}
}