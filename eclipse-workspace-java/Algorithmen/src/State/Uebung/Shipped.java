package State.Uebung;

public class Shipped implements PackageState {

    private static Shipped instance = new Shipped();

    public static Shipped instance() {
        return instance;
    }

    // Methode zur Zustandsaenderung

}
