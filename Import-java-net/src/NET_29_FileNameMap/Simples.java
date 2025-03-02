package NET_29_FileNameMap;

import java.net.FileNameMap;
import java.net.URLConnection;

import util.Linhas;

public class Simples {
	public String Simples_Run() {

		Linhas linhas = new Linhas();
		String collec = "\n\t FileNameMap – Mapeia extensões de arquivos para tipos MIME. \n";
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
	public String run_Import_1() {
		System.err.println(
				"1. Utilizamos URLConnection.getFileNameMap() para obter um mapeamento entre nomes de arquivos e tipos MIME.\n");

		// Obtém o mapeamento de nomes de arquivo para tipos MIME
		FileNameMap fileNameMap = URLConnection.getFileNameMap();

		// Exemplos de arquivos com diferentes extensões
		String[] files = { "documento.pdf", "imagem.jpg", "musica.mp3", "video.mp4", "pagina.html", "script.js",
				"estilo.css" };

		// Percorre a lista de arquivos e exibe o tipo MIME correspondente
		for (String file : files) {
			String mimeType = fileNameMap.getContentTypeFor(file);
			System.out.println("Arquivo: " + file + " -> Tipo MIME: " + (mimeType != null ? mimeType : "Desconhecido"));
		}
		return "\n\n***** *****|_____| ***** *****";
	}
}

class Import_2 {
	public String run_Import_2() {
		System.err.println("2. Obtendo o tipo MIME de um arquivo\n");

		FileNameMap fileNameMap = URLConnection.getFileNameMap();
		String mimeType = fileNameMap.getContentTypeFor("arquivo.pdf");

		System.out.println("Tipo MIME: " + mimeType);
		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_3 {
	public String run_Import_3() {
		System.err.println("3. Obter o tipo MIME de um arquivo com FileNameMap\n");

		// Obtém o mapeador de tipos MIME
		FileNameMap fileNameMap = URLConnection.getFileNameMap();

		// Define um nome de arquivo com extensão
		String fileName = "documento.pdf";

		// Obtém o tipo MIME com base na extensão do arquivo
		String mimeType = fileNameMap.getContentTypeFor(fileName);

		// Exibe o resultado
		System.out.println("O tipo MIME para " + fileName + " é: " + mimeType);

		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_4t {
	public String run_Import_4t() {
		System.err.println("4.  Usando FileNameMap para Obter Tipos MIME\n");

		FileNameMap fileNameMap = URLConnection.getFileNameMap();
		String[] arquivos = { "documento.pdf", "imagem.jpg", "script.js" };
		int i = 0;

		while (i < arquivos.length) {
			String mimeType = fileNameMap.getContentTypeFor(arquivos[i]);
			System.out.println(arquivos[i] + " -> " + mimeType);
			i++;
		}

		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_5t {
	public String run_Import_5t() {
		System.err.println("5. Matriz de Arquivos com Verificação de Tipo MIME\n");
		
		String[][] arquivos = { { "relatorio.docx", "apresentacao.pptx" }, { "foto.png", "musica.mp3" },
				{ "script.js", "estilo.css" } };

		FileNameMap fileNameMap = URLConnection.getFileNameMap();

		for (String[] linha : arquivos) {
			for (String arquivo : linha) {
				String mimeType = fileNameMap.getContentTypeFor(arquivo);
				System.out.println(
						"Arquivo: " + arquivo + " -> Tipo MIME: " + (mimeType != null ? mimeType : "desconhecido"));
			}
		}

		return "\n\n***** ***** |_____| ***** *****";
	}
}