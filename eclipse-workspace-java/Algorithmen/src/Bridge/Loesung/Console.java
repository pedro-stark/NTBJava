package Bridge.Loesung;

public class Console implements Ausgabe{

	@Override
	public void print(String text) {
		System.out.println(text);
	}
}
