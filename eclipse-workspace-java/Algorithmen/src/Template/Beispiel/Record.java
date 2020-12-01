package Template.Beispiel;

public abstract class Record {
	public void save(){
		this.validate();
		this.beforeSave();
		//Code, welcher auf DB speichert. Hier einfach als print
		System.out.println("Saved");
	}
	public abstract void validate();
	public void beforeSave(){};
}
