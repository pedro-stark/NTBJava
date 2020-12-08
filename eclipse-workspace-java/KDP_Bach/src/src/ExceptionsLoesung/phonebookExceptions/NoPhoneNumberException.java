package src.ExceptionsLoesung.phonebookExceptions;

public class NoPhoneNumberException extends Exception {

	private String name;

	public NoPhoneNumberException(String name) {
		super();
		this.name = name;
	}

	public String getMessage() {
		// String s = super.getMessage();
		return name + " has no valid phonenumber";
	}
}