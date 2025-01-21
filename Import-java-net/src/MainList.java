
import java.util.Scanner;

import NET_DatagramSocket.Run_DatagramSocket;
import NET_HttpURLConnection.Run_HttpURLConnection;
import NET_InetSocketAddress.Run_InetSocketAddress;
import NET_JarURLConnection.Run_JarURLConnection;
import NET_MulticastSocket.Run_MulticastSocket;
import NET_ServerSocket.Run_ServerSocket;
import NET_Socket.Run_Socket;
import NET_SocketAddress.Run_SocketAddress;
import NET_URI.Run_URI;
import NET_URL.Run_URL;
import NET_URLConnection.Run_URLConnection;
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
				"|_ NET = JarURLConnection – Subclasse de URLConnection usada para arquivos JAR.",
				"|_ NET = Socket – Representa um socket do cliente para comunicação com um servidor.",
				"|_ NET = ServerSocket – Representa um socket do servidor que aceita conexões de clientes.",
				"|_ NET = DatagramSocket – Representa um socket para comunicação usando o protocolo UDP.",
				"|_ NET = MulticastSocket – Extensão de DatagramSocket usada para comunicação multicast.",
				"|_ NET = SocketAddress – Classe abstrata que representa um endereço de socket.",
				"|_ NET = InetSocketAddress – Representa um endereço IP e porta de conexão.", "", "", "", "", "", "",
				"", "",

				"|_ Sair" };

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
				Run_URLConnection connection = new Run_URLConnection();
				System.out.println(connection.Start_URLConnection());

				pausar.run_Pause();
				clear.CleanConsole_Run();
				break;

			case 4:
				Run_HttpURLConnection httpURLConnection = new Run_HttpURLConnection();
				System.out.println(httpURLConnection.Start_HttpURLConnection());

				pausar.run_Pause();
				clear.CleanConsole_Run();
				break;

			case 5:
				Run_JarURLConnection jarURLConnection = new Run_JarURLConnection();
				System.out.println(jarURLConnection.Start_JarURLConnectoin());

				pausar.run_Pause();
				clear.CleanConsole_Run();
				break;

			case 6:
				Run_Socket run_Socket = new Run_Socket();
				System.out.println(run_Socket.Start_Socket());

				pausar.run_Pause();
				clear.CleanConsole_Run();
				break;
			case 7:
				Run_ServerSocket serverSocket = new Run_ServerSocket();
				System.out.println(serverSocket.Start_ServerSocket());

				pausar.run_Pause();
				clear.CleanConsole_Run();
				break;
			case 8:
				Run_DatagramSocket datagramSocket = new Run_DatagramSocket();
				System.out.println(datagramSocket.Start_DatagramSocket());

				pausar.run_Pause();
				clear.CleanConsole_Run();
				break;
			case 9:
				Run_MulticastSocket multicastSocket = new Run_MulticastSocket();
				System.out.println(multicastSocket.Start_MulticastSocket());

				pausar.run_Pause();
				clear.CleanConsole_Run();
				break;
			case 10:
				Run_SocketAddress socketAddress = new Run_SocketAddress();
				System.out.println(socketAddress.Start_SocketAddress());

				pausar.run_Pause();
				clear.CleanConsole_Run();
				break;
			case 11:
				Run_InetSocketAddress inetSocketAddress = new Run_InetSocketAddress();
				System.out.println(inetSocketAddress.Start_InetSocketAddress());

				pausar.run_Pause();
				clear.CleanConsole_Run();
				break;

			case 12: // Sair
				System.out.println("Encerrando o programa...");
				break;

			default:
				System.out.println("Opção inválida. Tente novamente.");
				break;
			}
		} while (choice != 12);
		scanner.close();

	}

}
