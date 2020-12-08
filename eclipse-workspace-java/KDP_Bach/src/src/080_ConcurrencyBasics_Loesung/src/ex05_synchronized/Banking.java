//C.Bach, 11.11.2015

package ex05_synchronized;

public class Banking {
	public static void main(String[] args) throws InterruptedException {
		Bank myBank; Thread t1; Thread t2; long duration;

		int noOfTransfers = 100;
		int noOfAccounts = 10;
		
		double d1 = 0.0;
		double d2 = 0.0;
		int runs = 5;

		for (int i = 0; i < runs; i++) {
			//V1
			myBank = new BankV1(noOfAccounts);
			t1 = new Clerk("Andrea Müller", myBank, noOfTransfers);
			t2 = new Clerk("Petra Schmitt", myBank, noOfTransfers);

			duration = System.currentTimeMillis();
			t1.start(); t2.start(); 
			t1.join(); t2.join();

			duration = System.currentTimeMillis() - duration;
			d1 += duration;
			System.out.println("V1 Laufzeit: " + duration);

			
			//V2
			myBank = new BankV2(noOfAccounts);
			t1 = new Clerk("Andrea Müller", myBank, noOfTransfers);
			t2 = new Clerk("Petra Schmitt", myBank, noOfTransfers);

			duration = System.currentTimeMillis();
			t1.start(); t2.start(); 
			t1.join(); t2.join();

			duration = System.currentTimeMillis() - duration;
			d2 += duration;
			System.out.println("V2 Laufzeit: " + duration);
		}
		
		d1 = d1/runs;
		d2 = d2/runs;
		System.out.println("#Runs: " + runs + "; #Accounts: " + noOfAccounts + "; #Transfers: " + noOfTransfers + "; V1: " + d1 + "; V2: " + d2);

	}
}