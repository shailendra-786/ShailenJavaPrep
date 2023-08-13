package com.collection.concurrency;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ConcurrentMapExample {
	public static void main(String[] args) {
		ConcurrentMap<String, Integer> concurrentMap = new ConcurrentHashMap<>();

		// Insert key-value pairs concurrently
		concurrentMap.put("Alice", 30);
		concurrentMap.put("Bob", 25);
		concurrentMap.put("Charlie", 35);

		// Update values concurrently
		concurrentMap.compute("Alice", (key, value) -> value + 1);

		// Access the value associated with a key concurrently
		int ageOfBob = concurrentMap.get("Bob");
		System.out.println("Age of Bob: " + ageOfBob);

		// Remove a key-value pair concurrently
		concurrentMap.remove("Charlie");

		// Iterate over key-value pairs concurrently
		concurrentMap.forEach((key, value) -> System.out.println(key + " - " + value));
	}
}
