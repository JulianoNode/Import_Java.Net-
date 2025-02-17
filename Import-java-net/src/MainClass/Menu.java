package MainClass;

import java.util.Scanner;

import NET_01_URL.Run_URL;
import NET_02_URI.Run_URI;
import NET_03_URLConnection.Run_URLConnection;
import NET_04_HttpURLConnection.Run_HttpURLConnection;
import NET_05_JarURLConnection.Run_JarURLConnection;
import NET_06_Socket.Run_Socket;
import NET_07_ServerSocket.Run_ServerSocket;
import NET_08_DatagramSocket.Run_DatagramSocket;
import NET_09_MulticastSocket.Run_MulticastSocket;
import NET_10_SocketAddress.Run_SocketAddress;
import NET_11_InetSocketAddress.Run_InetSocketAddress;
import NET_12_InetAddress.Run_InetAddress;
import NET_13_Inet4Address.Run_Inet4Address;
import NET_14_Inet6Address.Run_Inet6Address;
import NET_15_Proxy.Run_Proxy;
import NET_16_ProxySelector.Run_ProxySelector;
import NET_17_CookieHandler.Run_CookieHandler;
import NET_18_CookieManager.Run_CookieManager;
import NET_19_CookieStore.Run_CookieStore;
import NET_20_Authenticator.Run_Authenticator;
import NET_21_PasswordAuthentication.Run_PasswordAuthentication;
import NET_22_URLEncoder.Run_URLEncoder;
import NET_23_URLDecoder.Run_URLDecoder;
import NET_24_NetworkInterface.Run_NetworkInterface;
import NET_25_SocketPermission.Run_SocketPermission;
import NET_26_DatagramPacket.Run_DatagramPacket;
import NET_28_ResponseCache.Run_ResponseCache;
import util.LimparConsole;
import util.Pausar;

