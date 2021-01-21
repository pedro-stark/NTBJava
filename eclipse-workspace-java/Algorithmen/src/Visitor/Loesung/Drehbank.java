package Visitor.Loesung;

public class Drehbank extends Maschine {

	public Drehbank() {
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
