package State.Loesung;
public class Shipped implements PackageState {

    private static Shipped instance = new Shipped();

    public static Shipped instance() {
        return instance;
    }

	// Methode zur Zustandsaenderung
    @Override
    public void updateState(Context ctx) {
        System.out.println("Package is shipped!");
        ctx.setCurrentState(InTransition.instance());
    }
}
