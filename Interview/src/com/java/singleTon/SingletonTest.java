package com.java.singleTon;

import java.util.HashSet;
import java.util.Set;

public class SingletonTest {

    public static void main(String[] args) throws InterruptedException {
        // Create a number of threads that attempt to get Singleton instances concurrently
        int threadCount = 100;
        Thread[] threads = new Thread[threadCount];

        // Store instances to check if multiple instances are created
        Set<SingletonLazySync> instances = new HashSet<>();

        // Create and start threads
        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread(() -> {
            	SingletonLazySync instance = SingletonLazySync.getInstance();
                instances.add(instance);
            });
            threads[i].start();
        }

        // Wait for all threads to finish
        for (int i = 0; i < threadCount; i++) {
            threads[i].join();
        }

        // Check how many unique instances are created
        System.out.println("Number of unique instances created : " + instances.size());
    }
}

