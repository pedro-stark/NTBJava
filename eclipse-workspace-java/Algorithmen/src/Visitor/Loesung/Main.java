package Visitor.Loesung;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Visitor_Werkstattleiter Markus = new Visitor_Werkstattleiter();
		Drehbank dreh = new Drehbank();
		Stanzmaschine stanz = new Stanzmaschine();
		SchweissRoboter sw = new SchweissRoboter();
		
		dreh.setLaufzeit(10);
		stanz.setLaufzeit(20);
		sw.setLaufzeit(50);
		
		List<Maschine> m = new ArrayList<>();
		m.add(dreh);
		m.add(stanz);
		m.add(sw);
		
		for(Maschine obj:m) {
			obj.accept(Markus);
		}
		
	}
}
