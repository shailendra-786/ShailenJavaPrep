package com.java.multiThread;

import java.util.ArrayList;
import java.util.List;

 class PrimeNumber implements Runnable {
	private int start;
	private int end;
	private int primeCount;

	public PrimeNumber(int start, int end) {
		this.start = start;
		this.end = end;
	}

	// Method to check if a number is prime
	private boolean isPrime(int number) {
		if (number <= 1)
			return false;
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0)
				return false;
		}
		return true;
	}

	@Override
	public void run() {
		for (int i = start; i <= end; i++) {
			if (isPrime(i)) {
				primeCount++;
			}
		}
		System.out.println(
				Thread.currentThread().getName() + " found " + primeCount + " primes in range " + start + " to " + end);
	}

	public int getPrimeCount() {
		return primeCount;
	}

	@Override
	public String toString() {
		return "PrimeNumber [start=" + start + ", end=" + end + ", primeCount=" + primeCount + "]";
	}
	
}

 public class PrimeNumberCounter {
	public static void main(String[] args) throws InterruptedException {
		int rangeStart = 1;
		int rangeEnd = 1000;
		int numberOfThreads = 4;

		// Calculate range for each thread
		int rangePerThread = (rangeEnd - rangeStart + 1) / numberOfThreads;
		System.out.println(rangePerThread);
		List<Thread> threads = new ArrayList<>();
		List<PrimeNumber> tasks = new ArrayList<>();

		// Create threads
		for (int i = 0; i < numberOfThreads; i++) {
			int start = rangeStart + i * rangePerThread;
			int end = (i == numberOfThreads - 1) ? rangeEnd : start + rangePerThread - 1;
			PrimeNumber task = new PrimeNumber(start, end);
			tasks.add(task);

			Thread thread = new Thread(task, "Thread-" + (i + 1));
			threads.add(thread);
		}
		System.out.println(tasks.toString());
		// Start all threads
		for (Thread thread : threads) {
			thread.start();
		}

		// Wait for all threads to finish
		for (Thread thread : threads) {
			thread.join();
		}

		// Calculate total prime count
		int totalPrimes = tasks.stream().mapToInt(PrimeNumber::getPrimeCount).sum();
		System.out.println("Total primes in range " + rangeStart + " to " + rangeEnd + ": " + totalPrimes);
	}
}
