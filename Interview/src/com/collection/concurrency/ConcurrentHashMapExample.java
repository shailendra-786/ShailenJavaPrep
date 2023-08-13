package com.collection.concurrency;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {
    public static void main(String[] args) {
        Map<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();

        Runnable addTask = () -> {
            for (int i = 0; i < 1000; i++) {
                concurrentHashMap.put("Key-" + i, i);
            }
        };

        Runnable removeTask = () -> {
            for (int i = 0; i < 1000; i++) {
                concurrentHashMap.remove("Key-" + i);
            }
        };

        Thread thread1 = new Thread(addTask);
        Thread thread2 = new Thread(removeTask);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("ConcurrentHashMap size: " + concurrentHashMap.size());
    }
}
