/* ----------------------------
     HttpServletResponse.java
   ---------------------------- */


/*  Computerkommunikation & Verteilte Systeme 2012/2013, Rene Pawlitzek, NTB  */


package SimpleServletEngine.Loesung;


import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.Socket;


public class HttpServletResponse {
	
	
	// this class handles the http response (output)
	
	
	private static final String  CRLF = "\r\n";	
	

	private  PrintWriter       printWriter;
	private  StringWriter      output;
	private  DataOutputStream  os;
	
	
	public HttpServletResponse (Socket socket) throws IOException {
		
		// setup the output stream to write the output to
  	os = new DataOutputStream (socket.getOutputStream ());
  	// output from the servlet is collected with a string writer
  	output = new StringWriter ();
  	printWriter = new PrintWriter (output);
  	// return the http status code
  	String statusLine = "HTTP/1.0 200 OK";
  	os.writeBytes (statusLine);
  	
	} // HttpServletResponse
	
	
	public PrintWriter getWriter () {
		// return a print writer to allow the servlet to produce the output
		return printWriter;
	} // getWriter
	
	
	public void setContentType (String contentType) throws IOException {
		// add the content type to the response 
  	String contentTypeLine = "Content-type: " + contentType + CRLF;
  	os.writeBytes (contentTypeLine);
  	os.writeBytes (CRLF);
	} // setContentType


	public void sendError () throws IOException {
		// produce an html error message
  	String contentTypeLine = "Content-type: text/html" + CRLF;
  	os.writeBytes (contentTypeLine);
  	os.writeBytes (CRLF);
  	printWriter.print ("<HTML><HEAD><TITLE>Servlet Not Found</TITLE></HEAD><BODY>Servlet Not Found</BODY></HTML>");
	} // sendError
	
	
	public void close () {
		if (os != null) { 
			try { 
				System.out.println ("Output: " + output.toString ());
				// add the collected servlet output to the response 
				os.writeBytes (output.toString ());
				os.flush ();
				os.close (); 
			} catch (Exception e) { 
			} // try
		} // if
	} // close
	
	
} // HttpServletResponse


/* ----- End of File ----- */
