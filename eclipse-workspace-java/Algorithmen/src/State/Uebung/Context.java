package State.Uebung;

public class Context {
    private PackageState currentState;

    public Context(PackageState currentState) {
        this.currentState = currentState;

        if (currentState == null) {
            // Anfangszustand setzen
        }
    }

    public PackageState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(PackageState currentState) {
        this.currentState = currentState;
    }

    public void update() {
        // Zustand updaten
    }

}
