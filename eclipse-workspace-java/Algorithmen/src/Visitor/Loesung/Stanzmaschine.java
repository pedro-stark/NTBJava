package Visitor.Loesung;

public class Stanzmaschine extends Maschine {

	public Stanzmaschine() {

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
