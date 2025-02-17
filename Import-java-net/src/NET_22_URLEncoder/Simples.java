package NET_22_URLEncoder;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.stream.Collectors;

import util.Linhas;

public class Simples {
	public String Simples_Run() throws Exception {

		Linhas linhas = new Linhas();
		String collec = "\n\tURLEncoder – Codifica strings para serem usadas em URLs. \n";
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

class Import_1{
	public String run_Import_1() throws Exception {
		System.err.println("1. Codificar uma String Simples: \n");
		
		String texto = "Olá Mundo!";
        String encoded = URLEncoder.encode(texto, StandardCharsets.UTF_8.toString());
        System.out.println("Encoded: " + encoded);
        
		return "\n\n***** *****|_____| ***** *****";		
	}
}

class Import_2{
	public String run_Import_2() throws Exception {
		System.err.println("2. Codificar uma URL Completa: \n");
		
        String url = "https://exemplo.com/search?q=olá mundo!";
        String encoded = URLEncoder.encode(url, StandardCharsets.UTF_8.toString());
        System.out.println("Encoded URL: " + encoded);
        
		return "\n\n***** ***** |_____| ***** *****";	
	}
}

class Import_3{
	public String run_Import_3()  throws Exception {
		System.err.println("3. Codificar Parâmetros de URL Separadamente: \n");
		
        String chave = "q";
        String valor = "Olá Mundo!";
        String encodedParam = URLEncoder.encode(valor, StandardCharsets.UTF_8.toString());
        String url = "https://exemplo.com/search?" + chave + "=" + encodedParam;
        
        System.out.println("URL Encoded: " + url);
        
		return "\n\n***** ***** |_____| ***** *****";	
	}
}

class Import_4t{
	public String run_Import_4t() throws Exception {
		System.err.println("4. Codificar Múltiplos Parâmetros: \n");
		
		String nome = URLEncoder.encode("João Silva", StandardCharsets.UTF_8.toString());
        String cidade = URLEncoder.encode("São Paulo", StandardCharsets.UTF_8.toString());
        String url = "https://exemplo.com/api?nome=" + nome + "&cidade=" + cidade;

        System.out.println("URL Encoded: " + url);
		return "\n\n***** ***** |_____| ***** *****";	
	}
}

class Import_5t{
	public String run_Import_5t() throws Exception{
		System.err.println("5. Codificar Caracteres Especiais: \n");
		
        String texto = "Café & Leite";
        String encoded = URLEncoder.encode(texto, StandardCharsets.UTF_8.toString());
        System.out.println("Encoded: " + encoded);
		
		return "\n\n***** ***** |_____| ***** *****";	
	}
}

class Import_6t{
	
    public static String encode(String valor) throws Exception {
        return URLEncoder.encode(valor, StandardCharsets.UTF_8.toString());
    }
		
	public String run_Import_6t() throws Exception{
		System.err.println("6. Encapsular a Codificação em um Método: \n");
		
		 System.out.println("Encoded: " + encode("Texto com espaços!"));
		
		return "\n\n***** ***** |_____| ***** *****";	
	}
}

class Import_7t{
	public String run_Import_7t() throws Exception{
		System.err.println("7. Criar um Mapa de Parâmetros e Codificá-los Automaticamente: \n");
		
        Map<String, String> parametros = Map.of(
                "nome", "Maria Eduarda",
                "cidade", "Rio de Janeiro",
                "país", "Brasil"
            );

            String url = "https://exemplo.com/api?" +
                parametros.entrySet().stream()
                    .map(entry -> entry.getKey() + "=" + URLEncoder.encode(entry.getValue(), StandardCharsets.UTF_8))
                    .collect(Collectors.joining("&"));

            System.out.println("URL Encoded: " + url);
		return "\n\n***** ***** |_____| ***** *****";	
	}
}