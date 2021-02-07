package Thread.ex06_semaphore_mutex;

class MutexThread extends Thread {
	private Semaphore mutex;

	public MutexThread(int i, Semaphore mutex)  {
		super(""+i);
		this.mutex = mutex;
		start();
	}

	public void run(){
		try {
			while(true)  {
				mutex.p();
				System.out.println(getName() + " hat kritischen Abschnitt betreten");
				sleep(15000/*(int) (Math.random() * 1000)*/);
				mutex.v();
				System.out.println(getName() + " hat kritischen Abschnitt verlassen");


				sleep((int) (Math.random() * 1000));

			}
		} catch(InterruptedException e) {
		}
	}
}
