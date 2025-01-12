package com.java.singleTon;

public final class SingletonLazySync {

	// Static variable to hold the instance
	private static volatile SingletonLazySync instance;

	// Private constructor to prevent external instantiation
	private SingletonLazySync() {
	}

//	// Public method to provide access to the single instance (with synchronization)
//	public static synchronized SingletonLazySync getInstance() {
//		if (instance == null) {
//			instance = new SingletonLazySync();
//		}
//		return instance;
//	}
	public static SingletonLazySync getInstance() {
		if (instance == null) {
			synchronized (SingletonLazySync.class) {
				if (instance == null) {
					instance = new SingletonLazySync();
				}
			}
		}
		return instance;
	}
}
