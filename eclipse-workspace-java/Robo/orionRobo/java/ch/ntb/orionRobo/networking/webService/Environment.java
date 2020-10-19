package ch.ntb.orionRobo.networking.webService;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ch.ntb.orionRobo.RoboControl;
import ch.ntb.orionRobo.environmentRecognition.Field;
import ch.ntb.orionRobo.environmentRecognition.Point;




/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/move")
public class Environment {
	
	private static final Logger LOGGER = LogManager.getLogger(WebService.class.getName());
	
	
	static boolean running = false;
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
//    @GET
//    @Path("/field/{field}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Point[][] getField(@PathParam("field") Field field ) {
//			
//    	return RoboControl.field.getField();
//   	
//    }
    
    
}
