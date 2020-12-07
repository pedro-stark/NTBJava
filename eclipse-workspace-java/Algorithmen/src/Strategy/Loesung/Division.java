package Strategy.Loesung;

public class Division implements Interface_Strategy {

	@Override
	public int process(int a, int b) {
		if(b==0) {
			System.out.println("Error");
			return 9999;
		}
		System.out.println("Division");
		return a / b;
	}

}
