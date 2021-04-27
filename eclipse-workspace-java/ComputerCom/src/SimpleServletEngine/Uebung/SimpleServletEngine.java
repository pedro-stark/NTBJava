/* ----------------------------
     SimpleServletEngine.java
   ---------------------------- */

/*  Computerkommunikation & Verteilte Systeme 2012/2013, Rene Pawlitzek, NTB  */

/*  
    The simple servlet engine enables the creation of dynamic web pages.    
    Usage:  http://localhost:8080/HelloWorldServlet 
*/


package SimpleServletEngine.Uebung;

import java.net.*;

public class SimpleServletEngine {
	
	
	private final static int  port = 8080;   //  server port
	
	
	public static void main (String argv[]) throws Exception {
		
		System.out.println ("Simple Servlet Engine starting ...");
		// create the listening port
		ServerSocket welcomeSocket = new ServerSocket (port);
		System.out.println ("Simple Servlet Engine is ready to receive requests. Listening on port: " + port);	
		
		while (true) {
			
			// accept a connection
			Socket connectionSocket = welcomeSocket.accept ();
			// create a HttpRequest object to represent the request
			HttpRequest request = new HttpRequest (connectionSocket);
			// create a new thread to process the request
			Thread thread = new Thread (request);
			// start the thread to process the request
			thread.start ();
			
		} // while
	} // main

	
} // SimpleServletEngine


/* ----- End of File ----- */
