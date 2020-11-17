//C.Bach, 11.11.2015

package Thread;

public class Loop_Join extends Thread
{
	int t;
    public Loop_Join(String name, int t)  {
        super(name);
        this.t= t;
    }

    public void run()  {
        System.out.println("\n***: " + getName() + " just started.");
        for(int i = 1; i <= 10; i++)  {
            System.out.print(getName() + " (" + i + ") ");
            try {
				Thread.sleep(t);
			} catch (InterruptedException e) {
			}
        }
        System.out.println("\n***: " + getName() + " just terminated.");
    }

    public static void main(String[] args)
    {
        System.out.println("***: " + Thread.currentThread().getName() + " just started.");
        Thread t1 = new Loop_Join("a", 100); 
        Thread  t2 = new Loop_Join("b", 100); 
        Thread  t3 = new Loop_Join("c", 200);
        t1.start(); 
        t2.start();
        t3.start();
        
        try {
			t3.join(); 
	        System.out.println("\n***: " + t3.getName() + " just terminated and joined with " + Thread.currentThread().getName() + ".");
			t1.join(); 
	        System.out.println("\n***: " + t1.getName() + " just terminated and joined with " + Thread.currentThread().getName() + ".");
			t2.join(); 
	        System.out.println("\n***: " + t2.getName() + " just terminated and joined with " + Thread.currentThread().getName() + ".");
		} catch (InterruptedException e) {
		}
        
        System.out.println("\n***: " + Thread.currentThread().getName() + " just terminated.");
    }
}