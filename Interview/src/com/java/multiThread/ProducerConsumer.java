package com.java.multiThread;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {

    // Shared buffer
    private final Queue<Integer> buffer = new LinkedList<>();
    private final int MAX_SIZE = 5; // Maximum buffer size

    // Producer class
    class Producer extends Thread {
        @Override
        public void run() {
            int value = 0;
            while (true) {
                synchronized (buffer) {
                    while (buffer.size() == MAX_SIZE) {
                        try {
                            System.out.println("Buffer is full. Producer is waiting...");
                            buffer.wait(); // Wait if buffer is full
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println("Producer produced: " + value);
                    buffer.add(value++);
                    buffer.notifyAll(); // Notify consumer
                }

                try {
                    Thread.sleep(500); // Simulate time taken to produce
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Consumer class
    class Consumer extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (buffer) {
                    while (buffer.isEmpty()) {
                        try {
                            System.out.println("Buffer is empty. Consumer is waiting...");
                            buffer.wait(); // Wait if buffer is empty
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    int value = buffer.poll();
                    System.out.println("Consumer consumed: " + value);
                    buffer.notifyAll(); // Notify producer
                }

                try {
                    Thread.sleep(800); // Simulate time taken to consume
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ProducerConsumer pc = new ProducerConsumer();

        Producer producer = pc.new Producer();
        Consumer consumer = pc.new Consumer();

        producer.start();
        consumer.start();
    }
}

