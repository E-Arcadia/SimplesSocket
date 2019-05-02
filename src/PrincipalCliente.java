import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class PrincipalCliente {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Scanner teclado = new Scanner(System.in);
		
		
//		Solicita uma conexão
		Socket cliente = new Socket("127.0.0.1", 12345);

//		Cria um canal de envio
		PrintStream saida = new PrintStream(cliente.getOutputStream());

//		Envia os pacotes
		while (teclado.hasNextLine()) {
				saida.println(teclado.nextLine());
			}

	}

}
