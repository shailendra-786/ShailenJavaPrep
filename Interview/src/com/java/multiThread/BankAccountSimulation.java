package com.java.multiThread;

class BankAccount {
	private int balance;

	public BankAccount(int initialBalance) {
		this.balance = initialBalance;
	}

	// Deposit method
	public synchronized void deposit(int amount) {
		if (amount > 0) {
			balance += amount;
			System.out.println(
					Thread.currentThread().getName() + " deposited " + amount + ". Current balance: " + balance);
			notifyAll(); // Notify waiting threads
		}
	}

	// Withdraw method
	public synchronized void withdraw(int amount) {
		while (balance < amount) {
			try {
				System.out.println(Thread.currentThread().getName() + " waiting to withdraw " + amount
						+ ". Insufficient balance.");
				wait(); // Wait until sufficient balance is available
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		balance -= amount;
		System.out.println(Thread.currentThread().getName() + " withdrew " + amount + ". Current balance: " + balance);
	}

	// Get current balance
	public synchronized int getBalance() {
		return balance;
	}
}

public class BankAccountSimulation {
	public static void main(String[] args) {
		BankAccount account = new BankAccount(100); // Initial balance of 100

		// Thread for deposits
		Thread depositor = new Thread(() -> {
			int[] deposits = { 50, 100, 150 };
			for (int amount : deposits) {
				account.deposit(amount);
				try {
					Thread.sleep(500); // Simulate delay
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "Depositor");

		// Thread for withdrawals
		Thread withdrawer = new Thread(() -> {
			int[] withdrawals = { 70, 200, 80 };
			for (int amount : withdrawals) {
				account.withdraw(amount);
				try {
					Thread.sleep(800); // Simulate delay
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "Withdrawer");

		depositor.start();
		withdrawer.start();
	}
}
