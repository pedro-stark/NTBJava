package State.Loesung;
public class Acknowledged implements PackageState {

    private static Acknowledged instance = new Acknowledged();

    public static Acknowledged instance() {
        return instance;
    }

	// Methode zur Zustandsaenderung
    public void updateState(Context ctx) {
        System.out.println("Package is acknowledged!");
        ctx.setCurrentState(Shipped.instance());
    }
}
