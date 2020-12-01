package KW49.ConcurrencyBasics.ex10_deadlocks;

public class Semaphore {
    private int value;
    private String name;

    public Semaphore(int init, String name)  {
        this.value = init;
        this.name = name;
    }

    public synchronized void p() {
        while(value == 0)  {
	        System.out.println(Thread.currentThread().getName() + " waits for " + name);
	        try { wait(); } catch (InterruptedException e) {}
        }
        System.out.println(Thread.currentThread().getName() + " got " + name);
        value--;
    }

    public synchronized void pWithThrow() throws InterruptedException {
        while(value == 0)  {
	        System.out.println(Thread.currentThread().getName() + " waits for " + name);
	        wait();
        }
        System.out.println(Thread.currentThread().getName() + " got " + name);
        value--;
    }

    public synchronized void v()  {
        value++;
        System.out.println(Thread.currentThread().getName() + " released " + name);
        notify();
    }
}