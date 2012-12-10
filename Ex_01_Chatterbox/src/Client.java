import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
	Scanner sc;
	Socket socket;
	PrintWriter pw;
	
	public Client(String host, int port) {
		try {
			socket = new Socket(host, port);
			pw = new PrintWriter(socket.getOutputStream(), true);
			
			write();
		}catch(IOException io) {
			System.out.println("Connection failed..");
		}
	}
	
	public void write() {
		sc = new Scanner(System.in);
		String text = sc.nextLine();
		pw.println(text);
	}
}