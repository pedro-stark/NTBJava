package Strategy.Loesung;

public class Subtraktion implements Interface_Strategy {

	@Override
	public int process(int a, int b) {
		System.out.println("Subtraktion");
		return a - b;
	}

}
