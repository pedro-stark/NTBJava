/* -----------------
     Dispatch.java
   ----------------- */ 


/*  Computerkommunikation & Verteilte Systeme 2012/2013, Rene Pawlitzek, NTB  */


package SimpleChatClient;


import java.net.InetAddress;
import java.net.Socket;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;

public class Dispatch implements Runnable {

	
	private  Socket                     socket;
	private  ServersideCommunication    communication;
	private  Hashtable<String,Socket>   clients;
	
	
	public Dispatch (Socket socket, Hashtable<String, Socket> clients) throws Exception {
		this.socket = socket;
		this.clients = clients;
		this.communication = new ServersideCommunication (socket);
	} // Dispatch 
	

	public void run () {
		try {
			while (true) {

        // read message
				Message message = communication.getMessage ();
				System.out.println ("Reveived message: " + message.toString ());
				
				// dispatch message
				int cmd = message.getCommand ();
				if (cmd == Message.Posting) {

					// send message to all clients
					broadcastMessage (communication, message);

				} else if (cmd == Message.Register) {

					// register client
					clients.put (message.getUser (), socket);
					System.out.println ("Registered client: " + message.getUser ());

				} else if (cmd == Message.Unregister) {

					// unregister client
					clients.remove (message.getUser ());
					System.out.println ("Unregistered client: " + message.getUser ());

				} // if
				
			} // while
		} catch (Exception e) {
			// e.printStackTrace ();
		} // try
		// communication.close ();
		System.out.println ("Thread finished");
	} // run
	
	
	private void broadcastMessage (ServersideCommunication communication, Message message) throws Exception {
		System.out.println ("Number of client: " + clients.values ().size ());
		Collection<Socket> sockets = clients.values ();
		Iterator<Socket> iter = sockets.iterator ();
		while (iter.hasNext ()) {
			Socket socket = iter.next ();
			communication.sendMessage (message, socket);				
			InetAddress client = socket.getInetAddress ();
			System.out.println ("Posted message to " + client.getHostName ());
		} // for
	} // broadcastMessage	
	
	
} // Dispatch


/* ----- End of File ----- */