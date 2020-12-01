//C.Bach, 11.11.2015

package KW49.ConcurrencyBasics.ex05_synchronized;

public class Account {
	private float balance; // Kontostand

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public float getBalance() {
		return balance;
	}
}
