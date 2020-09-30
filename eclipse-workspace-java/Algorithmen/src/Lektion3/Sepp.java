package Lektion3;

public class Sepp { //Sepp soll ein Abzählvers sein
					//Fragestellung: wer gewinnt?
	static Kasten aufstellen(String[] name) {
		Kasten p;
		Kasten anfang;
		anfang = new Kasten(name[0]);
		p = anfang;
		int i=1;
		while (i<name.length) {
			p.next = new Kasten(name[i]);
			p = p.next;
			i = i+1;
		}
		p.next = anfang;
		return anfang;
	}
	static void abzaehlen(Kasten anfang, int vLnge) {
		Kasten p;
		int i;
		p = anfang;
		do {
			for (i=1; i<vLnge; i++) p = p.next;
			System.out.println(p.next.name);
			p.next = p.next.next;
		} while (p.next != p);
		System.out.println("Es gewinnt: "+p.name);
	}
	public static void main(String[] arg) {
		Kasten ref;
		int vLnge = 7;
		String[] namen = {"Anna","Berta","Emil","Max","Otto", "Otto2", "Otto3", "Otto4", "Otto5", "Otto6", "Otto7"};
		ref = aufstellen(namen);
		abzaehlen(ref,vLnge);
	}
}