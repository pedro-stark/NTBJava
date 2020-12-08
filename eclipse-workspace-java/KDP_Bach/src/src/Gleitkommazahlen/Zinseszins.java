package src.Gleitkommazahlen;

public class Zinseszins {

	public static void main(String[] args) {
		try {
			float kapital = Float.parseFloat(args[0]);
			float zins = Float.parseFloat(args[1]) / 100.0f;
			int laufzeit = Integer.parseInt(args[2]);
			
			//YOUR CODE GOES HERE

		} catch (Exception e) {
			System.err.println("usage: Zinseszins <Kapital (float)> <Zins in Prozent (float)> <Laufzeit (int)>");
			e.printStackTrace();
		}

	}

}
