package Thread.ex10_deadlocks;

public class Deadlock_Sol3_PreventionByOrdering {

	public static void main(String[] args) {
		//gegeben der Betriebsmittelgraph aus der Folie

		Semaphore resource_a = new Semaphore(1, "A");
		Semaphore resource_b = new Semaphore(1, "B");

		Thread thread_s = new Thread(
				() -> { 
					resource_a.p(); 
					s(500);
					resource_b.p(); 
					s(500);
					resource_b.v(); 
					resource_a.v(); 
				}, 
				"S");

		Thread thread_t = new Thread(
				() -> { 
					resource_a.p(); 
					s(500);
					resource_b.p(); 
					s(500);
					resource_b.v(); 
					resource_a.v(); 
				}, 
				"T");
		
		
		thread_s.start();
		thread_t.start();

	}

	public static void s(int sleeptime) {
		try { 
			Thread.sleep(sleeptime); 
		} catch (Exception e) {
		}
	}
	
}
