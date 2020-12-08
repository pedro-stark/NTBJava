//C.Bach, 11.11.2015

package ex04_Termination;

public class Loop_Join extends Thread
{
    public Loop_Join(String name)  {
        super(name);
    }

    public void run()  {
        System.out.println("\n***: " + getName() + " just started.");
        for(int i = 1; i <= 10; i++)  {
            System.out.print(getName() + " (" + i + ") ");
            try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
        }
        System.out.println("\n***: " + getName() + " just terminated.");
    }

    public static void main(String[] args)
    {
        System.out.println("***: " + Thread.currentThread().getName() + " just started.");
        Loop_Join t1 = new Loop_Join("a"); 
        Loop_Join t2 = new Loop_Join("b"); 
        Loop_Join t3 = new Loop_Join("c");
        t1.start(); 
        t2.start();
        t3.start();
        
        try {
			t1.join(); 
			t3.join();
	        System.out.println("\n***: " + t1.getName() + " just terminated and joined with " + Thread.currentThread().getName() + ".");
		} catch (InterruptedException e) {
		}
        
        System.out.println("\n***: " + Thread.currentThread().getName() + " just terminated.");
    }
}