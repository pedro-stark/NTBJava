package src.ConcurrencyBasics.u05_Buffer.blocking;

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
        
        //TODO erzeugen Sie hier die Semaphore Objekte. Wie muss der jeweilige Value gesetzt werden?
    }

    public void put(int x)     {
    	//TODO: welche Semaphore brauchen Sie zum Schutz des Ablegens?
    }

    public int get()  {
    	//TODO: welche Semaphore brauchen Sie zum Schutz des Abholens?
        return 0;
    }
}