package com.streamapi;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class HashMapStreamExample {
    public static void main(String[] args) {
        // Create a sample HashMap
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Alice", 25);
        hashMap.put("Bob", 30);
        hashMap.put("Charlie", 20);
        hashMap.put("David", 40);
        hashMap.put("Eve", 35);

        // Example 1: Iterate over the HashMap using Stream forEach
        System.out.println("Example 1:");
        hashMap.forEach((key, value) -> System.out.println(key + ": " + value));

        // Example 2: Filter elements based on a condition using Stream filter
        System.out.println("\nExample 2:");
        Map<String, Integer> filteredMap = hashMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue() >= 30)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        filteredMap.forEach((key, value) -> System.out.println(key + ": " + value));

        // Example 3: Perform some operation on each element using Stream map
        System.out.println("\nExample 3:");
        hashMap.entrySet()
                .stream()
                .map(entry -> entry.getKey() + " (Age: " + entry.getValue() + ")")
                .forEach(System.out::println);

        // Example 4: Reduce the HashMap to a single value using Stream reduce
        System.out.println("\nExample 4:");
        int totalAge = hashMap.values()
                .stream()
                .reduce(0, Integer::sum);
        System.out.println("Total Age: " + totalAge);

        // Example 5: Sort the HashMap based on values using Stream sorted
        System.out.println("\nExample 5:");
        hashMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}
