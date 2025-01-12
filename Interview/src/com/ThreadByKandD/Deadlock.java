package com.ThreadByKandD;

class BookTicket extends Thread {
	Object book;
	Object cancel;

	public BookTicket(Object book, Object cancel) {
		this.book = book;
		this.cancel = cancel;
	}

	@Override
	public void run() {
		synchronized (book) {
			System.out.println("Book ticket is locked");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (cancel) {
				System.out.println("Cancel is locked");

			}
		}
	}
}

class CancelTicket extends Thread {
	Object book;
	Object cancel;

	public CancelTicket(Object book, Object cancel) {
		this.book = book;
		this.cancel = cancel;
	}

	@Override
	public void run() {
		synchronized (cancel) {
			System.out.println("Cancel ticket is locked");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (book) {
				System.out.println("Book is locked");

			}
		}
	}
}

public class Deadlock {
	public static void main(String[] args) {
		Object o1 = new Object();
		Object o2 = new Object();
		BookTicket b = new BookTicket(o1, o2);
		CancelTicket c = new CancelTicket(o1, o2);
		Thread t = new Thread(b);
		Thread t1 = new Thread(c);
		t.start();
		t1.start();
		
	}
}
