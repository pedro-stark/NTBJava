package src.Patterns.MVC_0_Grundlage;

//siehe https://www.tutorialspoint.com/design_pattern/observer_pattern.htm

public abstract class Observer {
	protected Subject subject;
	
	public Observer(Subject s) {
		subject = s;
		subject.attach(this);
	}
	
	public abstract void update();
}