package Strategy.Loesung;

public class Addition implements Interface_Strategy {

	@Override
	public int process(int a, int b) {
		System.out.println("Addition");
		return a + b;
	}

}
