package com.thread;

public class LifeCycleOfThread {
	public static void main(String[] args) {
		Thread thread = new Thread(() -> {
		    // Thread's task goes here
		});

		//New state: The thread is now in the "New" state after it's created but not started yet.
		
		thread.start(); //runnable- The thread is now in the "Runnable" state.
		
		//Running:- After some time, the operating system schedules the thread and it enters the "Running" state,
		// actively executing its task.
		
		Object lock = new Object();

		Thread thread1 = new Thread(() -> {
		    synchronized (lock) {
		        try {
		            // The thread will wait until another thread notifies it (releases the lock).
		            lock.wait();
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
		    }
		});

		thread1.start(); // The thread is now in the "Runnable" state.

		// Somewhere else in another thread or part of the code:
		synchronized (lock) {
		    lock.notify(); // This will unblock the waiting thread and allow it to continue.
		}
		
		// After the thread has finished its task or explicitly terminated:
//		thread1.join(); // Wait for the thread to finish (optional).
		// The thread is now in the "Terminated" state and cannot be restarted.

		
		
	}

}
