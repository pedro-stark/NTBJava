//C.Bach, 19.11.2018

package src.ConcurrencyBasicsLoesung.u01_Sleep;

public class LoopAsRunnable implements Runnable
{
	private int sleeptime;

	public LoopAsRunnable(int sleeptime)  {
		this.sleeptime = sleeptime;
    }

    public void run()  {
        for(int i = 1; i <= 10; i++)  {
            System.out.print(Thread.currentThread().getName() + " (" + i + ") ");
            try {
				Thread.sleep(sleeptime);
			} catch (InterruptedException e) {
				System.out.println("Thread " + Thread.currentThread().getName() + " was interrupted: " + e);
			}
        }
    }
    
    
    public static void main(String[] args) {
        Thread t1 = new Thread(new LoopAsRunnable(100), "a"); 
        Thread t2 = new Thread(new LoopAsRunnable(200), "b");
        Thread t3 = new Thread(new LoopAsRunnable(150), "c");
        t1.start(); 
        t2.start();
        t3.start();
    }
}