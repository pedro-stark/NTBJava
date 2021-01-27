package Lambdas;

public interface Mathe {

	public int rechnen(int a, int b);
	
	default void deimuddr() {
		System.out.println("deimuddr");
	}
}
