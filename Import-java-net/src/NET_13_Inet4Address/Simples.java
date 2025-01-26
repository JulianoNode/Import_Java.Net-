package NET_13_Inet4Address;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

import util.Linhas;

public class Simples {
	public String Simples_Run() throws Exception {

		Linhas linhas = new Linhas();
		String collec = "\n\t Inet4Address – Subclasse de InetAddress para endereços IPv4. \n";
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
	public String run_Import_1() throws UnknownHostException {
		System.err.println("1. Obter o endereço IP do host local \n");

		Inet4Address localHost = (Inet4Address) Inet4Address.getLocalHost();
		System.out.println("Endereço IP do host local: " + localHost.getHostAddress());
		return "\n\n***** *****|_____| ***** *****";
	}
}

class Import_2 {
	public String run_Import_2() throws UnknownHostException {
		System.err.println("2. Obter o endereço IP de um domínio\n");

		String domain = "www.google.com";
		Inet4Address ip = (Inet4Address) Inet4Address.getByName(domain);
		System.out.println("Endereço IP de " + domain + ": " + ip.getHostAddress());
		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_3 {
	public String run_Import_3() throws UnknownHostException {
		System.err.println("3. Verificar se um endereço IP é um loopback\n");

		Inet4Address address = (Inet4Address) Inet4Address.getByName("127.0.0.1");
		System.out.println("É loopback? " + address.isLoopbackAddress());
		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_4t {
	public String run_Import_4t() throws UnknownHostException {
		System.err.println("4. Verificar se um IP é local (privado)\n");

		Inet4Address address = (Inet4Address) Inet4Address.getByName("192.168.1.1");
		System.out.println("É endereço privado/local? " + address.isSiteLocalAddress());
		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_5t {
	public String run_Import_5t() throws UnknownHostException {
		System.err.println("5.1 Obter todos os endereços IP associados a um domínio\n");

		String domain = "www.google.com";
		InetAddress[] addresses = Inet4Address.getAllByName(domain);
		System.out.println("Endereços IP de " + domain + ":");
		for (InetAddress address : addresses) {
			System.out.println(address.getHostAddress());
		}

		System.err.println("\n5.2 Criar um objeto Inet4Address a partir de bytes\n");

		byte[] ipBytes = { 8, 8, 8, 8 }; // IP do Google DNS (8.8.8.8)
		Inet4Address address = (Inet4Address) Inet4Address.getByAddress(ipBytes);
		System.out.println("Endereço criado: " + address.getHostAddress());

		System.err.println("\n5.3 Verificar se um IP é multicast\n");

		Inet4Address address1 = (Inet4Address) Inet4Address.getByName("224.0.0.1");
		System.out.println("É endereço multicast? " + address1.isMulticastAddress());

		System.err.println("\n5.4 Obter o nome do host a partir de um IP\n");
		Inet4Address address2 = (Inet4Address) Inet4Address.getByName("8.8.8.8");
		System.out.println("Nome do host para " + address2.getHostAddress() + ": " + address2.getHostName());

		return "\n\n***** ***** |_____| ***** *****";
	}
}