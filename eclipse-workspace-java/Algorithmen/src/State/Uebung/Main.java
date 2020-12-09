package State.Uebung;

public class Main {
    public static void main(String[] args) {
        Context ctx = new Context(null);

        ctx.update(); // Acknowledged
        ctx.update(); // Shipped
        ctx.update(); // InTransition
        ctx.update(); // OutForDelivery
        ctx.update(); // Delivered
    }
}
