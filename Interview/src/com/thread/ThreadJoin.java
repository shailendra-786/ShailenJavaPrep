package com.thread;

public class ThreadJoin extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			try {
				System.out.println("Get current thread name " + Thread.currentThread().getName());
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		ThreadJoin t1 = new ThreadJoin();
		Thread th1 = new Thread(t1, "kavi");
		th1.start();

		ThreadJoin t2 = new ThreadJoin();
		Thread th2 = new Thread(t2);
		th2.setName("Ravi");
		th2.start();

		try {
			th1.join();
			th2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