public class Menu {
	public String Meun_Run() throws Exception {

		Pausar pausar = new Pausar();
		LimparConsole clear = new LimparConsole();
		Scanner scanner = new Scanner(System.in);

		// Vetor de opções do menu
		String[] menuOptions = {"\t📌 Manipulação de URLs \n\n" 
						+ "1.  👉 NET = URL – Representa um endereço de recurso na web.",
				" 👉 NET = URI – Representa um Identificador Uniforme de Recurso (URI).",
				" 👉 NET = URLConnection – Classe abstrata que representa uma conexão com um recurso.",
				" 👉 NET = HttpURLConnection – Subclasse de URLConnection usada para conexões HTTP. \n\n"
						+ "\t📌 Sockets (Comunicação de Rede) \n",
				" 👉 NET = JarURLConnection – Subclasse de URLConnection usada para arquivos JAR.",
				" 👉 NET = Socket – Representa um socket do cliente para comunicação com um servidor.",
				" 👉 NET = ServerSocket – Representa um socket do servidor que aceita conexões de clientes.",
				" 👉 NET = DatagramSocket – Representa um socket para comunicação usando o protocolo UDP.",
				" 👉 NET = MulticastSocket – Extensão de DatagramSocket usada para comunicação multicast.",
				"👉 NET = SocketAddress – Classe abstrata que representa um endereço de socket.",
				"👉 NET = InetSocketAddress – Representa um endereço IP e porta de conexão. \n\n"
						+ "\t📌 Endereços IP e DNS \n",
				"👉 NET = InetAddress – Representa um endereço IP (IPv4 ou IPv6).",
				"👉 NET = Inet4Address – Subclasse de InetAddress para endereços IPv4.",
				"👉 NET = Inet6Address – Subclasse de InetAddress para endereços IPv6. \n\n"
						+ "\t📌 Gerenciamento de Proxies e Cookies \n\n",
				"👉 NET = Proxy – Representa um servidor proxy.",
				"👉 NET = ProxySelector – Seletor que determina qual proxy deve ser usado para conexões.",
				"👉 NET = CookieHandler – Classe abstrata para manipulação de cookies.",
				"👉 NET = CookieManager – Implementação padrão de CookieHandler.",
				"👉 NET = CookieStore – Interface para armazenar cookies.",
				"👉 NET = Authenticator – Classe usada para fornecer autenticação ao acessar recursos protegido",
				"👉 NET = PasswordAuthentication – Contém credenciais de usuário (usuário e senha).\n\n"
						+ "\t📌 Codificação e Decodificação de URLs\n\n",
				"👉 NET = URLEncoder – Codifica strings para serem usadas em URLs.",
				"👉 NET = URLDecoder – Decodifica strings codificadas em URLs.\n\n"
						+ "\t📌 Classes para Serviços de Rede\n\n",
				"👉 NET = NetworkInterface – Representa uma interface de rede local.",
				"👉 NET = SocketPermission – Representa permissões para acessar sockets de rede.",
				"👉 NET = DatagramPacket – Representa um pacote de dados para comunicação UDP.",
				"👉 NET = ResponseCache – Classe abstrata para implementação de cache de respostas de rede.",
				"👉 NET = SecureCacheResponse – Resposta em cache para conexões seguras (HTTPS).\n\n"
						+ "\t📌 Lista Completa das Interfaces do java.net\n\n",
				"👉 NET = FileNameMap – Mapeia extensões de arquivos para tipos MIME.",
				"👉 NET = CookiePolicy – Define políticas para aceitação de cookies.",
				"👉 NET = CookieStore – Interface para armazenar cookies.",
				"👉 NET = ProtocolFamily – Representa uma família de protocolos de rede.\n\n"
						+ "\t📌 Lista Completa das Enumerações do java.net\n\n",
				"👉 NET = Proxy.Type – Define os tipos de proxy (DIRECT, HTTP, SOCKS).",
				"👉 NET = StandardProtocolFamily – Define famílias de protocolo (INET, INET6).",
				"👉 NET = StandardSocketOptions – Define opções padrão de sockets.\n",

				"  👋 Sair 👋 \n" };

		int choice;
		do {
			// Exibindo o menu
			System.out.println("\n\t=== 📌 Lista Completa das Classes do IMPORT JAVA.NET 📌===\n");
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
			case 12:
				Run_InetAddress address = new Run_InetAddress();
				System.out.println(address.Start_InetAddress());

				pausar.run_Pause();
				clear.CleanConsole_Run();
				break;
			case 13:
				Run_Inet4Address inet4Address = new Run_Inet4Address();
				System.out.println(inet4Address.Start_Inet4Address());

				pausar.run_Pause();
				clear.CleanConsole_Run();
				break;
			case 14:
				Run_Inet6Address inet6Address = new Run_Inet6Address();
				System.out.println(inet6Address.Start_Inet6Address());

				pausar.run_Pause();
				clear.CleanConsole_Run();
				break;
			case 15:
				Run_Proxy proxy = new Run_Proxy();
				System.out.println(proxy.Start_Proxy());

				pausar.run_Pause();
				clear.CleanConsole_Run();
				break;
			case 16:
				Run_ProxySelector proxySelector = new Run_ProxySelector();
				System.out.println(proxySelector.Start_ProxySelector());

				pausar.run_Pause();
				clear.CleanConsole_Run();
				break;
			case 17:
				Run_CookieHandler cookieHandler = new Run_CookieHandler();
				System.out.println(cookieHandler.Start_CookieHandler());

				pausar.run_Pause();
				clear.CleanConsole_Run();
				break;
			case 18:
				Run_CookieManager cookieManager = new Run_CookieManager();
				System.out.println(cookieManager.Start_CookieManager());

				pausar.run_Pause();
				clear.CleanConsole_Run();
				break;
			case 19:
				Run_CookieStore cookieStore = new Run_CookieStore();
				System.out.println(cookieStore.Start_CookieStore());

				pausar.run_Pause();
				clear.CleanConsole_Run();
				break;
			case 20:
				Run_Authenticator authenticator = new Run_Authenticator();
				System.out.println(authenticator.Start_Authenticator());

				pausar.run_Pause();
				clear.CleanConsole_Run();
				break;
			case 21:
				Run_PasswordAuthentication passwordAuthentication = new Run_PasswordAuthentication();
				System.out.println(passwordAuthentication.Start_PasswordAuthentication());

				pausar.run_Pause();
				clear.CleanConsole_Run();
				break;
			case 22:
				Run_URLEncoder urlEncoder = new Run_URLEncoder();
				System.out.println(urlEncoder.Start_URLEncoder());
				
				pausar.run_Pause();
				clear.CleanConsole_Run();
				break;

			case 23:
				Run_URLDecoder urlDecoder = new Run_URLDecoder();
				System.out.println(urlDecoder.Start_URLDecoder());
				
				pausar.run_Pause();
				clear.CleanConsole_Run();
				break;

			case 24:
				Run_NetworkInterface run_NetworkInterface = new Run_NetworkInterface();
				System.out.println(run_NetworkInterface.Start_NetworkInterface());
				
				pausar.run_Pause();
				clear.CleanConsole_Run();
				break;

			case 25:
				
				Run_SocketPermission socketPermission = new Run_SocketPermission();
				System.out.println(socketPermission.Start_SocketPermission());
				
				pausar.run_Pause();
				clear.CleanConsole_Run();
				break;

			case 26:
				Run_DatagramPacket run_DatagramPacket = new Run_DatagramPacket();
				System.out.println(run_DatagramPacket.Start_DatagramPacket());
				
				pausar.run_Pause();
				clear.CleanConsole_Run();
				break;

			case 27:
				Run_ResponseCache responseCache = new Run_ResponseCache();
				System.out.println(responseCache.Start_ResponseCache());
				
				pausar.run_Pause();
				clear.CleanConsole_Run();
				break;

			case 28:
				pausar.run_Pause();
				clear.CleanConsole_Run();
				break;

			case 29:
				pausar.run_Pause();
				clear.CleanConsole_Run();
				break;

			case 30:
				pausar.run_Pause();
				clear.CleanConsole_Run();
				break;

			case 31:
				pausar.run_Pause();
				clear.CleanConsole_Run();
				break;

			case 32:
				pausar.run_Pause();
				clear.CleanConsole_Run();
				break;

			case 33:
				pausar.run_Pause();
				clear.CleanConsole_Run();
				break;

			case 34:
				pausar.run_Pause();
				clear.CleanConsole_Run();
				break;

			case 35:
				pausar.run_Pause();
				clear.CleanConsole_Run();
				break;

				

			case 36: // Sair
				System.out.println("Encerrando o programa...");
				break;
			
			default:
				System.out.println("Opção inválida. Tente novamente.");
				break;
			}
		} while (choice != 36);
		scanner.close();

		return "";

	}

}
