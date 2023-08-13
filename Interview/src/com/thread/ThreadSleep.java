package com.thread;

public class ThreadSleep extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			try {
				System.out.println("Get current thread name " + Thread.currentThread().getName());
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		ThreadSleep t1 = new ThreadSleep();
		Thread th1 = new Thread(t1, "kavi");
		th1.start();

		ThreadSleep t2 = new ThreadSleep();
		Thread th2 = new Thread(t2);
		th2.setName("Ravi");
		th2.start();
	}
}
