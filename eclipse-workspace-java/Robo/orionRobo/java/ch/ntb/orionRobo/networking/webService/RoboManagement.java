package ch.ntb.orionRobo.networking.webService;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ch.ntb.orionRobo.RoboControl;
import ch.ntb.orionRobo.networking.webService.datatypes.Status;




/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/robo")
public class RoboManagement {
	
	private static final Logger LOGGER = LogManager.getLogger(WebService.class.getName());
	
	static int counter = 0;
	static boolean running = false;
    /**
     * Start AutonomouslyMode
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Path("/start")
    @Produces(MediaType.TEXT_PLAIN)
    public String start( ) {
    	{
    		if(!RoboControl.isRunningAutonomously()) {
    			RoboControl.roboControl.startAutonomouslyMode();
    			return "running";
    		}
    		
    		return "is already running";
    	}
    }
    
    /**
     * Stop AutonomouslyMode
     * 
     * @return
     */
    @GET
    @Path("/stop")
    @Produces(MediaType.TEXT_PLAIN)
    public String stop() {
    	{
    		if(RoboControl.isRunningAutonomously()) {
    			RoboControl.roboControl.stopAutonomouslyMode();
    			return "stopped";
    		}
    		
    		return "is already stopped";
    	}
    }
    
    /**
     *  Reboot raspberry pi
     * @return
     */
    @GET
    @Path("/reboot")
    @Produces(MediaType.TEXT_PLAIN)
    public String reboot() {
    	{
    		try {
				Runtime.getRuntime().exec("reboot");
			} catch (IOException e) {
				LOGGER.error(e);
			}
    		return "is rebooting";
    	}
    }
    
    /**
     *  Emergency kill, Kill the application and reset GPIO. Service will be automatically restarted
     * @return
     */
    @GET
    @Path("/kill")
    @Produces(MediaType.TEXT_PLAIN)
    public String kill() {
    	{
    		RoboControl.killRunningProcess();
    		return "process killed";
    	}
    }
    
    
    
    /**
     * Get Status back of Coilinator
     * 
     * @return
     */
    @GET
    @Path("/status")
    @Produces(MediaType.APPLICATION_JSON)
    public Status status() {
    	{
    		Status status = new Status();
    		status.status= RoboControl.robo.getStatus().name();
    		status.partnerStatus = RoboControl.partnerRobo.getStatus().name();
    		status.condensator = RoboControl.voiceCoil.isCapacitorLoading();
    		status.partnerPosition = RoboControl.partnerRobo.getPosition();
    		status.position = RoboControl.robo.getPosition();
    		status.partnerConnected = RoboControl.partnerCom.isPartnerConnected();
    		status.autonomous = RoboControl.isRunningAutonomously();
    		status.hasBall = RoboControl.voiceCoil.hasBall();
    		return status;
    	}
    }
    
}
