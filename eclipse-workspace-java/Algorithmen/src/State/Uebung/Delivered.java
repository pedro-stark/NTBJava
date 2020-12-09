package State.Uebung;

public class Delivered implements PackageState {

    private static Delivered instance = new Delivered();

    public static Delivered instance() {
        return instance;
    }

    // Methode zur Zustandsaenderung

}
