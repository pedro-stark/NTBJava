package Bridge;

public abstract class Text {

	protected String text;
	private Ausgabe ausgabe;
	
	public  Text(String text, Ausgabe aus) {
		this.text = text;
		this.ausgabe = aus;
	}
	public void print() {
		ausgabe.print();
	}
	
	public void changeAusgabe(Ausgabe aus) {
		ausgabe = aus;
	}
}
