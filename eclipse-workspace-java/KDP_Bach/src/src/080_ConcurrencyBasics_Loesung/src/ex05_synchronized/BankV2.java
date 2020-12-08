//C.Bach, 11.11.2015

package ex05_synchronized;


public class BankV2 extends Bank {
	public BankV2(int noOfAccounts) {
		super(noOfAccounts);
	}


	//besser: Lock auf dem Account (Transfers auf unabh�ngigen Konten k�nnen parallel durchgef�hrt werden
	public void transferMoney(int accountNumber, float amount) {
		synchronized (accounts[accountNumber]) {
			float oldBalance = accounts[accountNumber].getBalance();
			float newBalance = oldBalance + amount;
			accounts[accountNumber].setBalance(newBalance);
			
			try { Thread.sleep(10); } catch (Exception ex) {}
		}
	}
}

