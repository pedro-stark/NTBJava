package Memento.Loesung;

public class Memento {
	private Person p;
	public Memento(Person p){
		try{
			this.p = (Person) p.clone();
		}catch(CloneNotSupportedException c){}  
		  
	} 
	public void setState(Person p){
		try{
			this.p = (Person) p.clone();
		}catch(CloneNotSupportedException c){} 
	}
	public Person getState(){
		return this.p;
	}
}
