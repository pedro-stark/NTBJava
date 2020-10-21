package Rekursion;
//Kapitel 2, Aufgabe 5
public class FiboRekursiv {

	public static int fib(int n) {
		int fibn;
		
		if (n==0 || n==1) {
			fibn = 1;
		}else {
			fibn=fib(n-1) + fib(n-2);
	}
		return fibn;
	}


	public static void main(String[] args) {
		System.out.println(fib(7));

	}

}
