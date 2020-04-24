import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class PrincipalCliente {
	public static void main(String[] args) throws UnknownHostException, IOException {

		Scanner teclado = new Scanner(System.in);

		Socket cliente = new Socket("127.0.0.1", 12345);
		PrintStream saida = new PrintStream(cliente.getOutputStream());

		String enviar = null;
		while (teclado.hasNextLine() && enviar.equals("SAIR")) {
			enviar = teclado.nextLine();
			saida.println(enviar);
		}

	}

}
