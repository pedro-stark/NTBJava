package ServerClients;

import java.io.*;
import java.net.*;

public class UDPClient {

	private DatagramSocket socket;
	private InetAddress address;
	private byte[] buffer;

	public UDPClient() {
	}

	public static void main(String args[]) throws Exception{
		String pawlitzekIP = "146.136.112.65"; int pawlitzekPort = 9876;
		String alaliIP = "146.136.112.20"; int alaliPort = 4444;
		
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		DatagramSocket clientSocket = new DatagramSocket();
		int port = alaliPort;
		InetAddress IPAddress = InetAddress.getByName(alaliIP);
		byte[] sendData = new byte[1024];
		byte[] receiveData = new byte[1024];
		String sentence = "Hallo?";//inFromUser.readLine();
		sendData = sentence.getBytes();
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
		clientSocket.send(sendPacket);
		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
		clientSocket.receive(receivePacket);
		String modifiedSentence = new String(receivePacket.getData());
		System.out.println("FROM SERVER:" + modifiedSentence);
		clientSocket.close();
	}
}