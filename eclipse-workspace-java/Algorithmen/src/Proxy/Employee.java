package Proxy;

public class Employee {

	private String name;
	private int role;
	
	public Employee(String n, int r) {
		name = n;
		role = r;
	}
	
	public String getName() {
		return name;
	}
	
	public int getRole() {
		return role;
	}
}
