package u06_DiningPhilosophers.v0_Deadlock;

class Table {
    private boolean[] forkUsed;

    public Table(int number)  {
        forkUsed = new boolean[number];
        for(int i = 0; i < forkUsed.length; i++)
            forkUsed[i] = false;
    }

    public synchronized void takeFork(int number)  {
        while(forkUsed[number]) {
            try  { wait(); } catch(InterruptedException e) { }
        }
        forkUsed[number] = true;
    }

    public synchronized void putFork(int number)  {
        forkUsed[number] = false;
        notifyAll();
    }
}