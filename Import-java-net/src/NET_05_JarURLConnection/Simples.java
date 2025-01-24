package NET_05_JarURLConnection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

import util.Linhas;

public class Simples {
	public String Simples_Run() {

		Linhas linhas = new Linhas();
		String collec = "\n\t JarURLConnection – Subclasse de URLConnection usada para arquivos JAR.\n";
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
		Import_1A import_1A = new Import_1A();
		System.out.println(import_1A.run_Import_1A());

		linhas.run_Caracteres();
		Import_2B import_2B = new Import_2B();
		System.out.println(import_2B.run_Import_2B());

		linhas.run_Caracteres();
		Import_3C import_3C = new Import_3C();
		System.out.println(import_3C.run_Import_3C());
		return "_________________________________________";
	}
}

class Import_1 {

	public String run_Import_1() {
		System.err.println("1: Listar Arquivos Dentro de um JAR\n"
				+ "Este código acessa um JAR e lista os arquivos dentro dele.\n");
		
        try {
            // Caminho para o JAR (altere para o caminho correto do seu JAR)
            @SuppressWarnings("deprecation")
			URL jarUrl = new URL("jar:file:/caminho/para/seu_arquivo.jar!/");
            
            // Abrindo conexão com o JAR
            JarURLConnection jarConnection = (JarURLConnection) jarUrl.openConnection();
            JarFile jarFile = jarConnection.getJarFile();

            // Listando os arquivos dentro do JAR
            Enumeration<JarEntry> entries = jarFile.entries();
            while (entries.hasMoreElements()) {
                System.out.println(entries.nextElement().getName());
            }

            jarFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_2 {
	public String run_Import_2() {
		System.err.println("2: Ler um Arquivo Específico Dentro de um JAR\n"
				+ "Este código lê um arquivo de texto chamado dados.txt dentro do JAR e exibe seu conteúdo.\n");
		
        try {
            // Caminho para o arquivo dentro do JAR
            @SuppressWarnings("deprecation")
			URL fileUrl = new URL("jar:file:/caminho/para/seu_arquivo.jar!/dados.txt");

            // Abrindo conexão
            JarURLConnection jarConnection = (JarURLConnection) fileUrl.openConnection();
            InputStream inputStream = jarConnection.getInputStream();
            
            // Lendo o conteúdo do arquivo
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_3 {
	public String run_Import_3() {
		System.err.println("4: Obter Informações do Manifesto do JAR\n"
				+ "Este código lê o manifesto (META-INF/MANIFEST.MF) do JAR e exibe suas propriedades.\n");
		try {
			// URL para o Manifest dentro do JAR
			@SuppressWarnings("deprecation")
			URL manifestUrl = new URL("jar:file:/caminho/para/seu_arquivo.jar!/META-INF/MANIFEST.MF");

			// Abrindo conexão
			JarURLConnection jarConnection = (JarURLConnection) manifestUrl.openConnection();
			Manifest manifest = jarConnection.getManifest();

			// Obtendo os atributos do Manifest
			Attributes attributes = manifest.getMainAttributes();
			for (Object key : attributes.keySet()) {
				System.out.println(key + ": " + attributes.getValue(key.toString()));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_1A {
	public String run_Import_1A() {
		System.err.println("3: Verificar Se um Arquivo Existe Dentro de um JAR\r\n"
				+ "Este código verifica se um arquivo específico está dentro do JAR.\n");

		try {
			// URL do JAR
			@SuppressWarnings("deprecation")
			URL jarUrl = new URL("jar:file:/caminho/para/seu_arquivo.jar!/");

			// Abrindo conexão
			JarURLConnection jarConnection = (JarURLConnection) jarUrl.openConnection();
			JarFile jarFile = jarConnection.getJarFile();

			// Nome do arquivo para verificar
			String fileName = "dados.txt";

			// Verifica se o arquivo existe
			if (jarFile.getJarEntry(fileName) != null) {
				System.out.println("O arquivo " + fileName + " existe dentro do JAR.");
			} else {
				System.out.println("O arquivo " + fileName + " não foi encontrado no JAR.");
			}

			jarFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_2B {
	public String run_Import_2B() {
		System.err.println("5: Extrair Arquivo de um JAR\n"
				+ "Este código copia um arquivo de dentro do JAR para o sistema de arquivos.\n");

		try {
			// URL do arquivo dentro do JAR
			@SuppressWarnings("deprecation")
			URL fileUrl = new URL("jar:file:G:/Caminhho/seu_arquivo.jar!/dados.txt");

			// Abrindo conexão
			JarURLConnection jarConnection = (JarURLConnection) fileUrl.openConnection();
			InputStream inputStream = jarConnection.getInputStream();

			// Criando arquivo local
			FileOutputStream outputStream = new FileOutputStream("dados_extraido.txt");

			// Copiando conteúdo
			byte[] buffer = new byte[1024];
			int bytesRead;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}

			// Fechando streams
			inputStream.close();
			outputStream.close();
			System.out.println("Arquivo extraído com sucesso!");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "\n\n***** ***** |_____| ***** *****";
	}
}

class Import_3C {
	public String run_Import_3C() {
		System.err.println("6: Carregar Classe de um JAR Dinamicamente\n"
				+ "Este código carrega uma classe de um JAR e executa um método dela.\n");

		try {
			// Caminho do JAR
			File file = new File("G:/Caminhho/seu_arquivo.jar");
			URL jarUrl = file.toURI().toURL();

			// Criando um class loader
			URLClassLoader classLoader = new URLClassLoader(new URL[] { jarUrl });

			// Nome da classe que deseja carregar
			String className = "com.exemplo.MinhaClasse";
			Class<?> loadedClass = classLoader.loadClass(className);

			// Criando uma instância e chamando um método
			Object instance = loadedClass.getDeclaredConstructor().newInstance();
			Method method = loadedClass.getMethod("meuMetodo");
			method.invoke(instance);

			classLoader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "\n\n***** ***** |_____| ***** *****";
	}
}