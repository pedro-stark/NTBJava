package ch.ntb.orionRobo.networking.webService;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ch.ntb.orionRobo.RoboControl;
import ch.ntb.orionRobo.environmentRecognition.Point;




/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/move")
public class Move {
	
	private static final Logger LOGGER = LogManager.getLogger(WebService.class.getName());
	
	
	static boolean running = false;
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Path("/goDistance/{distance}")
    @Produces(MediaType.TEXT_PLAIN)
    public String goSteps(@PathParam("distance") Long distance ) {
    	{
    		if(!running) {
    			running = true;
    			//long n_steps = Long.parseLong(distance);
    			LOGGER.info("Move - DriveStraight: "+ distance + " mm" );
    			RoboControl.drive.driveStraight(distance);
    			running = false;
    			return "straight ahead " + distance + " mm";
    		}
    		
    		return "Bussy";
    	}
    }
    
    
    @GET
    @Path("/goPosition/{xCoordinate}/{yCoordinate}")
    @Produces(MediaType.TEXT_PLAIN)
    public String goToPosition(@PathParam("xCoordinate") int xCoordinate, @PathParam("yCoordinate") int yCoordinate ) {
    	{
    		if(!running) {
    			running = true;
    			//long n_steps = Long.parseLong(distance);
    			LOGGER.info("Move - Drive to position:  x:"+ xCoordinate + " y:" + yCoordinate);
    			Point point = new Point(xCoordinate, yCoordinate);
    			RoboControl.drive.goToPosition(point);
    			running = false;
    			return "Navigated to position:  x:" + xCoordinate + " y:" + yCoordinate;
    		}
    		
    		return "Bussy";
    	}
    }
    
    @GET
    @Path("/goTurn/{degree}")
    @Produces(MediaType.TEXT_PLAIN)
    public String turn(@PathParam("degree") double degree ) {
    	{
    		if(!running) {
    			running = true;
    			//Float n_degree = Float.parseFloat(degree);
    			LOGGER.info("Move - Turn: "+ String.format("%.2f", degree) );
    			RoboControl.drive.turn(degree);
    			running = false;
    			return "rotate for " + String.format("%.2f", degree) ;
    		}
    		
    		return "Bussy";
    	}
    }
    
    
}
