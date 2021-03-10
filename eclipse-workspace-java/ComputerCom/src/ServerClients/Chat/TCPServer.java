/* ------------------
     TCPServer.java
   ------------------ */


/*  Computerkommunikation & Verteilte Systeme 2012/2013, Rene Pawlitzek, NTB  */


/*  Echo Server mit TCP und Message Serialisierung!  */


package ServerClients.Chat;


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class TCPServer {
	
	
	private final static int  port = 9876;
	
	
	public static void main (String argv[]) throws Exception {
	
		System.out.println ("TCPServer starting ...");
		
		// Server Socket für TCP-Kommunikation erzeugen, dieser Socket hört das Klopfen von Clients
		ServerSocket welcomeSocket = new ServerSocket (port);
		
		System.out.println ("TCPServer is ready to receive requests. Listening on port: " + port);		
		
		while (true) {  // Endlosschleife

			try {
			
				// Erzeuge einen NEUEN Socket, sobald ein Client anklopft
				Socket connectionSocket = welcomeSocket.accept ();
				
				// Input und Output Stream fuer Objekte aufsetzen
				ObjectInputStream inFromClient =                                     // !
					new ObjectInputStream (connectionSocket.getInputStream ());        // !
				ObjectOutputStream outToClient =                                     // !
					new ObjectOutputStream (connectionSocket.getOutputStream ());      // !
				
				// Direkte Verbindung zwischen Client und Server steht, lese Eingabe Message
				Message msg = (Message) inFromClient.readObject ();                  // !
				String text = msg.getText ();
				System.out.println ("Received: " + text);
				
				// empfangene Eingabe verarbeiten
				text = text.toUpperCase ();
				// Thread.sleep (5000); // simuliert eine lange Verarbeitung			
				
				// Antwort Message an Client schicken
				msg = new Message (text);
				outToClient.writeObject (msg);                                       // !
				System.out.println ("Sent: " + text);
			
			} catch (Exception e) {
        e.printStackTrace ();				
			} // try
			
		} // while	
	} // main
	
} // TCPServer


/* ----- End of File ----- */
