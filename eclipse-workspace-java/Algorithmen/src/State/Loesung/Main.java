package State.Loesung;
public class Main {
    public static void main(String[] args) {
        Context ctx = new Context(null);

        System.out.println("");
        ctx.update(); // Acknowledged
        ctx.update(); // Shipped
        ctx.update(); // InTransition
        ctx.update(); // OutForDelivery
        ctx.update(); // Delivered
        System.out.println("");
    }
}
