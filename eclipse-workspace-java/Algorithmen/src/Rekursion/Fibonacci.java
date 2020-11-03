package Rekursion;


public class Fibonacci {

	public static void Fibo(long bis) {
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
		
		long startTime = System.nanoTime();
		Fibo(45);
		long endTime = System.nanoTime();
		long duration = (endTime - startTime)/1000000;  //divide by 1000000 to get milliseconds.
		System.out.println("Dauer iterativ: " + duration);
		
		
		startTime = System.nanoTime();
		FiboRekursiv.fib(45);
		endTime = System.nanoTime();
		duration = (endTime - startTime)/1000000;  //divide by 1000000 to get milliseconds.
		System.out.println("Dauer rekursiv: " + duration);
	}

}
