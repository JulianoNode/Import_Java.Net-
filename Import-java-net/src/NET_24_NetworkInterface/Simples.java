package NET_24_NetworkInterface;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

import util.Linhas;

public class Simples {
	public String Simples_Run() throws Exception {

		Linhas linhas = new Linhas();
		String collec = "\n\t NetworkInterface – Representa uma interface de rede local. \n";
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
		return "_________________________________________";
	}
}

class Import_1 {
	public String run_Import_1() throws SocketException {
		System.err.println("1. Listar todas as interfaces de rede: \n");
		
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
        
        while (interfaces.hasMoreElements()) {
            NetworkInterface netInterface = interfaces.nextElement();
            System.out.println("Nome: " + netInterface.getName());
            System.out.println("Display Name: " + netInterface.getDisplayName());
            System.out.println("-----------------------------");
        }
		
		return "\n\n***** *****|_____| ***** *****";
	}
}

class Import_2 {
	public String run_Import_2() throws SocketException {
		System.err.println("2. Obter uma interface específica pelo nome: \n");
		
        String nomeInterface = "eth0"; // Altere conforme necessário
        NetworkInterface netInterface = NetworkInterface.getByName(nomeInterface);
        
        if (netInterface != null) {
            System.out.println("Interface encontrada: " + netInterface.getDisplayName());
        } else {
            System.out.println("Interface não encontrada.");
        }
		
		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_3 {
	public String run_Import_3() throws  SocketException, UnknownHostException {
		System.err.println("3. Obter uma interface pela sua interface de rede (IP): \n");
		
        InetAddress ip = InetAddress.getByName("192.168.1.1"); // Substitua pelo IP desejado
        NetworkInterface netInterface = NetworkInterface.getByInetAddress(ip);

        if (netInterface != null) {
            System.out.println("Interface encontrada: " + netInterface.getDisplayName());
        } else {
            System.out.println("Nenhuma interface encontrada para esse IP.");
        }
		
		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_4t {
	public String run_Import_4t() throws SocketException {
		System.err.println("4. Verificar se uma interface é loopback: \n");

		NetworkInterface loopback = NetworkInterface.getByName("lo");

		if (loopback != null && loopback.isLoopback()) {
			System.out.println(loopback.getDisplayName() + " é uma interface loopback.");
		} else {
			System.out.println("Interface não é loopback.");
		}

		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_5t {
	public String run_Import_5t() throws SocketException {
		System.err.println("5. Exibir o endereço MAC de uma interface: \n");

		NetworkInterface netInterface = NetworkInterface.getByName("eth0"); // Ajuste conforme necessário

		if (netInterface != null) {
			byte[] mac = netInterface.getHardwareAddress();

			if (mac != null) {
				StringBuilder macStr = new StringBuilder();
				for (byte b : mac) {
					macStr.append(String.format("%02X:", b));
				}
				System.out.println("Endereço MAC: " + macStr.substring(0, macStr.length() - 1));
			} else {
				System.out.println("Endereço MAC não disponível.");
			}
		}

		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_6t {
	public String run_Import_6t() throws SocketException {
		System.err.println("6. Listar todos os endereços IP das interfaces: \n");

		Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();

		while (interfaces.hasMoreElements()) {
			NetworkInterface netInterface = interfaces.nextElement();
			System.out.println("Interface: " + netInterface.getDisplayName());

			Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
			while (addresses.hasMoreElements()) {
				InetAddress address = addresses.nextElement();
				System.out.println("  IP: " + address.getHostAddress());
			}
			System.out.println("----------------------------");
		}

		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_7t {
	public String run_Import_7t() throws SocketException {
		System.err.println("7. Verificar se uma interface suporta multicast: \n");

		NetworkInterface netInterface = NetworkInterface.getByName("eth0"); // Ajuste conforme necessário

		if (netInterface != null) {
			System.out.println("Suporte a multicast: " + netInterface.supportsMulticast());
		} else {
			System.out.println("Interface não encontrada.");
		}

		return "\n\n***** ***** |_____| ***** *****";
	}
}