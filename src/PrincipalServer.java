import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class PrincipalServer {

	public static void main(String[] args) throws IOException {
//		Cria um serviço Socket
		ServerSocket server = new ServerSocket(12345);
//		Cria um canal de comunicação
		System.out.println("Antes do Accept");
		Socket cliente = server.accept(); //blocante
		System.out.println("Depois do Accept");
//		Recebe pacotes do cliente
		Scanner scanner = new Scanner(cliente.getInputStream()); 
		String recebido = scanner.nextLine();
		System.out.println(recebido);
	}

}
