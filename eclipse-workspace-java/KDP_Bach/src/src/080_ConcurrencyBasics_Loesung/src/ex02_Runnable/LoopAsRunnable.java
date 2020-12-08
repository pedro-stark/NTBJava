//C.Bach, 11.11.2015

package ex02_Runnable;

public class LoopAsRunnable implements Runnable
{
    public LoopAsRunnable()  {
    }

    public void run()  {
        for(int i = 1; i <= 10; i++)  {
            System.out.print(Thread.currentThread().getName() + " (" + i + ") ");
        }
    }
    
    
    public static void main(String[] args) {
        Thread t1 = new Thread(new LoopAsRunnable(), "a"); 
        Thread t2 = new Thread(new LoopAsRunnable(), "b");
        Thread t3 = new Thread(new LoopAsRunnable(), "c");
        t1.start(); 
        t2.start();
        t3.start();
    }
}