package Thread;

public class MyThread extends Thread{

	public MyThread(String name) {
		super(name);
	}

	public void run() {
		System.out.println("Thread " + Thread.currentThread().getName() + " started");
		for (int i=1; i <= 10; i++) {
			System.out.println(getName() +": "+ i + ", ");
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		System.out.println();
		System.out.println("Thread " + Thread.currentThread().getName() + " ended");
			
	}
	
}
