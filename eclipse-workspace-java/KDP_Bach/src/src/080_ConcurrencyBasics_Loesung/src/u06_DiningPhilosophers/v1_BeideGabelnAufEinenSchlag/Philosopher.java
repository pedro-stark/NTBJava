package u06_DiningPhilosophers.v1_BeideGabelnAufEinenSchlag;

enum PhilosopherState {
	eating, thinking, waiting
}

class Philosopher extends Thread
{
    private Table table;
    private int number;

    private PhilosopherState state;
    private long lastEatTime;

    public Philosopher(Table table, int number)
    {
        this.table = table;
        this.number = number;
        this.state = PhilosopherState.waiting;
        this.lastEatTime = 0;
    }

    public void run()  {
    	lastEatTime = System.currentTimeMillis(); 
        while(true)  {
            think(number);
            
            this.state = PhilosopherState.waiting;
            table.takeFork(number);
            
            eat(number);
            
            table.putFork(number);
        }
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
        
        long t = System.currentTimeMillis(); long d = t - lastEatTime; lastEatTime = t;
        System.out.println("Philosoph " + number + " isst wieder nach "+ d);
        
        try {
            sleep((int) (1000+Math.random() * 1000));
        } catch(InterruptedException e) {
        }
    }
    
    public String toString() {
        return "P " + number + ": " + state; 
    }
}