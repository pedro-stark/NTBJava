package ex10_deadlocks;

public class Deadlock_Sol2_PreventionByVictim {

	public static void main(String[] args) {
		//gegeben der Betriebsmittelgraph aus der Folie

		Semaphore resource_a = new Semaphore(1, "A");
		Semaphore resource_b = new Semaphore(1, "B");

		Thread thread_s = new Thread(
				() -> { 
					try {
						resource_a.pWithThrow(); 
						s(500);
						resource_b.pWithThrow(); 
						s(500);
					} catch (InterruptedException e) {
					} finally {
						resource_b.v(); 
						resource_a.v();
					}
				}, 
				"S");

		Thread thread_t = new Thread(
				() -> { 
					try {
						resource_b.pWithThrow(); 
						s(500);
						resource_a.pWithThrow(); 
						s(500);
					} catch (InterruptedException e) {
					} finally {
						resource_b.v(); 
						resource_a.v();
					}
				}, 
				"T");
		
		
		thread_s.start();
		thread_t.start();
		
		try { s(5000); } catch (InterruptedException e) {}
		System.out.println(thread_s.getName() + " choosen as Deadlock Victim");
		thread_s.interrupt();

	}

	public static void s(int sleeptime) throws InterruptedException {
		Thread.sleep(sleeptime);
	}
	
}
