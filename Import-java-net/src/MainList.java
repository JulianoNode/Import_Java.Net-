
import java.util.Scanner;

import NET_JarURLConnection.Run_URLConnection;
import NET_URI.Run_URI;
import NET_URL.Run_URL;
import util.LimparConsole;
import util.Pausar;

public class MainList {
	public static void main(String[] args) {

		Pausar pausar = new Pausar();
		LimparConsole clear = new LimparConsole();
		Scanner scanner = new Scanner(System.in);

		// Vetor de opções do menu
		String[] menuOptions = { "|_ NET = URL – Representa um endereço de recurso na web.",
				"|_ NET = URI – Representa um Identificador Uniforme de Recurso (URI).",
				"|_ NET = URLConnection – Classe abstrata que representa uma conexão com um recurso.",
				"|_ NET = HttpURLConnection – Subclasse de URLConnection usada para conexões HTTP.",
				"|_ NET = JarURLConnection – Subclasse de URLConnection usada para arquivos JAR.", "|_ Sair" };

		int choice;
		do {
			// Exibindo o menu
			System.out.println("\n\t=== Import java.NET ===\n");
			for (int i = 0; i < menuOptions.length; i++) {
				System.out.println((i + 1) + ". " + menuOptions[i]);
			}

			System.out.print("Escolha uma opção do MENU: ");
			choice = scanner.nextInt();
			scanner.nextLine(); // Consumir o '\n'

			switch (choice) {
			case 1:
				Run_URL run_URL = new Run_URL();
				System.out.println(run_URL.Start_URL());

				pausar.run_Pause();
				clear.CleanConsole_Run();
				break;

			case 2:
				Run_URI run_URI = new Run_URI();
				System.out.println(run_URI.Start_URI());
				
				pausar.run_Pause();
				clear.CleanConsole_Run();
				break;

			case 3:
				Run_URLConnection run_URLConnection = new Run_URLConnection();
				System.out.println(run_URLConnection.Start_URLConnection());
				pausar.run_Pause();
				clear.CleanConsole_Run();
				break;

			case 4:
				pausar.run_Pause();
				clear.CleanConsole_Run();
				break;

			case 5:

				pausar.run_Pause();
				clear.CleanConsole_Run();
				break;

			case 6: // Sair
				System.out.println("Encerrando o programa...");
				break;

			default:
				System.out.println("Opção inválida. Tente novamente.");
				break;
			}
		} while (choice != 6);
		scanner.close();

	}
}
