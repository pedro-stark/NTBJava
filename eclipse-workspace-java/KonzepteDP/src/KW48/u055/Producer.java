package KW48.u055;

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
			System.out.println("Producer: want to put " + element + " / " + System.currentTimeMillis());
			buffer.put(element);

			try {
				Thread.sleep(sleeptime);
			} catch (InterruptedException e) {
			}
		}
	}
}
