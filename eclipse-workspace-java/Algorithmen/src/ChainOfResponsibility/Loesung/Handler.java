package ChainOfResponsibility.Loesung;

public interface Handler {
	public void setNext(Handler h);
	public void handle(String search);
}