package KW48.u055;

public class Consumer extends Thread {

	private BoundedBuffer buffer;
	private int sleeptime;
	
	public Consumer(BoundedBuffer buf, int sleeptime) {
		super("Consumer");
		this.buffer = buf;
		this.sleeptime = sleeptime;
	}
	
	public void run() {
		while (true) {
			System.out.println("Consumer: want to get an element" + " / " + System.currentTimeMillis());
			int element = buffer.get();
			
			try {
				Thread.sleep(sleeptime);
			} catch (InterruptedException e) {}
		}
	}
}
