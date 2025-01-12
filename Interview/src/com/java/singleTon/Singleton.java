package com.java.singleTon;

import java.io.ObjectStreamException;
import java.io.Serializable;

final class Singleton implements Serializable, Cloneable {

	// Static variable to hold the single instance
	private static final Singleton INSTANCE = new Singleton();

	// Private constructor to prevent instantiation
	private Singleton() {
		// Prevent instantiation via reflection
		if (INSTANCE != null) {
			throw new IllegalStateException("Instance already created");
		}
	}

	// Public method to provide access to the single instance
	public static Singleton getInstance() {
		return INSTANCE;
	}

	// Prevent cloning
	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("Singleton instance cannot be cloned");
	}

	// Prevent serialization from creating another instance
	private Object readResolve() throws ObjectStreamException {
		return INSTANCE;
	}

	// Prevent deserialization from creating another instance
	private Object writeReplace() throws ObjectStreamException {
		return INSTANCE;
	}
}
