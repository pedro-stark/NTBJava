/* ToDo
 * In der getFlyweights-Methode ist das Flyweight zu erstellen
 */

package Flyweight.Uebung;

import java.util.HashMap;

public class FlyweightFactory {
	private HashMap<String, Gruss> flyweights;

	public FlyweightFactory() {
		flyweights = new HashMap<String, Gruss>();
	}

	public Gruss getFlyweights(String key) {
		// suchen des Keys im Cache
		Gruss fw = flyweights.get(key);

		// falls nicht gefunden wird ein neues flyweight erstellt
		if (fw == null) {
			switch (key) {
			case "gruss":

				// --> flyweight erstellen<--

				flyweights.put("brief", fw); // flyweight im Cache ablegen
				break;
			case "a":
				// weitere Varianten des Flyweights....
				flyweights.put("a", fw);
				break;
			}
		}
		return fw;
	}
}
