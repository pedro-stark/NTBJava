package Prototype.Vehicle;


public class VehiclePrototypeIF {
	public static void main (String[] args) 
    { 
        TrainIF ice = (TrainIF) VehiclesIF.getVehicle("ICE K4s");
        System.out.println(ice.getInfo());
    }
}

