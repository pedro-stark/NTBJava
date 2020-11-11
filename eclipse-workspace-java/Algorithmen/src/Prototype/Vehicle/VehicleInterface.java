package Prototype.Vehicle;

public interface VehicleInterface extends Cloneable {

	public abstract void setName(String name);
	public abstract void setPower(int power);
	public abstract void setSeats(int seats);
	public abstract String getInfo();
	
	public abstract void addVehicle();
	
	public Object clone();
}
