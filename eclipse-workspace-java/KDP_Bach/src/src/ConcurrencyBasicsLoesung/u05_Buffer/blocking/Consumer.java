package src.ConcurrencyBasicsLoesung.u05_Buffer.blocking;

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
			System.out.println("" + System.currentTimeMillis() + "\tConsumer: tries to get an element");
			int element = buffer.get();
			System.out.println("" + System.currentTimeMillis() + "\tConsumer: got element " + element);
			
			try {
				Thread.sleep(sleeptime);
			} catch (InterruptedException e) {}
		}
	}
}
