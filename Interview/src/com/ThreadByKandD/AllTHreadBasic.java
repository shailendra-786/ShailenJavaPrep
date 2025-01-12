package com.ThreadByKandD;

class Task extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("Calling thread " + Thread.currentThread().getName());
			try {
				Thread.sleep(500); // sleep is static method. checked exception . sleep method pause thread for
									// finite amount of time
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}

public class AllTHreadBasic {
	public static void main(String[] args) throws InterruptedException {
		Task task = new Task();
		Thread t = new Thread(task, "shailendra");
		task.run();// if directly call then it will not take part in thread execution its normal
					// call when we call with start then only it will be taking part in thread

		task.start(); // you can call this way because parent property is shared to child
		t.start();
//		by checking sysout you will get big picture
//		t.start(); // if you call this you will get error because thread is dead
// 		task.start(); // same goes for this too
		Task task1 = new Task();
		Thread t1 = new Thread(task1, "apoorva");
		t1.start();
		t1.join();
		t.join();
		Thread t2 = new Thread() {
			public void run() {
				System.out.println("annonymous class called here ");
			}
		};
		
		t2.start();
		
		Thread t3 = new Thread(()->{
			System.out.println("no idea what we call this ");
		});
		t3.start();
		
		Runnable runnable = () -> {
		    System.out.println("This is an anonymous function using a lambda expression.");
		};
		
		Thread t4 = new Thread(runnable);
		t4.start();
		Runnable runnable1 = new Runnable() {
		    @Override
		    public void run() {
		        System.out.println("This is an anonymous function using an anonymous inner class.");
		    }
		};
		Thread t5 = new Thread(runnable1);
		t5.start();
	}
}
