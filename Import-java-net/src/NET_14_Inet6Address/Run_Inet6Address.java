package NET_14_Inet6Address;

import java.util.Scanner;

import MainClass.Menu;
import util.LimparConsole;
import util.Pausar;
import util.VoutarMenu;

public class Run_Inet6Address {

	public String Start_Inet6Address() throws Exception {

		Pausar pausar = new Pausar();
		LimparConsole clear = new LimparConsole();
		Scanner scanner = new Scanner(System.in);

		// Vetor de opções do menu
		String[] menuOptions = { "|_ Inet6Address = Simple", "|_ Inet6Address = If e else if",
				"|_ Inet6Address = For com Matrix", "|_ Inet6Address = do while com Matrix", "|_ Inet6Address = Vetor",
				"|_ Voutar para o menu"};

		int choice;
		do {
			// Exibindo o menu
			System.out.println("\n\t=== Import java.net.Inet6Address ===\n");
			for (int i = 0; i < menuOptions.length; i++) {
				System.out.println((i + 1) + ". " + menuOptions[i]);
			}

			System.out.print("Escolha uma opção: ");
			choice = scanner.nextInt();
			scanner.nextLine(); // Consumir o '\n'

			switch (choice) {
			case 1:
				Simples simples = new Simples();
				System.out.println(simples.Simples_Run());

				pausar.run_Pause();
				clear.CleanConsole_Run();
				break;

			case 2:
				If_Else_IF else_IF = new If_Else_IF();
				System.out.println(else_IF.If_Else_IF_Run());

				pausar.run_Pause();
				clear.CleanConsole_Run();
				break;

			case 3:
				For_Matrix for_Matrix = new For_Matrix();
				System.out.println(for_Matrix.matrix_Run());

				pausar.run_Pause();
				clear.CleanConsole_Run();
				break;

			case 4:
				While_Matrix matrix = new While_Matrix();
				System.out.println(matrix.VetorMatrix_Run());

				pausar.run_Pause();
				clear.CleanConsole_Run();
				break;

			case 5:
				Vetor_ vetor_ = new Vetor_();
				System.out.println(vetor_.VetorMatrix_Run());

				pausar.run_Pause();
				clear.CleanConsole_Run();
				break;

			case 6: // Voutar para o MEUNU
				VoutarMenu voutarMenu = new VoutarMenu();
				voutarMenu.run_CaracteresMenu_Red();
				System.out.println("\n\n");
				Menu menu = new Menu();
				menu.Meun_Run();

				break;

			case 7: // Sair
				System.out.println("Encerrando o programa...");
				break;

			default:
				System.out.println("Opção inválida. Tente novamente.");
				break;
			}
		} while (choice != 7);
		scanner.close();
		return "";
	}
}
