/* -----------------------------
     VerySimpleWebBrowser.java
   ----------------------------- */


/*  Computerkommunikation & Verteilte Systeme 2012/2013, Rene Pawlitzek, NTB  */


package SimpleWebBrowser;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class VerySimpleWebBrowser {

	
	private static final int  HTTP_PORT = 80;
	

	private  int     port     = HTTP_PORT;
	private  String  hostName = "localhost";
	private  String  page     = "/index.html";
	
	
	public int getPort () {
		return port;
	} // getPort


	public void setPort (int port) {
		this.port = port;
	} // setPort


	public String getHostName () {
		return hostName;
	} // getHostName


	public void setHostName (String hostName) {
		this.hostName = hostName;
	} // setHostName


	public String getPage () {
		return page;
	} // getPage


	public void setPage (String page) {
		this.page = page;
	}	// setPage
	
	
	public void displayPage () throws Exception {
		
		// create a TCP socket
		Socket clientSocket = new Socket (hostName, port);
		
		// send the request for the page
		PrintWriter out = new PrintWriter (clientSocket.getOutputStream ());
		String request = "GET " + page + " HTTP/1.1\r\nHost: " + hostName + "\r\n\r\n";  // don't forget host!!!
		System.out.println (request);
		out.print (request);
		out.flush ();
		
		// receive and display the page
		BufferedReader in = new BufferedReader (new InputStreamReader (clientSocket.getInputStream ()));
		String line = in.readLine ();
		while (line != null) {
			System.out.println (line);
			line = in.readLine ();
		} // while
		
		out.close ();
		in.close ();
		clientSocket.close ();
		
	} // displayPage
	
	
	public static void main (String[] args) {
		try {
		  VerySimpleWebBrowser webBrowser = new VerySimpleWebBrowser ();
		  webBrowser.setHostName ("www.ntb.ch");
		  webBrowser.setPort (HTTP_PORT);
		  webBrowser.setPage ("/ntb-homepage.html");
		  webBrowser.displayPage ();
		} catch (Exception e) {
			e.printStackTrace ();
		} // try
	} // main

	
} // VerySimpleWebBrowser


/* ----- End of File ----- */
