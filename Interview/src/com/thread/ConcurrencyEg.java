package com.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class S1 implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("s1 " + i*i);
		}
	}
}

class C1 implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		for (int i = 0; i < 5; i++) {
			System.out.println("c1 " + i * i * i);
		}

		return null;
	}
}

public class ConcurrencyEg {

	public static void main(String[] args) {
		ExecutorService es1 = Executors.newFixedThreadPool(2);
		es1.submit(new S1());
		es1.submit(new C1());
		es1.shutdown();
	}

}
