package Thread;

public class Test {

	public static void main(String args[]) {
		
		System.out.println("Thread " + Thread.currentThread().getName() + " started");
		
		MyThread t1 = new MyThread("T1"); 				//extends Thread
		Thread t2 = new Thread(new MyRunnable(), "T2"); //implements Runnable
		t1.start();
		t2.start();
		
		System.out.println("Thread " + Thread.currentThread().getName() + " terminated");
	}

}
