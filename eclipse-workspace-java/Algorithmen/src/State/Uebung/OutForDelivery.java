package State.Uebung;

public class OutForDelivery implements PackageState {

    private static OutForDelivery instance = new OutForDelivery();

    public static OutForDelivery instance() {
        return instance;
    }

    // Methode zur Zustandsaenderung

}
