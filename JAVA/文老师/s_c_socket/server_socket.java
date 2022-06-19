package chap2;

import java.io.*;
import java.net.*;

public class server_socket {
	public static final int PORT = 8080;

	public static void main(String[] args) throws IOException {
		ServerSocket s = new ServerSocket(PORT);
		System.out.println("Started: " + s);
		try {
			Socket socket = s.accept();
			try {
				System.out.println("Connection accepted: " + socket);
				BufferedReader in = new BufferedReader(new InputStreamReader(
						socket.getInputStream()));
				PrintWriter out = new PrintWriter(new BufferedWriter(
						new OutputStreamWriter(socket.getOutputStream())), true);
				int i = 0;
				while (i < 100) {
					i++;
					String str = in.readLine();
					if (str.equals("END"))
						break;
					System.out.println("Echoing: " + str);
					out.println(str + str + "haha");
				}
			} finally {
				System.out.println("closing...");
				socket.close();
			}
		} finally {
			s.close();
		}
	}
}
