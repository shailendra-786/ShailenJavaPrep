package com.thread;

public class ThreadClass extends Thread {
	@Override
	public void run() {
		System.out.println("enter into thread");
		for(int i =0 ; i<5;i++)
			System.out.println("kamal");
		System.out.println("aptech");
	}
	
	public static void main(String[] args) {
		System.out.println("main thread is called");
		ThreadClass t = new ThreadClass();
		t.start();
		ThreadClass tc = new ThreadClass();
		Thread t2 = new Thread(tc);
		t2.start();
	}
}
