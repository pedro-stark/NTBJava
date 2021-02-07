package Thread.ex06_semaphore_mutex;

public class Semaphore {
    private int value;
    public Semaphore(int init)  {
        if(init < 0) throw new IllegalArgumentException("Parameter < 0");
        value = init;
    }
    public synchronized void p()  {
        while(value == 0)  {
            try {
            	System.out.println("Semaphore ist voll. Aufrufender Thread wird zum warten angewiesen.");
                wait();
            } catch(InterruptedException e){
            }
        }
        value--;
    }
    public synchronized void v()  {
        value++;
    	System.out.println("Aufrufender Thread verlässt Semaphore. Ein Platz ist frei geworden");
        notifyAll();
    	//notify();
    }
}