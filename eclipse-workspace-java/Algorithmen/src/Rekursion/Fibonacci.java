package Rekursion;

public class Fibonacci {

	public static void Fibo(int bis) {
		int fibn;
		int fibn1 = 1;
		int fibn2 = 1;
				System.out.println("Fibo 0 = " + fibn1);
				System.out.println("Fibo 1 = " + fibn2);
				
			     for (int i = 2; i < bis +1; i++) {
			         fibn = fibn1 + fibn2;
			         fibn2 = fibn1;
			         fibn1 = fibn;
			         System.out.println("Fibo " + i + " = " + fibn);
			         
			       }
			     }
	

	public static void main(String[] args) {
		
		Fibo(20);

	}

}
