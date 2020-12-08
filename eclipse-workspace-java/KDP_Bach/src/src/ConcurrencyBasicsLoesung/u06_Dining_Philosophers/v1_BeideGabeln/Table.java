package src.ConcurrencyBasicsLoesung.u06_Dining_Philosophers.v1_BeideGabeln;

class Table {
    private boolean[] forkUsed;

    private int left(int i)  {
        return i;
    }

    private int right(int i)  {
    	return (i + 1) % forkUsed.length;
    }

    public Table(int number)  {
        forkUsed = new boolean[number];
        for(int i = 0; i < forkUsed.length; i++) forkUsed[i] = false;
    }

    public synchronized void takeFork(int number)  {
        while(forkUsed[left(number)] || forkUsed[right(number)]) { 
            try  { wait(); } catch(InterruptedException e) { }
        }
        forkUsed[left(number)] = true;
        forkUsed[right(number)] = true;
    }

    public synchronized void putFork(int number)  {
        forkUsed[left(number)] = false;
        forkUsed[right(number)] = false;
        notifyAll();
    }
}