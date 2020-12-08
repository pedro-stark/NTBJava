package src.GleitkommazahlenLoesung;

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
		double pi = 0;
		int n = 1;
		int nMax = nofTerms * 2 - 1;
		while (n < nMax) {
			pi = pi + 1.0 / n; n = n + 2;
			pi = pi - 1.0 / n; n = n + 2;
		};
		return 4.0 * pi;
	}
	
	
	public static double[] calc2(double error) {
		double[] result = new double[2];
		
		double pi= 1.0, prev = 0.0;
		int i = 3, sign = - 1;
		while (Math.abs(pi - prev) > error / 4.0) {
			prev = pi;
			pi = pi + sign * (1.0 / i);
			sign = - sign;
			i = i + 2;
		}
		result[0] = 4.0 * pi;
		result[1] = i;
		
		return result;
	}	

	public static double[] calc3(double error) {
		double[] result = new double[2];
		
		double pi= 1.0, prev = 0.0;
		int i = 3;
		while (Math.abs(pi - prev) > error / 4.0) {
			prev = pi;
			pi = pi - (1.0 / i)  + (1.0/(i+2));
			i = i + 4;
		}
		result[0] = 4.0 * pi;
		result[1] = i;
		
		return result;
	}	

}
