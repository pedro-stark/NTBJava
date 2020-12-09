package Memento.Loesung;

public class Person implements Cloneable {
	private String lname;
	private String fname;
	private int age;
	
	public void setPerson(String lname, String fname, int age){
		this.lname = lname;
		this.fname = fname;
		this.age = age;
	}
	public String getLName() {
		return this.lname;
	}
	public String getFName() { 
		return this.fname;
	}
	public int getAge() {
		return this.age;
	}
	public String toString(){
		return this.lname+" "+this.fname+", "+Integer.toString(age);
	}
	public Memento save(){
		return new Memento(this);
	}
	public void restore(Memento m){
		this.lname = m.getState().getLName();
		this.fname = m.getState().getFName();
		this.age = m.getState().getAge();
	}
	public Object clone()throws CloneNotSupportedException{  
		return super.clone();  
	} 
}
