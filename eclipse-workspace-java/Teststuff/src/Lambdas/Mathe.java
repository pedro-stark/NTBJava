package Lambdas;

public interface Mathe {

	final int i = 2;
	
	public int rechnen(int a, int b);
	
	public default void deimuddr() {
		System.out.println("deimuddr");
	}
}
