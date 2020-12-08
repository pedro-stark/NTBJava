package u05_Buffer.blocking;

public class BoundedBuffer_Synchronized implements BoundedBuffer {
    private int head;
    private int tail;
    private int numberOfElements;
    private int[] data;

    public BoundedBuffer_Synchronized(int n)   {
        if(n <= 0) throw new IllegalArgumentException("Parameter <= 0");
        data = new int[n];
        
        head = 0;
        tail = 0;
        numberOfElements = 0;
    }

    public synchronized void put(int x)     {
        while(numberOfElements == data.length) {
            try {
                System.out.println("" + System.currentTimeMillis() + "\t" + Thread.currentThread().getName() + " has to wait; buffer full");
                wait();
            } catch(InterruptedException e) {  }
        }
        data[head] = x;
        
        head = (head + 1) % data.length;
        numberOfElements++;
        notifyAll();
    }

    public synchronized int get()  {
        while(numberOfElements == 0)  {
            try {
                System.out.println("" + System.currentTimeMillis() + "\t" + Thread.currentThread().getName() + " has to wait; buffer empty");
                wait();
            } catch(InterruptedException e){  }
        }
        int result = data[tail];

        tail = (tail + 1) % data.length;
        numberOfElements--;
        notifyAll();
        return result;
    }
}