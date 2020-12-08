package u05_Buffer.blocking;

public class Semaphore {
	private String name;
    private int value;

    public Semaphore(int init, String name)  {
        if(init < 0) throw new IllegalArgumentException("Parameter < 0");
        this.value = init;
        this.name = name;
    }

    public synchronized void p()  {
        while(value == 0)  {
            try {
            	System.out.println("" + System.currentTimeMillis() + "\t" + Thread.currentThread().getName() + " has to wait on " + name);
                wait();
            } catch(InterruptedException e){
            }
        }
        value--;
    }

    public synchronized void v()  {
        value++;
        notify();
    }
}