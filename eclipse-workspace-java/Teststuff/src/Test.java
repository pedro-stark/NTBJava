

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Runnable runny = () -> System.out.println("deimuddr");
		
		Thread t = new Thread( () ->  {System.out.println("deimuddr");} );
		System.out.println(System.currentTimeMillis());
	}

}
