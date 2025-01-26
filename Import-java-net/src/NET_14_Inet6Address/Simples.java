package NET_14_Inet6Address;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

import util.Linhas;

public class Simples {
	public String Simples_Run() throws Exception {

		Linhas linhas = new Linhas();
		String collec = "\n\t Inet6Address – Subclasse de InetAddress para endereços IPv6. \n";
		System.err.println(collec);

		//linhas.run_Caracteres();
		//Import_1 import_1 = new Import_1();
		//System.out.println(import_1.run_Import_1());

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
		System.err.println("1. Obter um Endereço IPv6 por Nome do Host\n");

		InetAddress address = Inet6Address.getByName("ipv6.google.com");
		System.out.println("Endereço IPv6: " + address);
		return "\n\n***** *****|_____| ***** *****";
	}
}

class Import_2 {
	public String run_Import_2() throws UnknownHostException {
		System.err.println("2. Criar um Objeto Inet6Address Manualmente\n");

		byte[] ipv6Bytes = { (byte) 0x20, (byte) 0x01, (byte) 0x0d, (byte) 0xb8, (byte) 0x85, (byte) 0xa3, (byte) 0x00,
				(byte) 0x00, (byte) 0x8a, (byte) 0x2e, (byte) 0x03, (byte) 0x70, (byte) 0x73, (byte) 0x34, (byte) 0x00,
				(byte) 0x01 };
		Inet6Address address = Inet6Address.getByAddress("meuIPv6", ipv6Bytes, 0);
		System.out.println("Endereço IPv6 criado: " + address);
		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_3 {
	public String run_Import_3() throws UnknownHostException {
		System.err.println("3. Verificar se um Endereço IPv6 é um Loopback\n");

		Inet6Address address = (Inet6Address) Inet6Address.getByName("::1");
		System.out.println("É loopback? " + address.isLoopbackAddress());
		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_4t {
	public String run_Import_4t() throws UnknownHostException {
		System.err.println("4. Verificar se um Endereço IPv6 é Link-Local\n");

		Inet6Address address = (Inet6Address) Inet6Address.getByName("fe80::1");
		System.out.println("É link-local? " + address.isLinkLocalAddress());
		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_5t {
	public String run_Import_5t() throws UnknownHostException {
		System.err.println("5.1 Verificar se um Endereço IPv6 é Multicast \n");
		Inet6Address address = (Inet6Address) Inet6Address.getByName("ff02::1");
		System.out.println("É multicast? " + address.isMulticastAddress());

		System.err.println("\n5.3 Verificar se um Endereço IPv6 é Site-Local \n");
		Inet6Address address3 = (Inet6Address) Inet6Address.getByName("fec0::1");
		System.out.println("É site-local? " + address3.isSiteLocalAddress());

		System.err.println("\n5.4. Criar e Identificar um Endereço IPv6 Global \n");
		Inet6Address address4 = (Inet6Address) Inet6Address.getByName("2001:db8::1");
		System.out.println("É global? " + (!address4.isSiteLocalAddress() && !address4.isLinkLocalAddress()));

		return "\n\n***** ***** |_____| ***** *****";
	}
}