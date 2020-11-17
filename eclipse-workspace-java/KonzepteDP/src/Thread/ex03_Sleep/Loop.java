//C.Bach, 11.11.2015

package Thread.ex03_Sleep;

public class Loop extends Thread
{
    public Loop(String name)  {
        super(name);
    }

    public void run()  {
        for(int i = 1; i <= 10; i++)  {
            System.out.print(getName() + " (" + i + ") ");
            try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
        }
    }

    public static void main(String[] args)
    {
        Loop t1 = new Loop("a"); 
        Loop t2 = new Loop("b"); 
        Loop t3 = new Loop("c");
        t1.start(); 
        t2.start();
        t3.start();
    }
}