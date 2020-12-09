package State.Loesung;
public class OutForDelivery implements PackageState {

    private static OutForDelivery instance = new OutForDelivery();

    public static OutForDelivery instance() {
        return instance;
    }

    // Methode zur Zustandsaenderung
    @Override
    public void updateState(Context ctx) {
        System.out.println("Package is out for delivery!");
        ctx.setCurrentState(Delivered.instance());
    }
}
