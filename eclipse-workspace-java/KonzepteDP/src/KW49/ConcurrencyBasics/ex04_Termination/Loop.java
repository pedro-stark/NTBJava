//C.Bach, 11.11.2015

package KW49.ConcurrencyBasics.ex04_Termination;

public class Loop extends Thread
{
    public Loop(String name)  {
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
        Loop t1 = new Loop("a"); 
        Loop t2 = new Loop("b"); 
        Loop t3 = new Loop("c");
        t1.start(); 
        t2.start();
        t3.start();
        System.out.println("\n***: " + Thread.currentThread().getName() + " just terminated.");
    }
}