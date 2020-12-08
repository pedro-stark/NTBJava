package src.ConcurrencyBasics.u05_Buffer.nonblocking;

public class Producer extends Thread {

	private BoundedBuffer buffer;
	private int sleeptime;
	
	public Producer(BoundedBuffer buf, int sleeptime) {
		super("Producer");
		this.buffer = buf;
		this.sleeptime = sleeptime;
	}
	
	public void run() {
		while (true) {
			int element = (int)(Math.random() * 1000); 
			System.out.println("" + System.currentTimeMillis() + "\tProducer: tries to put element " + element);			
			try {
				buffer.put(element);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			System.out.println("" + System.currentTimeMillis() + "\tProducer: put element " + element);			

			try {
				Thread.sleep(sleeptime);
			} catch (InterruptedException e) {
			}
		}
	}
}
