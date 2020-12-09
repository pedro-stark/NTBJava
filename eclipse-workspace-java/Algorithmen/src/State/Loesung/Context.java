package State.Loesung;
public class Context {
    private PackageState currentState;

    public Context(PackageState currentState) {
        this.currentState = currentState;

        if (currentState == null) {
            this.currentState = Acknowledged.instance(); // Anfangszustand setzen
        }
    }

    public PackageState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(PackageState currentState) {
        this.currentState = currentState;
    }

    public void update() {
        currentState.updateState(this); // Zustand updaten
    }

}
