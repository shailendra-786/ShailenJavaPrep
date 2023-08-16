package com.streamapi;

import java.util.stream.Stream;

public class GenerateFibonacci {
    public static void main(String[] args) {
        Stream<Integer> fibonacciStream = Stream.generate(new FibonacciSupplier());

        fibonacciStream.limit(10) // Limit the stream to 10 elements
                .forEach(System.out::println);
    }

    static class FibonacciSupplier implements java.util.function.Supplier<Integer> {
        private int a = 0;
        private int b = 1;

        public Integer get() {
            int result = a;
            int next = a + b;
            a = b;
            b = next;
            return result;
        }
    }
}
