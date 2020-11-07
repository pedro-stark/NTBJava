package Bridge;

public abstract class TextAusgabe {
	
	protected String text;
	
	public TextAusgabe(String text) {
		this.text = text;
	}
	
	public abstract void print();

}
