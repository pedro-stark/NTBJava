package State.Uebung;

public class Acknowledged implements PackageState {

    private static Acknowledged instance = new Acknowledged();

    public static Acknowledged instance() {
        return instance;
    }

    // Methode zur Zustandsaenderung

}
