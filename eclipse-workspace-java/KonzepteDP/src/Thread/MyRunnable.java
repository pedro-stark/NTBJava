package Thread;

public class MyRunnable implements Runnable{

	public MyRunnable() {
	}

	public void run() {
		System.out.println("Thread " + Thread.currentThread().getName() + " started");
		for (int i=1; i <= 10; i++) {
			System.out.println(Thread.currentThread().getName() +": "+ i + ", ");
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		System.out.println("Thread " + Thread.currentThread().getName() + " ended");
			
	}
	
}
