package com.thread;

class Reserve implements Runnable {
	int available = 1;
	int wanted;

	public Reserve(int i) {
		wanted = i;
	}

	@Override
	synchronized public void run() { // remove synchronized you will see this issue
		System.out.println("available "+available);
		if (available >= wanted) {
			System.out.println(Thread.currentThread().getName() + " available " + available);
			try {
				Thread.sleep(500);
				available -= wanted;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("ticket is not available");
		}
	}
}

public class SynchronizedExample {

	public static void main(String[] args) {
		Reserve r = new Reserve(1);
		Thread t1 = new Thread(r, "kavi");
		Thread t2 = new Thread(r, "ravi");
		t1.start();
		t2.start();
	}

}
