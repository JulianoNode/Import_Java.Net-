package NET_SocketAddress;

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
		return "_________________________________________";		
	}
}

class Import_1{
	public String run_Import_1() {
		System.err.println("\n");
		return "\n\n***** |_____| *****";		
	}
}

class Import_2{
	public String run_Import_2() {
		System.err.println("\n");
		return "\n\n***** ***** |_____| *****s *****";	
	}
}

class Import_3{
	public String run_Import_3() {
		System.err.println("\n");
		return "\n\n***** ***** |_____| ***** *****";	
	}
}