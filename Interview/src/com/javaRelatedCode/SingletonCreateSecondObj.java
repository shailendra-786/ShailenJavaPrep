package com.javaRelatedCode;

import java.lang.reflect.Constructor;

class SingletonClass1 {
	private static SingletonClass1 instance;

	private SingletonClass1() {
		// Initialization code, if needed
	}

	public static SingletonClass1 getInstance() {
		if (instance == null) {
			instance = new SingletonClass1();
		}
		return instance;
	}

	// Other methods of the SingletonClass1 class
}

public class SingletonCreateSecondObj {
	public static void main(String[] args) {
		try {
			SingletonClass1 firstInstance = SingletonClass1.getInstance();
			System.out.println("First instance: " + firstInstance);

			// Using reflection to create a second instance
			Constructor<SingletonClass1> constructor = SingletonClass1.class.getDeclaredConstructor();
			constructor.setAccessible(true);
			SingletonClass1 secondInstance = constructor.newInstance();
			System.out.println("Second instance: " + secondInstance);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
