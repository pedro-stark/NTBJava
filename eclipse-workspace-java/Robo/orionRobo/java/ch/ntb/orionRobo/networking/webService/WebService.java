package ch.ntb.orionRobo.networking.webService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.server.StaticHttpHandler;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

/**
 * Main class.
 *
 */
public class WebService {


	
	private static final Logger LOGGER = LogManager.getLogger(WebService.class.getName());
	
    // Base URI the Grizzly HTTP server will listen on
    public static final String BASE_URI = "http://*/api/";
    // Static content path
    public static final String WWW_PATH = "./www/";
    
    private static HttpServer server = null;

    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this application.
     * @return Grizzly HTTP server.
     */
    public static void startServer() {
        // create a resource config that scans for JAX-RS resources and providers
        // in ch.ntb.orionRobo.networking.webService package
        final ResourceConfig rc = new ResourceConfig().packages("ch.ntb.orionRobo.networking.webService");

        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        StaticHttpHandler staticHttpHandler = new StaticHttpHandler(WWW_PATH);
        
        server = GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
        server.getServerConfiguration().addHttpHandler(staticHttpHandler, "/");
    }
    
    public static void stopServer() {
        if(server != null)
        {
        	server.shutdownNow();
        }
    }

    
	public void run() {
		
	}
    
    
    /**
     * Main method.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        startServer();
        System.out.println(String.format("Coilinator RESTAPI and WEB-UI Started"
                + "%sapplication.wadl\nHit enter to stop it...", BASE_URI));
        System.in.read();
       stopServer();
    }
}

