package src.ConcurrencyBasics.u04_Parkhaus;

//Simulationsprogramm

public class Parking
{
    public static void main(String[] args)
    {
    	final int capacityOfGarage = 5;
    	final int noOfCars = 10;
    	
    	//Die ParkingGarage ist die gemeinsam genutzte Ressource. Hier mit 5 Parkplätzen. 
        ParkingGarage garage = new ParkingGarage(capacityOfGarage, noOfCars);
    	//ParkingGarageFair garage = new ParkingGarageFair(capacityOfGarage);
        
        //Erzeuge 10 Autos (das erste Argument ist der Thread-Name, das zweite die Garage.
        for(int i = 0; i < noOfCars; i++)  {
            new Car("" + i, garage).start();
        }
               
    }
}

/*
 * 
 *  und hier eine Beispielausgabe des Programms:
 *  

enter: 6; parking:[2, 5, 8, 1, 6]; waiting:[4, 3, 0]; driving:[7, 9]
leave: 2; parking:[5, 8, 1, 6]; waiting:[4, 3, 0]; driving:[7, 9, 2]
enter: 4; parking:[5, 8, 1, 6, 4]; waiting:[3, 0]; driving:[7, 9, 2]
leave: 8; parking:[5, 1, 6, 4]; waiting:[3, 0]; driving:[7, 9, 2, 8]
enter: 3; parking:[5, 1, 6, 4, 3]; waiting:[0]; driving:[7, 9, 2, 8]
leave: 4; parking:[5, 1, 6, 3]; waiting:[0]; driving:[7, 9, 2, 8, 4]
enter: 0; parking:[5, 1, 6, 3, 0]; waiting:[]; driving:[7, 9, 2, 8, 4]
leave: 3; parking:[5, 1, 6, 0]; waiting:[]; driving:[7, 9, 2, 8, 4, 3]
enter: 2; parking:[5, 1, 6, 0, 2]; waiting:[]; driving:[7, 9, 8, 4, 3]
wait:  3; parking:[5, 1, 6, 0, 2]; waiting:[3]; driving:[7, 9, 8, 4]
wait:  9; parking:[5, 1, 6, 0, 2]; waiting:[3, 9]; driving:[7, 8, 4]
leave: 5; parking:[1, 6, 0, 2]; waiting:[3, 9]; driving:[7, 8, 4, 5]
enter: 3; parking:[1, 6, 0, 2, 3]; waiting:[9]; driving:[7, 8, 4, 5]
wait:  7; parking:[1, 6, 0, 2, 3]; waiting:[9, 7]; driving:[8, 4, 5]
wait:  4; parking:[1, 6, 0, 2, 3]; waiting:[9, 7, 4]; driving:[8, 5]
wait:  8; parking:[1, 6, 0, 2, 3]; waiting:[9, 7, 4, 8]; driving:[5]
leave: 1; parking:[6, 0, 2, 3]; waiting:[9, 7, 4, 8]; driving:[5, 1]
enter: 9; parking:[6, 0, 2, 3, 9]; waiting:[7, 4, 8]; driving:[5, 1]

*/