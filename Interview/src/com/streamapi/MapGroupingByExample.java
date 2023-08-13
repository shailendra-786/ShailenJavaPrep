package com.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapGroupingByExample {

	public static void main(String[] args) {
		List<String> words = Arrays.asList("apple", "banana", "orange", "kiwi", "grape");

		Map<Integer, List<String>> wordsByLength = words.stream().collect(Collectors.groupingBy(String::length));

		System.out.println(wordsByLength);

		//e.g 1
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		Map<Boolean, List<Integer>> evenAndOddNumbers = numbers.stream()
				.collect(Collectors.groupingBy(num -> num % 2 == 0));

		System.out.println(evenAndOddNumbers);
		
		List<Integer> numbers1 = Arrays.asList(10, 15, 23, 27, 35, 42, 50, 55, 63);

        Map<String, List<Integer>> numbersByOddEven = numbers1.stream()
                .collect(Collectors.groupingBy(num -> num % 2 == 0 ? "Even" : "Odd"));

        System.out.println("Numbers grouped by Odd/Even:");
        System.out.println(numbersByOddEven);
        
        
        String sentence = "This is a simple sentence with repeated words, this is simple and this is a test.";

        // Tokenize the sentence and convert words to lowercase (optional).
        List<String> words1 = Arrays.asList(sentence.split("\\s+"));
        List<String> lowercasedWords = words1.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());

        // Group words and count occurrences.
        Map<String, Long> wordCounts = lowercasedWords.stream()
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

        System.out.println("Count of repeated words:");
        System.out.println(wordCounts);

	}

}
