package Prototype.Vehicle;

public class Plane extends Vehicle {

	public Plane(String name, int power, int seats) {
		this.name = name;
		this.power = power;
		this.seats = seats;
	}

	@Override
	public void addVehicle() {
		System.out.println("added " + this.name);
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public void setPower(int power) {
		this.power = power;
	}
	@Override
	public void setSeats(int seats) {
		this.seats = seats;
	}
	@Override
	public String getInfo() {
		return (this.name + ", " + this.power + " PS, " + this.seats + " Sitzplštze");
	}
}
