package src.GleitkommazahlenLoesung;

public class Zinseszins {

	public static void main(String[] args) {
		try {
			float kapital = Float.parseFloat(args[0]);
			float zins = Float.parseFloat(args[1]) / 100.0f;
			int laufzeit = Integer.parseInt(args[2]);

			for (int i = 1; i <= laufzeit; i++) {
				kapital += kapital * zins;
				System.out.format("Das Kapital verzinst mit %1$,.2f%% am Ende des %2$2d. Jahres betraegt %3$,.2f\n",
						100.0 * zins, i, 
						Math.round(kapital * 20.0) / 20.0);
			}

		} catch (Exception e) {
			System.err.println("usage: Zinseszins <Kapital (float)> <Zins in Prozent (float)> <Laufzeit (int)>");
			e.printStackTrace();
		}

	}

}
