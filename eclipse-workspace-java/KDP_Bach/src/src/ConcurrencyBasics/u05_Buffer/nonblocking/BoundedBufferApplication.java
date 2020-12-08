package src.ConcurrencyBasics.u05_Buffer.nonblocking;

public class BoundedBufferApplication {

	public static void main(String[] args) {
		BoundedBuffer b = new BoundedBuffer(5); 
		
		Producer p = new Producer(b, 500);
		Consumer c = new Consumer(b, 10000);		
		p.start(); c.start();
	}

}
