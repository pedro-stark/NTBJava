package Visitor.Loesung;

public class SchweissRoboter extends Maschine {

	public SchweissRoboter() {

	}

	@Override
	public void accept(Visitor vis) {
		vis.visit(this);

	}

	@Override
	public void setLaufzeit(int zeit) {
		this.Laufzeit = zeit;

	}

}
