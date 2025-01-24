package NET_20_Authenticator;

import util.Linhas;

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
		return "_________________________________________";		
	}
}

class Import_1{
	public String run_Import_1() {
		System.err.println("\n");
		return "\n\n***** *****|_____| ***** *****";		
	}
}

class Import_2{
	public String run_Import_2() {
		System.err.println("\n");
		return "\n\n***** ***** |_____| ***** *****";	
	}
}

class Import_3{
	public String run_Import_3() {
		System.err.println("\n");
		return "\n\n***** ***** |_____| ***** *****";	
	}
}

class Import_4t{
	public String run_Import_4t() {
		System.err.println("\n");
		return "\n\n***** ***** |_____| ***** *****";	
	}
}

class Import_5t{
	public String run_Import_5t() {
		System.err.println("\n");
		return "\n\n***** ***** |_____| ***** *****";	
	}
}