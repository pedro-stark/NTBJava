package Prototype.Vehicle;

public class TrainIF implements VehicleInterface, Cloneable {
	
	public String name;
	public int power;
	public int seats;
	
	public TrainIF(String name, int power, int seats) {
		this.name = name;
		this.power = power;
		this.seats = seats;
	}

	public void addVehicle() {
		System.out.println("added " + this.name);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPower(int power) {
		this.power = power;
	}
	
	public void setSeats(int seats) {
		this.seats = seats;
	}
	
	public String getInfo() {
		return (this.name + ", " + this.power + " PS, " + this.seats + " Sitzplätze");
	}
	
	@Override
	public Object clone() {
		Object clone = null;
		try {
			clone = super.clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
		return clone;
	}
}
