package src.Gleitkommazahlen;

public class PI {

	public static void main(String[] arg) {
		double pi; int iterations;

		//V1
		iterations = 32000;
		pi= calc1(iterations);
		System.out.printf("my pi = %.10f, Math.PI = %.10f, error = %8.4e, iterations = %,8d\n", pi, Math.PI, Math.abs(pi - Math.PI), iterations);

		//V2
		double[] res = calc2(0.00001);
		pi = res[0];
		iterations = (int)res[1];
		System.out.printf("my pi = %.10f, Math.PI = %.10f, error = %8.4e, iterations = %,8d\n", pi, Math.PI, Math.abs(pi - Math.PI), iterations);
	}


	public static double calc1(int nofTerms) {
		//your code goes here!
		return 0.0;
	}
	
	
	public static double[] calc2(double error) {
		double[] result = new double[2]; // in result[0] steht PI und in result[1] die Anzahl Iterationen

		//your code goes here!
		return result;
	}	
}
