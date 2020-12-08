//C.Bach, 11.11.2015

package src.ConcurrencyBasics.ex05_synchronized;


public abstract class Bank {
	public  Account[] accounts;


	public Bank(int noOfAccounts) {
		accounts = new Account[noOfAccounts];
		for (int i = 0; i < accounts.length; i++) {
			accounts[i] = new Account();
		}
	}


	public abstract void transferMoney(int accountNumber, float amount);
	
}

