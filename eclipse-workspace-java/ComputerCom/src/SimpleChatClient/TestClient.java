package SimpleChatClient;

public class TestClient {

	
	public static void main (String[] args) {
		ClientsideCommunication communication = new ClientsideCommunication ();
		
		communication.open ("localhost", 5555);
		System.out.println ("Sending messages...");
		Message msg = new Message (Message.Posting, "rpa", "test");
		System.out.println ("Sending message: " + msg.toString ());
		communication.sendMessage (msg);
		Message rmsg = communication.getMessage ();
		System.out.println ("Return message: " + rmsg.toString ());
		// communication.close ();
		
		// communication.open ("localhost", 5555);
		Message msg2 = new Message (Message.Posting, "rpa", "test2");
		System.out.println ("Sending message: " + msg.toString ()); 
		communication.sendMessage (msg2);
		rmsg = communication.getMessage ();
		System.out.println ("Return message: " + rmsg.toString ());
		System.out.println ("Done.");
		communication.close ();
		
	} // main

} // TestClient
