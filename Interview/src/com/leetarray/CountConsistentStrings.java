package com.leetarray;

import java.util.HashSet;
import java.util.Set;

public class CountConsistentStrings {
    public int countConsistentStrings(String allowed, String[] words) {
        int count = 0;
        Set<Character> allowedSet = new HashSet<>();

        // Create a set of allowed characters for efficient lookup
        for (char ch : allowed.toCharArray()) {
            allowedSet.add(ch);
        }

        // Iterate through each word
        for (String word : words) {
            boolean isConsistent = true;

            // Check each character of the word
            for (char ch : word.toCharArray()) {
                // If the character is not present in the allowed set, break the loop
                if (!allowedSet.contains(ch)) {
                    isConsistent = false;
                    break;
                }
            }

            // If all characters are present in the allowed set, increment the count
            if (isConsistent) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        CountConsistentStrings solution = new CountConsistentStrings();
        String allowed = "ab";
        String[] words = {"ad", "bd", "aaab", "baa", "badab"};
        int count = solution.countConsistentStrings(allowed, words);
        System.out.println("Number of Consistent Strings: " + count);
    }
}
