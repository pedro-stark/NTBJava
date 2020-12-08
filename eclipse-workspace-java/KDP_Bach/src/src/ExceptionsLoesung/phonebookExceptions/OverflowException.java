package src.ExceptionsLoesung.phonebookExceptions;

public class OverflowException extends Exception{
	private String name;
	
	public OverflowException(){
		super();
		this.name = name;
	}
	
	public String getMessage(){
		return "Phonebook has no more space";
	}
}