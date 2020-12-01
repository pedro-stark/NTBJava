package KW49.ConcurrencyBasics.u06_DiningPhilosophers.v3_MitVerhungern;

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
        for(int i = 0; i < forkUsed.length; i++)
            forkUsed[i] = false;
    }

    public synchronized void takeFork(int number, int maxWaitTime)  {
        while(forkUsed[left(number)] || forkUsed[right(number)]) {
            try  { 			
				//TODO: maximale Zeit warten
				//Wenn diese abgelaufen ist, dann den State auf starved setzen
				//Wie erkennen Sie, dass die Zeit abgelaufen ist? Bzw. dass die Blockade aufgelöst werden konnte?
            	wait(maxWaitTime); 
            	if (true /* TODO */) {
            		//wegen Wartezeit aufgeweckt
            		((Philosopher)Thread.currentThread()).setPhilosopherState(PhilosopherState.starved);
            		return;
            	}
            } catch(InterruptedException e) {
            }
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