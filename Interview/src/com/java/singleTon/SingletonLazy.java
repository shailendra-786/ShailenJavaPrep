package com.java.singleTon;

public final class SingletonLazy {

	// Volatile variable to ensure visibility of the instance across threads
	private static volatile SingletonLazy instance;

	// Private constructor to prevent external instantiation
	private SingletonLazy() {
	}

	// Public method to provide access to the single instance
	public static SingletonLazy getInstance() {
		if (instance == null) {
			synchronized (SingletonLazy.class) {
				// Double-check if the instance is still null
				if (instance == null) {
					instance = new SingletonLazy();
				}
			}
		}
		return instance;
	}
}
