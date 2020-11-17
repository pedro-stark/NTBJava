package Thread.ex06_semaphore_mutex;

class MutexThread extends Thread {
	private Semaphore mutex;

	public MutexThread(int i, Semaphore mutex)  {
		super(""+i);
		this.mutex = mutex;
		start();
	}

	public void run()  {
		try {
			while(true)  {
				mutex.p();
				System.out.println(getName() + " kritischen Abschnitt betreten");
				sleep((int) (Math.random() * 1000));
				System.out.println(getName() + " kritischer Abschnitt wird verlassen");
				mutex.v();

				sleep((int) (Math.random() * 1000));

			}
		} catch(InterruptedException e) {
		}
	}
}
