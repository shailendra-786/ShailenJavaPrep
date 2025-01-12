package com.java.multiThread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Sum extends Thread {
	int start;
	int end;
	int[] arr;
	int sum;

	public Sum(int start, int end, int[] arr) {
		super();
		this.start = start;
		this.end = end;
		this.arr = arr;
		this.sum = 0;
	}

	@Override
	public void run() {
		for (int i = start; i < end; i++) {
			sum += arr[i];
		}
		System.out.println("sum is " + sum + " thread name " + Thread.currentThread().getName());
	}

	public int getSum() {
		return sum;
	}

	@Override
	public String toString() {
		return "Sum [start=" + start + ", end=" + end + ", arr=" + Arrays.toString(arr) + ", sum=" + sum + "]";
	}

}

public class SumMultiThread {

	public static void main(String[] args) {
		int numberOfThread = 4;
		int[] arr = { 1, 2, 3, 4, 5, 6, 67, 7, 8, 9, 10 };
		int threadPerArray = arr.length / numberOfThread;
		List<Sum> tasks = new ArrayList<>();
		List<Thread> threads = new ArrayList<>();
		for (int i = 0; i < numberOfThread; i++) {
			int start = i * threadPerArray;
			int end = (i == numberOfThread - 1) ? arr.length : start + threadPerArray;
			Sum task = new Sum(start, end, arr);
			tasks.add(task);
			Thread thread = new Thread(task, "Thread-" + (i + 1));
			threads.add(thread);

			thread.start();
		}

		for (Thread thread : threads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (Sum task : tasks) {
			System.out.println(task.getSum());
		}

	}

}
