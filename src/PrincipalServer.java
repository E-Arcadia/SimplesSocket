import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class PrincipalServer {

	public static void main(String[] args) throws IOException {

		ServerSocket server = new ServerSocket(12345);
		
		System.out.println("Antes do Accept");
		Socket cliente = server.accept(); // blocante

		Scanner scanner = new Scanner(cliente.getInputStream());

		while (!cliente.isClosed()) {
			try {

				String recebido = scanner.nextLine();
				if (recebido.equals("sair")) {
					cliente.close();
				}

				System.out.println(recebido);
				
			} catch (NoSuchElementException e) {
				System.out.println("Erro de conexão - Cliente desconectou inesperadamente!!!");
				cliente.close();
			}

		}
		System.out.println("Servidor encerrado.");
	}

}
