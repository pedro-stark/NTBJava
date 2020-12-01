package KW49.ConcurrencyBasics.u04_Parkhaus;

import java.util.ArrayList;

public class ParkingGarage
{
    private int freePlaces;
    
    //for debugging purposes
    private char[] status;
    private ArrayList<Car> waiting;
    private ArrayList<Car> parking;
    private ArrayList<Car> driving;
    
    
    public ParkingGarage(int places, int cars) {
        this.freePlaces = places;

        status = new char[cars]; for (int i = 0; i < status.length; i++) { status[i] = '?'; }
        waiting = new ArrayList<>();
        parking = new ArrayList<>();
        driving = new ArrayList<>();
    }

    public synchronized void enter() {
    	Car car = (Car)Thread.currentThread(); int carNo = Integer.parseInt(car.getName());  
    	driving.remove(car); status[carNo] = '?';
    	
    	while(freePlaces == 0) {
            try {
            	waiting.add(car); status[carNo] = 'w'; //evtl. sogar mehrmals! (deswegen später removeIf)
            	System.out.println("wait:  "  + car.getName() + "; " + this);
        
            	wait();
            } catch(Exception e) {
            }
        }
    	freePlaces--;

    	waiting.removeIf(c -> c == car); parking.add(car); status[carNo] = 'p';  
    	System.out.println("enter: " + car.getName() + "; " + this);
    }

    public synchronized void leave() {
    	Car car = (Car)Thread.currentThread(); int carNo = Integer.parseInt(car.getName());  

    	freePlaces++;
    	
    	parking.remove(car); driving.add(car); status[carNo] = 'd';
    	System.out.println("leave: " +  Thread.currentThread().getName() + "; " + this);
        
    	notify();
    }
    
    public synchronized int getPlaces() {
    	return freePlaces;
    }
    
    public String toString() {
    	return "free places: " + freePlaces 
    		+ "; status:" + String.valueOf(status) 
    		+ "; parking:" + parking.toString() 
    		+ "; waiting:" + waiting.toString() 
    		+ "; driving:" + driving.toString();
    }
}
