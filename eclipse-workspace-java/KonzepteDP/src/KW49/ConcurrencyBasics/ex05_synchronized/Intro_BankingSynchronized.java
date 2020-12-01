//C.Bach, 19.11.2019

package KW49.ConcurrencyBasics.ex05_synchronized;

public class Intro_BankingSynchronized {
	public static Integer balance;
	
	public static void main(String[] args) {
		balance = 550;
		
		int i = 0;
		while (i < 1000) {
			balance = 150;
			
			Thread t1 = new Thread(() -> { synchronized(balance) { balance += 500; } } ,"1");
			Thread t2 = new Thread(() -> { synchronized(balance) { balance -= 100; } } ,"2");
			
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