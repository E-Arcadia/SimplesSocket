import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class PrincipalServer {

	public static void main(String[] args) throws IOException {

		ServerSocket server = new ServerSocket(12345);

		do {
			System.out.println("Aguardando nova conwxão.");
			Socket cliente = server.accept();
			new Atende(cliente).start();
//			Atende atende = new Atende(cliente);
//			atende.run();
		} while (true);

	}

}

class Atende extends Thread {
	private Socket cliente;

	public Atende(Socket cliente) {
		this.cliente = cliente;
	}

	@Override
	public void run() {

		String continuar = null;
		try {

			Scanner scanner = new Scanner(cliente.getInputStream());
			System.out.println("Aguardando mensagem!");
			String recebido;
			while (cliente.isConnected()) {
				recebido = scanner.nextLine();
				System.out.println(recebido);
			}

			System.out.println("Encerrou!!!");

//			while (scanner.hasNextLine() && continuar.equals("SAIR")) {
//				String recebido = scanner.nextLine();
//				System.out.println(recebido);
//			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}