package ServerClients;

import java.io.*;
import java.net.*;

public class TCPClient {

	public static void main(String args[]) throws Exception {
		String pawlitzekIP = "146.136.112.65"; int pawlitzekPort = 9876;
		String philIP = "146.136.112.99"; int philPort = 9877;
		String alaliIP = "146.136.112.20"; int alaliPort = 4444;
		
		System.out.println("Starte Client");
		String sentence;
		String modifiedSentence;
		//BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		Socket clientSocket = new Socket(philIP, philPort);
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		sentence = "Din neue Hackername: Phil-IP";//inFromUser.readLine();
		outToServer.writeBytes(sentence + "\n");
		modifiedSentence = inFromServer.readLine();
		System.out.println("FROM SERVER: " + modifiedSentence);
		clientSocket.close();
		System.out.println("Beende Client");
	}

}
