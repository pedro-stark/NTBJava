package src.ClassFieldsAndMethods;

public class TestCircle2 {

	public static void main(String[] args) {
		//Zugriff auf ein Klassenfeld
		System.out.println("#Objekte: " + Circle2.noOfInstances);
		
		//Objekterzeugung
		Circle2 c1 = new Circle2(1.0);
		System.out.println("#Objekte: " + Circle2.noOfInstances);

		Circle2 c2 = new Circle2(2.0);
		System.out.println("#Objekte: " + Circle2.noOfInstances);

		Circle2 c3 = new Circle2(3.0);
		System.out.println("#Objekte: " + Circle2.noOfInstances);

	}

}
