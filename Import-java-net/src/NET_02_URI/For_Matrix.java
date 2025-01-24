package NET_02_URI;


import util.Linhas;

public class For_Matrix {
	public String matrix_Run() {

		Linhas linhas = new Linhas();
		String collec = "\n\t Nome do comando \n";
		System.err.println(collec);
		
		linhas.run_Caracteres();
		Import_7 import_1 = new Import_7();
		System.out.println(import_1.run_Import_1());
		
		linhas.run_Caracteres();
		Import_8 import_2 = new Import_8();
		System.out.println(import_2.run_Import_2());
		
		linhas.run_Caracteres();
		Import_9 import_3 = new Import_9();
		System.out.println(import_3.run_Import_3());
		return "_________________________________________";		
	}
}

class Import_7{
	
	public String run_Import_1() {
		
		return "\n\n***** |_____| *****";		
	}
}

class Import_8{
	public String run_Import_2() {

		return "\n\n***** ***** |_____| *****s *****";	
	}
}

class Import_9{
	public String run_Import_3() {

		return "\n\n***** ***** |_____| ***** *****";	
	}
}


