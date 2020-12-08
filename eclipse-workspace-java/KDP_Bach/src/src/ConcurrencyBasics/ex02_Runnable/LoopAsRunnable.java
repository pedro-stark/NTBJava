//C.Bach, 11.11.2015

package src.ConcurrencyBasics.ex02_Runnable;

public class LoopAsRunnable implements Runnable
{
    public LoopAsRunnable()  {
    }

    public void run()  {
    	//TODO
    }
    
    
    public static void main(String[] args) {
        Thread t1 = ???; 
        Thread t2 = ???;
        Thread t3 = ???;
        t1.start(); 
        t2.start();
        t3.start();
    }
}