//C.Bach, 11.11.2015

package Thread.ex05_synchronized;

import java.util.Random;

public class Clerk extends Thread {
	private Bank bank;
	private int noOfTransfers;
	private Random randomWaitTime;

	public Clerk(String name, Bank bank, int noOfTransfers) {
		super(name);
		this.bank = bank;
		this.noOfTransfers = noOfTransfers;
		this.randomWaitTime = new Random();
	}

	public void run() {
		for (int i = 0; i < noOfTransfers; i++) {
			/*
			 * Kontonummer einlesen; simuliert durch Wahl einer Zufallszahl 
			 */
			int accountNumber = (int) (Math.random() * bank.accounts.length);

			/*
			 * Überweisungsbetrag einlesen; simuliert durch Wahl einer Zufallszahl zwischen -500 und +499
			 */
			float amount = (int) (Math.random() * 1000) - 500;

			bank.transferMoney(accountNumber, amount);
			
			/*
				System.out.println("" + System.currentTimeMillis() + ": " + Thread.currentThread().getName() + " transfer "+ amount + " to " + accountNumber + 
					"; new balance: " + bank.account[accountNumber].getBalance());
			*/			
		}
	}
}

