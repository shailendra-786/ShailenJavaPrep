package com.thread;

public class ThreadWithArrowAndAnnonymousClass {

	public static void main(String[] args) {
		Runnable r = new Runnable() {

			@Override
			public void run() {
				System.out.println("runnable...");
			}
		};
		Thread t1 = new Thread(r){
			public void run() {
				System.out.println("thread...");
			}
		};
		t1.start();
		
		Runnable lambdaExpression = ()->{System.out.println("Runnable...");};
		new Thread(lambdaExpression).start();
	}

}
