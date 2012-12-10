import java.io.*;
import java.net.*;

public class Server {
	BufferedReader br;
	ServerSocket ss;
	Socket socket;

	public Server(int port) {
		try {
			ss = new ServerSocket(port);
		} catch (IOException io) {}
		listen();
	}

	public static void main(String[] args) {
		new Server(1050);
		//new Client("127.0.0.1", 1049);
	}

	public void listen() {
		try {
			socket = ss.accept();
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			String listen = br.readLine();
			System.out.println(listen);
			socket.close();
			ss.close();
		} catch (IOException io) {}
	}
}