/* -------------------------
     SimpleChatServer.java 
   ------------------------- */


/*  Computerkommunikation & Verteilte Systeme 2012/2013, Rene Pawlitzek, NTB  */


package SimpleChatClient;


import java.net.*;
import java.util.Hashtable;


public class SimpleChatServer {

	
	private static final int PORT = 5555;

	
	private  Hashtable<String, Socket>  clients;
	
	
	private SimpleChatServer() {
		
		System.out.println ("SimpleChatServer starting...");
		
		// create a map of clients, key is username, value is socket
		clients = new Hashtable<String, Socket> ();

		try {
			// create server socket
      ServerSocket welcomeSocket = new ServerSocket (PORT);
			while (true) {
				
				// Wait for a client, blocking call
				System.out.println ("Waiting for message...");
				Socket socket = welcomeSocket.accept ();

				// Dispatch the request using a thread
				Dispatch dispatch = new Dispatch (socket, clients);
				Thread thread = new Thread (dispatch);
				thread.start ();
				
			} // while  
		} catch (Exception e) {
			e.printStackTrace();
		} // try
		
	} // SimpleChatServer

	
	public static void main (String[] args) {
		new SimpleChatServer ();
	} // main
	
	
} // SimpleChatServer


/* ---- End of File ----- */