package NET_08_DatagramSocket;

import util.Linhas;

public class Vetor_ {
	public String VetorMatrix_Run() {
		
		Linhas linhas = new Linhas();
		String collec = "\n\t Nome do comando \n";
		System.err.println(collec);
		
		linhas.run_Caracteres();
		Import_D import_1 = new Import_D();
		System.out.println(import_1.run_Import_1());
		
		linhas.run_Caracteres();
		Import_E import_2 = new Import_E();
		System.out.println(import_2.run_Import_2());
		
		linhas.run_Caracteres();
		Import_F import_3 = new Import_F();
		System.out.println(import_3.run_Import_3());
		return "_________________________________________";		
	}
}

class Import_D{
	
	public String run_Import_1() {
		System.err.println("\n");
		return "\n\n***** |_____| *****";		
	}
}

class Import_E{
	public String run_Import_2() {
		System.err.println("\n");
		return "\n\n***** ***** |_____| *****s *****";	
	}
}

class Import_F{
	public String run_Import_3() {
		System.err.println("\n");
		return "\n\n***** ***** |_____| ***** *****";	
	}
}