package com.streamapi;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class HashMapStreamExample1 {
    public static void main(String[] args) {
        // Create a sample HashMap
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Alice", 25);
        hashMap.put("Bob", 30);
        hashMap.put("Charlie", 20);
        hashMap.put("David", 40);
        hashMap.put("Eve", 35);

        // Example 1: Collect to List
        System.out.println("Example 1:");
        java.util.List<String> namesList = hashMap.keySet().stream()
                .collect(Collectors.toList());
        System.out.println(namesList);

        // Example 2: Map values to a new list
        System.out.println("\nExample 2:");
        java.util.List<Integer> incrementedAges = hashMap.values().stream()
                .map(age -> age + 1)
                .collect(Collectors.toList());
        System.out.println(incrementedAges);

        // Example 3: Filter elements based on a condition and collect to Map
        System.out.println("\nExample 3:");
        Map<String, Integer> filteredMap = hashMap.entrySet().stream()
                .filter(entry -> entry.getValue() >= 30)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println(filteredMap);

        // Example 4: Find the maximum age using max
        System.out.println("\nExample 4:");
        int maxAge = hashMap.values().stream()
                .max(Integer::compareTo)
                .orElse(0);
        System.out.println("Maximum age: " + maxAge);

        // Example 5: Group by age and collect to Map of Lists
        System.out.println("\nExample 5:");
        Map<Integer, java.util.List<String>> ageGroupMap = hashMap.entrySet().stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue,
                        Collectors.mapping(Map.Entry::getKey, Collectors.toList())));
        System.out.println(ageGroupMap);

        // Example 6: Partition into two groups based on age
        System.out.println("\nExample 6:");
        Map<Boolean, java.util.List<Map.Entry<String, Integer>>> partitionedMap = hashMap.entrySet().stream()
                .collect(Collectors.partitioningBy(entry -> entry.getValue() >= 30));
        System.out.println(partitionedMap);

        // Example 7: Concatenate two streams
        System.out.println("\nExample 7:");
        Map<String, Integer> additionalMap = new HashMap<>();
        additionalMap.put("Frank", 50);
        additionalMap.put("Grace", 22);

        Map<String, Integer> concatenatedMap = java.util.stream.Stream.concat(hashMap.entrySet().stream(), additionalMap.entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (existingValue, newValue) -> newValue));
        System.out.println(concatenatedMap);
    }
}
