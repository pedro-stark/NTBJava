//C.Bach, 19.11.2018

package src.ConcurrencyBasicsLoesung.u01_Sleep;

public class Loop extends Thread
{
	private int sleeptime;
	
    public Loop(String name, int sleeptime)  {
        super(name);
        this.sleeptime = sleeptime;
    }

    public void run()  {
        for(int i = 1; i <= 50; i++)  {
            System.out.print(getName() + " (" + i + ") ");
            try {
				Thread.sleep(sleeptime);
			} catch (InterruptedException e) {
				System.out.println("Thread " + getName() + " was interrupted: " + e);
			}
        }
    }
  
    
    public static void main(String[] args) {
        Loop t1 = new Loop("a", 100); 
        Loop t2 = new Loop("b", 200); 
        Loop t3 = new Loop("c", 150);
        t1.start(); 
        t2.start();
        t3.start();
    }
}