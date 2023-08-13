package com.thread;

public class RunnableThread implements Runnable {

	@Override
	public void run() {
		System.out.println("enter into thread");
		for (int i = 0; i < 5; i++)
			System.out.println("kamal");
		System.out.println("aptech");
	}

	public static void main(String[] args) {
		System.out.println("main thread is called");
		RunnableThread t = new RunnableThread();
		Thread t1 = new Thread(t);
		t1.start();
		RunnableThread tc = new RunnableThread();
		Thread t2 = new Thread(tc);
		t2.start();
	}

}
