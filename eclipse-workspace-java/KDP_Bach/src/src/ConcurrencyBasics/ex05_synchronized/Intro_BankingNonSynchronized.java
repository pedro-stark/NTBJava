//C.Bach, 19.11.2019

package src.ConcurrencyBasics.ex05_synchronized;

public class Intro_BankingNonSynchronized {
	public static Integer balance;
	
	public static void main(String[] args) {
		balance = 550;
		
		int i = 0;
		while (i < 10000) {
			balance = 150;
			
			Thread t1 = new Thread(() -> { balance += 500; } ,"1");
			Thread t2 = new Thread(() -> { balance -= 100; } ,"2");
			
			t1.start();
			t2.start();
			
			try {
				t1.join();
				t2.join();
			} catch (InterruptedException e) {
			}

			if (balance != 550) System.out.println("" + i + ": " + balance);
			i++;
		}
		
		System.out.println("done");
	}
}