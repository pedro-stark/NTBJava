package src.ConcurrencyBasicsLoesung.u06_Dining_Philosophers.v0_deadlock;

public class Philosophers {
	private static final int NUMBER = 5;

	private static Philosopher[] ps;

	public static void main(String[] args) {
		ps = new Philosopher[NUMBER];

		Table table = new Table(NUMBER);
		for (int i = 0; i < NUMBER; i++) {
			ps[i] = new Philosopher(table, i);
		}

		Runnable monitor = new Runnable() {
			public void run() {
				long start = System.currentTimeMillis();
				String s;
				while (true) {
					long t = System.currentTimeMillis() - start;
					s = t + ": ";
					for (int i = 0; i < NUMBER; i++) {
						s = s + ";" + ps[i].toString();
					}
					System.err.println(s);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
					}
				}
			}
		};
		new Thread(monitor).start();

		for (int i = 0; i < NUMBER; i++) {
			ps[i].start();
		}

	}
}