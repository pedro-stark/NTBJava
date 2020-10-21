package Singleton;

public class King {
	private static King king;
	private String name;
	
	private King(){
	}
	
	public void setName(String koenig){
		name = koenig;
	}
	
	public static King getInstance() {
        if (king == null){
            king = new King();
        }
        return king;
	}
	
	public String AngriffsBefehl(){
		return name + " befiehlt: Wir greifen an!";
	}
	
	public String RueckzugsBefehl(){
		return name + " befiehlt: Wir ziehen uns zurück!";
	}
}