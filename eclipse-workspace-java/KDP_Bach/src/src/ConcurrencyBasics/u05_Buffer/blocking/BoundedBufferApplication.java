package src.ConcurrencyBasics.u05_Buffer.blocking;

public class BoundedBufferApplication {

	public static void main(String[] args) {
		testSynchronized();
		
		//TODO
		//testSemaphores();
	}
	
	public static void testSynchronized() {
		BoundedBuffer b; 
		b = new BoundedBuffer_Synchronized(5);
		
		Producer p = new Producer(b, 500);
		Consumer c = new Consumer(b, 10000);		
		p.start(); c.start();		
	}

	public static void testSemaphores() {
		BoundedBuffer b; 
		b = new BoundedBuffer_Semaphores(5);
		
		Producer p = new Producer(b, 500);
		Consumer c = new Consumer(b, 10000);		
		p.start(); c.start();		
	}
}
