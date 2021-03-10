package ServerClients;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class QOTDClient {

	public static void main(String args[]) throws Exception {
		String pawlitzekIP = "146.136.112.22";
		int pawlitzekPort = 17;

		System.out.println("Starte Client... \n");
		String sentence;
		String quote = null;
		Socket clientSocket = new Socket(pawlitzekIP, pawlitzekPort);
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		sentence = "Send quote please";// inFromUser.readLine();
		outToServer.writeBytes(sentence + "\n");

        // Antwort von Server empfangen und ausgeben
		String tmp = inFromServer.readLine ();
		while(tmp != null) {
			System.out.println(tmp);
			inFromServer.readLine();
		}
		clientSocket.close();
		System.out.println("Beende Client... \n");
	}
}
