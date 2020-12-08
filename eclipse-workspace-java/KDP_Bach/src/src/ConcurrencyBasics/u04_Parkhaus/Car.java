package src.ConcurrencyBasics.u04_Parkhaus;

class Car extends Thread {
	private ParkingGarage garage;

	public Car(String name, ParkingGarage garage) {
		super(name);
		this.garage = garage;
	}

	public void run() {
		while (true) {
			try { sleep((int)(Math.random() * 5000)); } catch (InterruptedException e) {}
			
			garage.enter();
			//System.out.println(getName() + ": eingefahren; verfügbar: " + garage.getPlaces());
			
			try { sleep((int)(Math.random() * 10000)); } catch (InterruptedException e) {}
			
			//System.out.println(getName() + ": ausgefahren; verfügbar:" + garage.getPlaces());
			garage.leave();
		}
	}
	
	public String toString() {
		return getName();
	}
}
