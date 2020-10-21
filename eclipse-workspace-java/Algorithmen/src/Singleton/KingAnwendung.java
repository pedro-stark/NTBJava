package Singleton;

public class KingAnwendung {

	public static void main(String[] args){
		
		King Heinrich = King.getInstance();
		
		Heinrich.setName("Heinrich IV");
		
		King Ludwig = King.getInstance();
		
		Ludwig.setName("Ludwig XIV");
		
		System.out.println(Heinrich.RueckzugsBefehl());
		System.out.println(Heinrich.AngriffsBefehl());
		System.out.println(Ludwig.RueckzugsBefehl());
		System.out.println(Ludwig.AngriffsBefehl());
	}

}