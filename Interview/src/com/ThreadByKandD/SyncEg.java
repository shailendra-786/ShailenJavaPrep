package com.ThreadByKandD;

class Reseverd implements Runnable {
	int wantend;
	int available = 1;

	public Reseverd(int wantend) {
		this.wantend = wantend;
	}

	@Override
	synchronized public void run() {
		System.out.println("Available " + available);
		if (available >= wantend) {
			System.out.println("Get Thread Name " + Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
				available -= wantend;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Oops no ticket for "+Thread.currentThread().getName());
		}
	}
}

public class SyncEg {

	public static void main(String[] args) {
		Reseverd r = new Reseverd(1);

		Thread t = new Thread(r, "kavi");
		Thread t1 = new Thread(r, "Anil");

		t.start();
		t1.start();
	}

}
