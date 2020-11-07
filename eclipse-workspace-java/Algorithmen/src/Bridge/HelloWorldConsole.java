package Bridge;

public class HelloWorldConsole extends TextAusgabe{
	
	public HelloWorldConsole() {
		super("HelloWorld!");
	}
	
	public void print() {
		System.out.println(text);
	}
}
