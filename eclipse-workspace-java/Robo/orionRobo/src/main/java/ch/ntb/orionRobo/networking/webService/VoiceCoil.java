/**
ü¨
 * NTB Systemtechnikprojekt Team 7
 *
 * File: ch.ntb.orionRobo.networking.webService.VoiceCoil.java
 * 
 * @author Basile Schoeb <basile.schoeb@ntb.ch>
 * 
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 * Copyright (c) 2018 NTB Systemtechnikprojekt Team 7
 */
package ch.ntb.orionRobo.networking.webService;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ch.ntb.orionRobo.RoboControl;
import ch.ntb.orionRobo.environmentRecognition.Point;
import ch.ntb.orionRobo.networking.webService.datatypes.CalibrationValues;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/voicecoil")
public class VoiceCoil {
	
	private static final Logger LOGGER = LogManager.getLogger(WebService.class.getName());
	
	static boolean running = false;
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Path("/shoot/{distance}")
    @Produces(MediaType.TEXT_PLAIN)
    public String shootDistance(@PathParam("distance") long distance ) {
    	
    		
    			running = true;
    			//long distance = Long.parseLong(s_distance);
    			RoboControl.voiceCoil.shootDistance(distance);
    			running = false;
    			return "Done";
    	
    }
    
    @GET
    @Path("/shoot/{xCoordinate}/{yCoordinate}")
    @Produces(MediaType.TEXT_PLAIN)
    public String shootToPoint(@PathParam("xCoordinate") int xCoordinate, @PathParam("yCoordinate") int yCoordinate) {
    	{
    		if(!running) {
    			running = true;
    			LOGGER.info("Shoot - Shoot to position:  x:"+ xCoordinate + " y:" + yCoordinate);
    			Point point = new Point(xCoordinate, yCoordinate);
    			RoboControl.voiceCoil.shootToPoint(point);
    			running = false;
    			return "Shoot to position:  x:" + xCoordinate + " y:" + yCoordinate;
    		}
    		
    		return "Bussy";
    	}
    }
    
    
    @GET
    @Path("/calibrate")
    @Produces(MediaType.APPLICATION_JSON)
    public CalibrationValues getTimes() {
    	{
    		if(!running) {
    			running = true;
    			long [] time = {3000000, 3500000, 4000000, 5000000,6000000,7000000,8000000,9000000, 10000000};
    			long [] dis = {0,0,0,0,0, 0, 0 , 0 ,0  };
    			RoboControl.voiceCoil.calibrate(time);
    			running = false;
    			return new CalibrationValues(time,dis)  ;
    		}
    		return new CalibrationValues();//null;
    	}
    }
    
    @GET
    @Path("/charging/{status}")
    @Produces(MediaType.TEXT_PLAIN)
    public String setCharging(@PathParam("status") String status) {
    	{
    		if(status.equals("enable"))
    		{
    			RoboControl.voiceCoil.charge(true);
        		return "Loading capacitor: enabled";
    		}
    		else if(status.equals("disable")) {
    			RoboControl.voiceCoil.charge(false);
        		return "Loading capacitor: disabled";
    		}else {
    			return "Parameter unknown";
    		}

    	}
    }
    
    
    @POST
    @Path("/calibrate")
    @Produces(MediaType.TEXT_PLAIN)
    public String postDistances(CalibrationValues cal) throws IOException {
    	{
    			try {
    			RoboControl.prop.setProperty("voicecoilCalibrationTimes", Arrays.toString(cal.getTimes()));
    			RoboControl.prop.setProperty("voicecoilCalibrationDistances", Arrays.toString(cal.getDistances()));
    			RoboControl.prop.store(new FileOutputStream("config.properties"), null);
    			RoboControl.voiceCoil.setCalibrationValue(cal.getTimes(), cal.getDistances());
    		    return "Calibration saved and loaded";
    			}catch(Exception ex)
    			{
    				return "Error: " + ex.getMessage();
    			}
    			
    			
    			

    	}
    }
}