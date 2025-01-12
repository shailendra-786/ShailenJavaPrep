package com.ThreadByKandD;

class TotalClass extends Thread {
	int total = 0;

	synchronized public void run() {
		for (int i = 0; i < 5; i++) {
			total += 50;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("call");
		notify();
	}
}

public class WaitAndNotify {
	public static void main(String[] args) {
		TotalClass b = new TotalClass();
		Thread t = new Thread(b);
		t.start();
		synchronized (t) {
			System.out.println("here we calling wait method");
			try {
				t.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(b.total);
		}
	}

}
