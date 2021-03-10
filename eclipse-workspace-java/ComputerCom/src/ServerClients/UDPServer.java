package ServerClients;

import java.io.*;
import java.net.*;

public class UDPServer {

	public static void main(String[] args) throws Exception{
		DatagramSocket serverSocket = new DatagramSocket(9876);
		byte[] receiveData = new byte[1024];
		byte[] sendData = new byte[1024];
		System.out.println("Starte Server...");
		while(true) {
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			serverSocket.receive(receivePacket);
			String sentence = new String(receivePacket.getData());
			System.out.println("From client: " + sentence);
			InetAddress IPAddress = receivePacket.getAddress();
			int port = receivePacket.getPort();
			//String capitalizedSentence = sentence.toUpperCase();
			String sendString = "Deine IP: " + IPAddress.toString() + ", Deine Nachricht: " + sentence;
			System.out.println("To client: " + sendString);
			sendData = sendString.getBytes(); //capitalizedSentence.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
			serverSocket.send(sendPacket);
		}
	}

}
