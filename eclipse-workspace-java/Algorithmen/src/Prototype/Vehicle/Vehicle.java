package Prototype.Vehicle;

public abstract class Vehicle implements Cloneable {
	protected String name;
	protected int power;
	protected int seats; 
	
	public abstract void setName(String name);
	public abstract void setPower(int power);
	public abstract void setSeats(int seats);
	public abstract String getInfo();
	
	public abstract void addVehicle();
	
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
