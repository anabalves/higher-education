package atividade_17_05_2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class FakeHttpSocketServer {

	public static void main(String args[]) throws IOException {
		ServerSocket server = new ServerSocket(8080);
		System.out.println("Ouvindo porta 8080....");
		while (true) {
			try (Socket socket = server.accept()) {
				Date today = new Date();
				String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + today;
				socket.getOutputStream().write(httpResponse.getBytes("UTF-8"));
				InputStreamReader isr = new InputStreamReader(socket.getInputStream());
				BufferedReader reader = new BufferedReader(isr);
				String line = reader.readLine();
				while (!line.isEmpty()) {
					System.out.println(line);
					line = reader.readLine();
				}
			}
		}
	}
}
