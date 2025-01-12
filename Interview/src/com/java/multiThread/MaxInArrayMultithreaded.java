package com.java.multiThread;

import java.util.ArrayList;
import java.util.List;

 class MaxFinder implements Runnable {
	private int[] array;
	private int start;
	private int end;
	private int max;

	public MaxFinder(int[] array, int start, int end) {
		this.array = array;
		this.start = start;
		this.end = end;
		this.max = Integer.MIN_VALUE;
	}

	@Override
	public void run() {
		for (int i = start; i <= end; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		System.out.println(Thread.currentThread().getName() + " found max: " + max);
	}

	public int getMax() {
		return max;
	}
}

 public class MaxInArrayMultithreaded {
	public static void main(String[] args) throws InterruptedException {
		int[] array = { 3, 5, 7, 2, 8, 6, 4, 10, 1, 9 };
		int numberOfThreads = 3;

		// Calculate the range for each thread
		int rangePerThread = array.length / numberOfThreads;
		List<Thread> threads = new ArrayList<>();
		List<MaxFinder> tasks = new ArrayList<>();

		// Create and start threads
		for (int i = 0; i < numberOfThreads; i++) {
			int start = i * rangePerThread;
			int end = (i == numberOfThreads - 1) ? array.length - 1 : start + rangePerThread - 1;

			MaxFinder task = new MaxFinder(array, start, end);
			tasks.add(task);

			Thread thread = new Thread(task, "Thread-" + (i + 1));
			threads.add(thread);
			thread.start();
		}

		// Wait for all threads to finish
		for (Thread thread : threads) {
			thread.join();
		}

		// Find the maximum from all threads
		int globalMax = Integer.MIN_VALUE;
		for (MaxFinder task : tasks) {
			if (task.getMax() > globalMax) {
				globalMax = task.getMax();
			}
		}

		System.out.println("Global maximum value in the array: " + globalMax);
	}
}
