package Prototype.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class VehiclesIF { 
   
    private static Map<String, VehicleInterface> vehicleMap = new HashMap<String, VehicleInterface>();  
       
    static 
    { 
        vehicleMap.put("ICE K4s", new TrainIF("ICE K4s", 15000, 920)); 
    } 
       
    public static VehicleInterface getVehicle(String vehicleName) {
    	if (null != vehicleMap.get(vehicleName)) {
    		return (VehicleInterface) vehicleMap.get(vehicleName).clone();
        } else {
        	System.out.println("Vehicle" + vehicleName + " is not supported!");
        	return (VehicleInterface) vehicleMap.get("Citaro").clone();
        }
    }
}
