package Visitor.Loesung;

public interface Visitor {
	
	public void visit(Drehbank dreh);
	public void visit(Stanzmaschine stan);
	public void visit(SchweissRoboter s);

}
