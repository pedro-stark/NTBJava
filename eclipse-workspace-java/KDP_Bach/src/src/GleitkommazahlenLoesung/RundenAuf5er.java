package src.GleitkommazahlenLoesung;
public class RundenAuf5er {
	public static void main(String[] args) {		
		double[] ds = {7.46, 7.45, 7.44};
		
		for (double d : ds) {
			double dAuf5erGerundet = Math.round(d * 20.0) / 20.0;
			System.out.println(d + " / " + dAuf5erGerundet);
		}
	}
}
