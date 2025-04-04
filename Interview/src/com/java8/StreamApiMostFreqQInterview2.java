package com.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApiMostFreqQInterview2 {

	public static void main(String[] args) {
// 		Finding the Most Frequent Element
		String text = "java streams api example";

		Optional<Map.Entry<Character, Long>> mostFrequent = text.chars().mapToObj(c -> (char) c)
				.filter(Character::isLetter).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet().stream().max(Map.Entry.comparingByValue());

		mostFrequent
				.ifPresent(entry -> System.out.println("Most frequent: " + entry.getKey() + " - " + entry.getValue()));

//   	Merge two lists and remove duplicates
		List<String> list1 = Arrays.asList("apple", "banana", "orange");
		List<String> list2 = Arrays.asList("banana", "grape", "apple");

		List<String> mergedList = Stream.concat(list1.stream(), list2.stream()).distinct().collect(Collectors.toList());

		System.out.println(mergedList);

//		4. Find the Longest Word in a Sentence
		String sentence = "Java Streams API provides functional programming features";

		Optional<String> longestWord = Arrays.stream(sentence.split("[ ]+"))
				.max(Comparator.comparingInt(String::length));

//		5. Reverse Each Word in a Sentence

		String reversedSentence = Arrays.stream(sentence.split("[ ]+"))
				.map(word -> (new StringBuilder(word).reverse()).toString()).collect(Collectors.joining(" "));

//		7. Remove Duplicate Characters from a String

		String str = "programming";

		String uniqueChars = str.chars().mapToObj(c -> (char) c).distinct().map(String::valueOf)
				.collect(Collectors.joining());

//		8. Merge Two Lists and Find Common Elements
		List<Integer> list3 = Arrays.asList(1, 2, 3, 4, 5, 6);
		List<Integer> list4 = Arrays.asList(4, 5, 6, 7, 8, 9);

		Set<Integer> commonElements = list3.stream().filter(list4::contains).collect(Collectors.toSet());

//		9. Sort a List of Strings by Their Last Character
		List<String> words = Arrays.asList("apple", "banana", "cherry", "date");
		List<String> sortedByLastChar = words.stream()
				.sorted((s1, s2) -> Character.compare(s1.charAt(s1.length() - 1), s2.charAt(s2.length() - 1)))
				.collect(Collectors.toList());

		System.out.println(sortedByLastChar);

//		10. Convert a List of Integers to a Single Comma-Separated String

		List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);

		String result = numbers.stream().map(String::valueOf).collect(Collectors.joining(", "));

	}

}
