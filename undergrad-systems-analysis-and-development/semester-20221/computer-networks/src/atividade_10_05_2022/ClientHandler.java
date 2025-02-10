package atividade_10_05_2022;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Base64;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;


public class ClientHandler implements Runnable {

	public static ArrayList<ClientHandler> clientHandlers = new ArrayList<>();
	private Socket socket;
	private BufferedReader bufferedReader;
	private BufferedWriter bufferedWriter;
	private String clientUsername;

	public ClientHandler(Socket socket) {
		try {
			this.socket = socket;
			this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			this.clientUsername = bufferedReader.readLine();
			clientHandlers.add(this);
			try {
				broadcastMessage("[SERVER] " + clientUsername + " entrou no chat!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			closeEverything(socket, bufferedReader, bufferedWriter);
		}
	}

	@Override
	public void run() {
		String messageFromClient;
		while (socket.isConnected()) {
			try {
				messageFromClient = bufferedReader.readLine();
				broadcastMessage(messageFromClient);
			} catch (IOException e) {
				closeEverything(socket, bufferedReader, bufferedWriter);
				break;
			}
		}
	}

	public void broadcastMessage(String messageToSend) {
		for (ClientHandler clientHandler : clientHandlers) {
			try {
				if (!clientHandler.clientUsername.equals(clientUsername)) {
					KeyGenerator keyGenerator = KeyGenerator.getInstance("ChaCha20");
					keyGenerator.init(256);
					SecretKey key = keyGenerator.generateKey();
					byte[] cipherText = EncryptDecrypt.encrypt(messageToSend.getBytes(), key);
					clientHandler.bufferedWriter.write("\n(enc): " + Base64.getEncoder().encodeToString(cipherText));
					String decryptedText = EncryptDecrypt.decrypt(cipherText, key);
					clientHandler.bufferedWriter.write("\n(dec): " + decryptedText + "\n");
					clientHandler.bufferedWriter.newLine();
					clientHandler.bufferedWriter.flush();
				}
			} catch (Exception e) {
				closeEverything(socket, bufferedReader, bufferedWriter);
			}
		}
	}

	public void removeClientHandler() {
		clientHandlers.remove(this);
		broadcastMessage("[SERVER] " + clientUsername + " saiu do chat!");
	}

	public void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
		removeClientHandler();
		try {
			if (bufferedReader != null) {
				bufferedReader.close();
			}
			if (bufferedWriter != null) {
				bufferedWriter.close();
			}
			if (socket != null) {
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
