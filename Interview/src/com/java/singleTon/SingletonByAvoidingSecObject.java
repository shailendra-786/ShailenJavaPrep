package com.java.singleTon;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;



public class SingletonByAvoidingSecObject {
	public static void main(String[] args) {
		// Testing singleton in a multithreaded environment
		Runnable task = () -> {
			Singleton instance = Singleton.getInstance();
			System.out.println(Thread.currentThread().getName() + ": " + instance.hashCode());
		};

		Thread thread1 = new Thread(task, "Thread-1");
		Thread thread2 = new Thread(task, "Thread-2");

		thread1.start();
		thread2.start();

		// Testing regular singleton behavior
		Singleton instance1 = Singleton.getInstance();
		Singleton instance2 = Singleton.getInstance();

		System.out.println(instance1 == instance2); // Output: true

		// Testing cloning
		try {
			Singleton instance3 = (Singleton) instance1.clone();
		} catch (Exception e) {
			System.out.println(e.getMessage()); // Output: Singleton instance cannot be cloned
		}

		// Testing serialization
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("singleton.ser"))) {
			out.writeObject(instance1);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("singleton.ser"))) {
			Singleton instance4 = (Singleton) in.readObject();
			System.out.println(instance1 == instance4); // Output: true
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		// Testing reflection
		try {
			Constructor<Singleton> constructor = Singleton.class.getDeclaredConstructor();
			constructor.setAccessible(true); // Bypass private constructor
			Singleton instance5 = constructor.newInstance(); // This will throw an exception
		} catch (Exception e) {
			System.out.println(e.getMessage()); // Output: Instance already created
		}
	}
}
