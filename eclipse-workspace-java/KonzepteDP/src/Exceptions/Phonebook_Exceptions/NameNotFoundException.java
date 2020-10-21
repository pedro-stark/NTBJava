package Exceptions.Phonebook_Exceptions;

public class NameNotFoundException extends Exception{
	private String name;
	
	public NameNotFoundException(String name){
		super();
		this.name = name;
	}
	
	public String getMessage(){
		String s = super.getMessage();
		return s + " Name " + name + " was not found in Phonebook";
	}
}
