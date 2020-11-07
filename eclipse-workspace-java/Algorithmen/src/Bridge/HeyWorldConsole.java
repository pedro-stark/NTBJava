package Bridge;

public class HeyWorldConsole extends TextAusgabe{
	
	public HeyWorldConsole() {
		super("HeyWorld!");
	}
	
	public void print() {
		System.out.println(text);
	}

}
