/* ToDo
 * extrinsic Datenfelder erkennen und auslagern
 * Gruss soll das Interface_Flyweight implementieren
 */

package Flyweight.Loesung;

public class Gruss implements Interface_Flyweight{
	public String line1;
	public String line2;
	public String line3;
	public String line3_1;
	public String line4;
	public String line5;
	public String line6;
	public String line7;
	public String line8;
	public String line9;
	public String line10;
	public String line11;
	public String line12;
	
	public Gruss() {
		line1 = "Sehr geehrter ";
		line2 = "";
		line3 = "Wir bedanken uns bei ";
		line3_1	= " für das entgegengebrachte ";
		line4 = "Vertrauen und die gute Zusammenarbeit im Jahr 2020 und ";
		line5 = "wünschen Ihnen und Ihrer Familie erholsame Festtage sowie ein ";
		line6 = "spannendes und gesundes neues Jahr!";
		line7 = "";
		line8 = "Auch wir verabschieden uns in den Weihnachtsurlaub. Ab dem ";
		line9 = "20. Januar sind wir wieder für Sie da.";
		line10 = "";
		line11 = "Es grüßt Sie herzlich";
	}
	
	
	public void print(String empf, String firma, String abs) {
		System.out.println(line1 + empf);
		System.out.println(line2);
		System.out.println(line3 + firma + line3_1);
		System.out.println(line4);
		System.out.println(line5);
		System.out.println(line6);
		System.out.println(line7);
		System.out.println(line8);
		System.out.println(line9);
		System.out.println(line10);
		System.out.println(line11);
		System.out.println(abs);
		
	}
}
