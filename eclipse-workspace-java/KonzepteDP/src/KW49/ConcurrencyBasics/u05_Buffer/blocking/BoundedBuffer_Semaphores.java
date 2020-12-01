package KW49.ConcurrencyBasics.u05_Buffer.blocking;

public class BoundedBuffer_Semaphores implements BoundedBuffer {
    private int head;
    private int tail;
    private int[] data;

    private Semaphore freePlaces;
    private Semaphore filledPlaces;

    public BoundedBuffer_Semaphores(int n)   {
        if(n <= 0) throw new IllegalArgumentException("Parameter <= 0");
        data = new int[n];
        
        head = 0;
        tail = 0;
        
        freePlaces = new Semaphore(n, "freePlaces-Sem");
        filledPlaces = new Semaphore(0, "filledPlaces-Sem");
    }

    public void put(int x)     {
    	freePlaces.p();
    	
        data[head] = x;       
        System.out.println("" + System.currentTimeMillis() + "\t" + Thread.currentThread().getName() + " put " + x + " at " + head);
        
        head = (head+ 1) % data.length;
        
        filledPlaces.v();
    }

    public int get()  {
    	filledPlaces.p();

    	int result = data[tail];
        System.out.println("" + System.currentTimeMillis() + "\t" + Thread.currentThread().getName() + " got " + result + " from " + tail);
        
        tail++; if(tail == data.length) { tail = 0; }
        
        freePlaces.v();
        return result;
    }
}