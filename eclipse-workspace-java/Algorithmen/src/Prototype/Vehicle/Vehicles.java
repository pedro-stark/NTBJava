package Prototype.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class Vehicles { 
   
    private static Map<String, Vehicle> vehicleMap = new HashMap<String, Vehicle>();  
       
    static 
    { 
        vehicleMap.put("Clio", new Car("Clio", 100, 4));
        vehicleMap.put("C_Two", new Car("C_Two", 1914, 2));
        vehicleMap.put("Citaro", new Bus("Citaro", 299, 50));
        vehicleMap.put("A320", new Plane("A320", 50000, 195)); 
        vehicleMap.put("ICE K4s", new Train("ICE K4s", 15000, 920)); 
    } 
       
    public static Vehicle getVehicle(String vehicleName) {
    	if (null != vehicleMap.get(vehicleName)) {
    		return (Vehicle) vehicleMap.get(vehicleName).clone();
        } else {
        	System.out.println("Vehicle" + vehicleName + " is not supported!");
        	return (Vehicle) vehicleMap.get("Citaro").clone();
        }
    }
}
