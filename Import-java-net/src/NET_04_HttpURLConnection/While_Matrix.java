package NET_04_HttpURLConnection;

import util.Linhas;

public class While_Matrix {
	public String VetorMatrix_Run() {
		Linhas linhas = new Linhas();
		String collec = "\n\t Nome do comando \n";
		System.err.println(collec);
		
		linhas.run_Caracteres();
		Import_A import_1 = new Import_A();
		System.out.println(import_1.run_Import_1());
		
		linhas.run_Caracteres();
		Import_B import_2 = new Import_B();
		System.out.println(import_2.run_Import_2());
		
		linhas.run_Caracteres();
		Import_C import_3 = new Import_C();
		System.out.println(import_3.run_Import_3());
		return "_________________________________________";		
	}
}

class Import_A{
	
	public String run_Import_1() {
		
		return "\n\n***** |_____| *****";		
	}
}

class Import_B{
	public String run_Import_2() {

		return "\n\n***** ***** |_____| *****s *****";	
	}
}

class Import_C{
	public String run_Import_3() {

		return "\n\n***** ***** |_____| ***** *****";	
	}
}