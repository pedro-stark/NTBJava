package src.ConcurrencyBasicsLoesung.u06_Dining_Philosophers.v3_mitVerhungern;

enum PhilosopherState {
	eating, thinking, waiting, starved
}

class Philosopher extends Thread
{
    private Table table;
    private int number;
    private int maxWaitTime;

    private PhilosopherState state;

    public Philosopher(Table table, int number, int maxWaitTime)
    {
        this.table = table;
        this.number = number;
        this.state = PhilosopherState.waiting;
        this.maxWaitTime = maxWaitTime;
    }

    public void run()  {
        while(state != PhilosopherState.starved)  {
            think(number);
            
            this.state = PhilosopherState.waiting;
            table.takeFork(number, maxWaitTime);
            if (state == PhilosopherState.starved) break;
            
            eat(number);
            
            table.putFork(number);
        }
        System.out.println("starved: " + number );
    }

    private void think(int number)
    {
        this.state = PhilosopherState.thinking;

        try {
            sleep((int) (1000+Math.random() * 1000));
        }  catch(InterruptedException e)  {
        }
    }

    private void eat(int number) {
        this.state = PhilosopherState.eating;
        try {
            sleep((int) (1000+Math.random() * 1000));
        } catch(InterruptedException e) {
        }
    }
    
    public String toString() {
        return "P " + number + ": " + state; 
    }

	public void setPhilosopherState(PhilosopherState state) {
		this.state = state;
	}
}