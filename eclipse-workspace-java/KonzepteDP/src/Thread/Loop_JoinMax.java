//C.Bach, 11.11.2015

package Thread;

public class Loop_JoinMax extends Thread
{
    public Loop_JoinMax(String name)  {
        super(name);
    }

    public void run()  {
        System.out.println("\n***: " + getName() + " just started.");
        for(int i = 1; i <= 10; i++)  {
            System.out.print(getName() + " (" + i + ") ");
            try {
				Thread.sleep(159);
			} catch (InterruptedException e) {
			}
        }
        System.out.println("\n***: " + getName() + " just terminated.");
    }

    public static void main(String[] args)
    {
        System.out.println("***: " + Thread.currentThread().getName() + " just started.");
        Loop_JoinMax t1 = new Loop_JoinMax("a"); 
        Loop_JoinMax t2 = new Loop_JoinMax("b"); 
        Loop_JoinMax t3 = new Loop_JoinMax("c");
        t1.start(); 
        t2.start();
        t3.start();
        
        try {
        	t1.join(1600); //warte maximal 600ms auf t1
        	System.out.println("\n***: " + Thread.currentThread().getName() + " proceeds. "+ t1.getName() + " isAlive: " + t1.isAlive());
		} catch (InterruptedException e) {
		}
        
        System.out.println("\n***: " + Thread.currentThread().getName() + " just terminated.");
    }
}