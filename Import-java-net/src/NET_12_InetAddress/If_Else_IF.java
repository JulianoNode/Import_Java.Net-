package NET_12_InetAddress;

import util.Linhas;

public class If_Else_IF {
	public String If_Else_IF_Run() {

		Linhas linhas = new Linhas();
		String collec = "\n\tList<E>: Representa uma lista ordenada.\n";
		System.err.println(collec);

		linhas.run_Caracteres();
		Import_4 import_1 = new Import_4();
		System.out.println(import_1.run_Import_1());
		
		linhas.run_Caracteres();
		Import_5 import_2 = new Import_5();
		System.out.println(import_2.run_Import_2());
		
		linhas.run_Caracteres();
		Import_6 import_3 = new Import_6();
		System.out.println(import_3.run_Import_3());
		return "_________________________________________";		
	}
}

class Import_4{
	
	public String run_Import_1() {
		System.err.println("\n");
		return "\n\n***** |_____| *****";		
	}
}

class Import_5{
	public String run_Import_2() {
		System.err.println("\n");
		return "\n\n***** ***** |_____| ***** *****";	
	}
}

class Import_6{
	public String run_Import_3() {
		System.err.println("\n");
		return "\n\n***** ***** |_____| ***** *****";	
	}
}