package ServerClients;

import java.io.*;
import java.net.*;

public class TCPServer {

	public static void main(String[] args) throws Exception {
		String fromClient;
		String toClient;
		ServerSocket welcomeSocket = new ServerSocket(6789);
		System.out.println("Starte Server...");
		while(true) {
			Socket connectionSocket = welcomeSocket.accept();
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
			fromClient = inFromClient.readLine();
			toClient = "Internet ist Neuland. Willkommen.";
			outToClient.writeBytes(toClient);
		}
	}
}
