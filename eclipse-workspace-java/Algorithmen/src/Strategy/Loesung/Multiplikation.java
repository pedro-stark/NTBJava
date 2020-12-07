package Strategy.Loesung;

public class Multiplikation implements Interface_Strategy{

	@Override
	public int process(int a, int b) {
		System.out.println("Multiplikation");
		return a * b;
	}

}
