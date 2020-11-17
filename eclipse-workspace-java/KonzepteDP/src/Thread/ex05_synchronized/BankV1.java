//C.Bach, 11.11.2015

package Thread.ex05_synchronized;


public class BankV1 extends Bank {
	public BankV1(int noOfAccounts) {
		super(noOfAccounts);
	}

	//Lock auf dem Bank-Objekt
	public synchronized void transferMoney(int accountNumber, float amount) {
		float oldBalance = accounts[accountNumber].getBalance(); 
		float newBalance = oldBalance + amount; 
		accounts[accountNumber].setBalance(newBalance);

		try { Thread.sleep(10); } catch (Exception ex) {}
	}

}

