package Chat;

import java.net.*;
import java.util.*;

public class ExtendedChatServer {

    private static final int PORT = 5555;

    private  InetSocketAddress              socketAddress;
    private  Map<User, InetSocketAddress>   clients;

    private  Communication                  communication;  // this object enables client/server communication

    private ExtendedChatServer() throws Exception {

        // add shutdown hook
        Thread shutdown = new Thread() {
                public void run () {
                    System.out.println ("Closing communication ...");
                    if (communication != null) {
                        communication.close ();
                    }
                    System.out.println ("Communication closed.");
                }
            };            // shutdown thread
        Runtime.getRuntime().addShutdownHook(shutdown);

        System.out.println ("ExtendedChatServer starting...");
        InetAddress localhost = InetAddress.getLocalHost ();
		System.out.println ("IP Address: " + localhost + ", Port: " + PORT);

        communication = new Communication ();  // this object enables client/server communication
        clients = new TreeMap<User, InetSocketAddress> ();

        try {
            // open the communication channel
            communication.open(PORT);
            while (true) {

                // Wait to receive a datagram, blocking call
                System.out.println ("Waiting for message...");
                System.out.println ();
                communication.waitForMessage ();
                System.out.println ("Received message");
                // datagram was received, read message and socket address
                Message message = communication.getMessage ();
                socketAddress = (InetSocketAddress) communication.getSocketAddress ();

                System.out.println("Message: " + message);

                // check type of message
                if (message instanceof PostingMessage) {
                    // send posting to all clients
                    PostingMessage p = (PostingMessage) message;
                    System.out.println("Posting: " + p.getText());
                    broadcastPosting (p);
                } else if (message instanceof RegisterMessage) {
                    // register client
                    RegisterMessage r = (RegisterMessage) message;
                    clients.put (r.getUser(), socketAddress);
                    System.out.println ("Registered client: " + r.getUser());
                    System.out.println ("Clients: " + clients);
                    // broadcast user set
                    TreeSet<User> userSet = new TreeSet<User>(clients.keySet());
                    broadcastUserSet (userSet);
                } else if (message instanceof UnregisterMessage) {
                    // unregister client
                    UnregisterMessage u = (UnregisterMessage) message;
                    User user = u.getUser();
                    if (socketAddress.equals(clients.get(user))) {
                    // if (clients.get(user).equals(socketAddress)) {
                      clients.remove (user);
                      System.out.println ("Unregistered client: " + u.getUser());
                      System.out.println ("Clients: " + clients);
                      // broadcast user set
                      TreeSet<User> userSet = new TreeSet<User>(clients.keySet());
                      broadcastUserSet (userSet);
                    } // if
                } else {
                    System.out.println ("Unknown message received!");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } 

    }
    
    
    private void broadcastPosting (PostingMessage message) {
        // forward each message to all clients
        System.out.println ("broadcast posting");
        for (User client : clients.keySet()) {
            InetSocketAddress address = clients.get(client);
            communication.sendMessage (address, message); 
            System.out.println ("Forwarding message to " + client.getName() + " at " + address.getHostName() + "/" + address.getPort());
        }        
    } 
    
    
    private void broadcastUserSet (TreeSet<User> userSet) {
        System.out.println ("broadcast user set");
        for (User client : clients.keySet()) {
            InetSocketAddress address = clients.get(client);
            communication.sendMessage (address, new UserSetMessage(userSet)); 
            System.out.println ("Send current user set " + userSet + " to " + client.getName() + " at " + address.getHostName() + "/" + address.getPort());
        }        
    }
    

    public static void main (String[] args) {
        try {
          new ExtendedChatServer ();
        } catch (Exception e) {
          e.printStackTrace();
        }
    } 

} 