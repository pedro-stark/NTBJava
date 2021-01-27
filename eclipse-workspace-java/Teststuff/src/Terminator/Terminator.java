package Terminator;

public class Terminator extends Thread{

	private long startTime;
	
	public Terminator() {
		super();
	}

	public void run() {
		startTime = System.currentTimeMillis();
		long actualTime =  System.currentTimeMillis();
		while(!isInterrupted()) {
			actualTime = System.currentTimeMillis();
			if (actualTime - startTime >=10000) {
				System.out.println("DONE");
				System.exit(1);
			} else if (actualTime - startTime >=9000) {
				disable();
			}
		}
	}
	
	public void disable() {
		System.out.println(currentThread().getClass().getName() + "interrupted");
		interrupt();
	}
}
