package Visitor.Loesung;

public abstract class Maschine {

	protected int Laufzeit;

	public Maschine() {

	}

	public abstract void accept(Visitor vis);
	public abstract void setLaufzeit(int zeit);

}
