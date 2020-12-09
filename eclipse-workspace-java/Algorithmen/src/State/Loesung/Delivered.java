package State.Loesung;
public class Delivered implements PackageState {

    private static Delivered instance = new Delivered();

    public static Delivered instance() {
        return instance;
    }

	// Methode zur Zustandsaenderung
    @Override
    public void updateState(Context ctx) {
        System.out.println("Package is delivered!");
    }
}
