//C.Bach, 11.11.2015

package src.ConcurrencyBasics.ex03_Sleep;

public class Loop extends Thread
{
	private int sleeptime;
	
    public Loop(String name, int sleeptime)  {
        super(name);
        this.sleeptime = sleeptime;
    }

    public void run()  {
        for(int i = 1; i <= 10; i++)  {
            System.out.print(getName() + " (" + i + ") ");
            
            //TODO: hier Aufruf von sleep mit sleeptime einbauen
        }
    }

    public static void main(String[] args)
    {
    	//Experimentieren Sie mit unterschiedlichen Zeiten, dass stabil a, b, c, a, b, c, ... ausgegeben wird
        Loop t1 = new Loop("a", 100); 
        Loop t2 = new Loop("b", 100); 
        Loop t3 = new Loop("c", 100);
        t1.start(); 
        t2.start();
        t3.start();
    }
}