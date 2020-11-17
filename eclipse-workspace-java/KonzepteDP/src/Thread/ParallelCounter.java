package Thread;



public class ParallelCounter {
	private static boolean[] array;

	public static double run(int numberOfServers, int sleepTime) {
		int arraySize = array.length;

		// Startzeit messen
		long startTime = System.currentTimeMillis();

		// Feld Threads erzeugen
		Counter[] counters = new Counter[numberOfServers];
		int start = 0;
		int end;
		int howMany = arraySize / numberOfServers;
		for (int i = 0; i < numberOfServers; i++) {
			end = (i < numberOfServers - 1) ? start + howMany - 1 : arraySize - 1;
			counters[i] = new Counter(array, start, end, sleepTime);
			counters[i].start();
			start = end + 1;
		}

		// Synchronisation mit Servern (auf Serverende warten)
		try {
			for (int i = 0; i < numberOfServers; i++) {
				counters[i].join();
			}
		} catch (InterruptedException e) {
		}

		// Gesamtergebnis aus Teilergebnissen berechnen
		int result = 0;
		for (int i = 0; i < numberOfServers; i++) {
			result += counters[i].getResult();
		}

		// Endzeit messen
		long endTime = System.currentTimeMillis();
		double time = (endTime - startTime) / 1000.0;

		// Ergebnis ausgeben
		// System.out.println(String.format("Ergebnis arraysize: %d, servers:
		// %d, sleeptime: %d, result: %d, elapsed %g",
		// arraySize, numberOfServers, sleepTime, result, time));

		return time;
	}

	public static void test1() {
		System.out.println("Array aufbauen");
		int arraySize = 500000000;
		// Feld erzeugen mit zufälliger Mischung aus true (10%) und false (90%)
		array = new boolean[arraySize];
		for (int i = 0; i < arraySize; i++) {
			array[i] = Math.random() < 0.1;
		}

		System.out.println("Start");
		for (int servers = 1; servers < 50; servers++) {
			System.out.println("Servers/Laufzeit[s]:\t" + servers + "\t" + run(servers, 0));
		}
		for (int servers = 50; servers < 100; servers += 10) {
			System.out.println("Servers/Laufzeit[s]:\t" + servers + "\t" + run(servers, 0));
		}
		for (int servers = 100; servers < 1000; servers += 100) {
			System.out.println("Servers/Laufzeit[s]:\t" + servers + "\t" + run(servers, 0));
		}
		for (int servers = 1000; servers < 10000; servers += 1000) {
			System.out.println("Servers/Laufzeit[s]:\t" + servers + "\t" + run(servers, 0));
		}
		System.out.println("Ende");
	}

	public static void test2() {
		System.out.println("Array aufbauen");
		int arraySize = 1000;
		// Feld erzeugen mit zufälliger Mischung aus true (10%) und false (90%)
		array = new boolean[arraySize];
		for (int i = 0; i < arraySize; i++) {
			array[i] = Math.random() < 0.1;
		}

		System.out.println("Start");
		for (int servers = 1; servers < 50; servers++) {
			System.out.println("Servers/Laufzeit[s]:\t" + servers + "\t" + run(servers, 10));
		}
		for (int servers = 50; servers < 100; servers += 10) {
			System.out.println("Servers/Laufzeit[s]:\t" + servers + "\t" + run(servers, 10));
		}
		for (int servers = 100; servers < 1000; servers += 100) {
			System.out.println("Servers/Laufzeit[s]:\t" + servers + "\t" + run(servers, 10));
		}
		for (int servers = 1000; servers < 10000; servers += 1000) {
			System.out.println("Servers/Laufzeit[s]:\t" + servers + "\t" + run(servers, 10));
		}
		System.out.println("Ende");
	}

	public static void main(String[] args) {
		test1();
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		// test2();
	}
}