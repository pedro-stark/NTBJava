package State.Uebung;

public class InTransition implements PackageState {

    private static InTransition instance = new InTransition();

    public static InTransition instance() {
        return instance;
    }

    // Methode zur Zustandsaenderung

}
