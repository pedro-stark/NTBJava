package Template.Beispiel;

public class User extends Record {

	@Override
	public void validate() {
		System.out.println("Validation erfolgreich");
		
	}

	@Override
	public void beforeSave() {
		super.beforeSave();
		System.out.println("Pruefung direkt vor dem Save");
	}

}
