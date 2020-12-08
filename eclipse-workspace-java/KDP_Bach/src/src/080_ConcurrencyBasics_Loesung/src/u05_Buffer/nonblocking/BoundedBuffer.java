package u05_Buffer.nonblocking;

public class BoundedBuffer {
    private int head;
    private int tail;
    private int numberOfElements;
    private int[] data;

    public BoundedBuffer(int n)   {
        if(n <= 0) throw new IllegalArgumentException("Parameter <= 0");
        data = new int[n];
        
        head = 0;
        tail = 0;
        numberOfElements = 0;
    }

    public synchronized void put(int x) throws Exception     {
    	if (numberOfElements == data.length) {
            System.out.println("" + System.currentTimeMillis() + "\t" + Thread.currentThread().getName() + " has to wait");
            throw new Exception("Buffer full. Please wait!");
    	}
    	
        data[head] = x;
        head = (head + 1) % data.length;
        numberOfElements++;
    }

    public synchronized int get() throws Exception  {
        if (numberOfElements == 0)  {
        	System.out.println("" + System.currentTimeMillis() + "\t" + Thread.currentThread().getName() + " has to wait");
            throw new Exception("Buffer empty. Please wait!");
        }
        
        int result = data[tail];
        tail = (tail + 1) % data.length;
        numberOfElements--;
        return result;
    }
}