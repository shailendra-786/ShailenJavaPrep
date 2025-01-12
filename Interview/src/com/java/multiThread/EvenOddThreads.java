package com.java.multiThread;

import java.util.Arrays;

public class EvenOddThreads {

	private static final Object lock = new Object();
	private static int index = 0; // Shared index to process the array
	private static int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }; // Input array

	// Thread to process even numbers
	static class EvenThread extends Thread {
		@Override
		public void run() {
			synchronized (lock) {
				while (index < array.length) {
					if (array[index] % 2 == 0) {
						System.out.println("Even Thread: " + array[index]);
						index++;
						lock.notify(); // Notify the odd thread to proceed
					} else {
						try {
							
							lock.wait(); // Wait until odd thread processes
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
				lock.notify(); // Ensure the other thread exits if waiting
			}
		}
	}

	// Thread to process odd numbers
	static class OddThread extends Thread {
		@Override
		public void run() {
			synchronized (lock) {
				while (index < array.length) {
					if (array[index] % 2 != 0) {
						System.out.println("Odd Thread: " + array[index]);
						index++;
						lock.notify(); // Notify the even thread to proceed
					} else {
						try {
							lock.wait(); // Wait until even thread processes
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
				lock.notify(); // Ensure the other thread exits if waiting
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// Create and start the threads
		Thread evenThread = new EvenThread();
		Thread oddThread = new OddThread();

		evenThread.start();
		oddThread.start();

		// Wait for both threads to finish
		evenThread.join();
		oddThread.join();

		System.out.println("All array elements processed.");
	}
}
