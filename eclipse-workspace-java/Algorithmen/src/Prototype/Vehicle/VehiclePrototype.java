package Prototype.Vehicle;




public class VehiclePrototype {
	public static void main (String[] args) 
    { 
        Bus citaro1 = (Bus) Vehicles.getVehicle("Citaro");
        System.out.println(citaro1.getInfo());
        
        Bus citaro2 = (Bus) Vehicles.getVehicle("Citaro");
        citaro2.setPower(350);
        citaro2.setSeats(70);
        citaro2.setName("Citaro G2");
        System.out.println(citaro2.getInfo());
        
        System.out.println("---------------------------");
        
        Car clio1 = (Car) Vehicles.getVehicle("Clio");
        clio1.setPower(200);
        clio1.setName("Clio RS");
        System.out.println(clio1.getInfo());
        
        Car clio2 = (Car) Vehicles.getVehicle("Clio");
        System.out.println(clio2.getInfo());
        
        System.out.println("---------------------------");
        
        Car rimac = (Car) Vehicles.getVehicle("C_Two");
        System.out.println(rimac.getInfo());
        
        System.out.println("---------------------------");
        
        Plane airbus = (Plane) Vehicles.getVehicle("A320");
        System.out.println(airbus.getInfo());
        
        System.out.println("---------------------------");
        
        Train ice = (Train) Vehicles.getVehicle("ICE K4s");
        System.out.println(ice.getInfo());
    }
}

