package com.collection.concurrency;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<>();

        Runnable addTask = () -> {
            for (int i = 0; i < 1000; i++) {
                hashMap.put("Key-" + i, i);
            }
        };

        Runnable removeTask = () -> {
            for (int i = 0; i < 1000; i++) {
                hashMap.remove("Key-" + i);
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

        System.out.println("HashMap size: " + hashMap.size());
    }
}
