package ex10_deadlocks;

public class Deadlock_Sol4_PreventionByGetAllTogether {

	public static void main(String[] args) {
		//gegeben der Betriebsmittelgraph aus der Folie

		Semaphore resource_a = new Semaphore(1, "A");
		Semaphore resource_b = new Semaphore(1, "B");
		
		Semaphore blockAccess = new Semaphore(1, "Helper");

		Thread thread_s = new Thread(
				() -> { 
					blockAccess.p(); resource_a.p(); resource_b.p(); blockAccess.v();
					s(500);
					resource_b.v(); 
					resource_a.v(); 
				}, 
				"S");

		Thread thread_t = new Thread(
				() -> { 
					blockAccess.p(); resource_b.p(); resource_a.p(); blockAccess.v();
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
