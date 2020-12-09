package State.Loesung;
public class InTransition implements PackageState {

    private static InTransition instance = new InTransition();

    public static InTransition instance() {
        return instance;
    }

    // Methode zur Zustandsaenderung
    @Override
    public void updateState(Context ctx) {
        System.out.println("Package is in transition!");
        ctx.setCurrentState(OutForDelivery.instance());
    }
}
