package Factory.SimpleFactory.CarFactory;


public class CarFactory {

	public Car getCar(String carType, String color) {

		if (carType.equalsIgnoreCase("FORD")) {
			return new Ford(color);

		} else if (carType.equalsIgnoreCase("PORSCHE")) {
			return new Porsche(color);

		} else if (carType.equalsIgnoreCase("FERRARI")) {
			return new Ferrari(color);
		}

		return null;
	}

}
