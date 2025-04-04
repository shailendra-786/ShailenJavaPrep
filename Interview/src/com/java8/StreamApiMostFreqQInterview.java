package com.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamApiMostFreqQInterview {

	public static void main(String[] args) {
		Comparator<Integer> reverse = Comparator.reverseOrder();

//		1. Find the second highest number in a list
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 2, 3, 6, 7, 8, 3);

		Optional<Integer> secondHighest = numbers.stream().sorted(reverse).skip(1).findFirst();
		secondHighest.ifPresent(System.out::println);

//      2. Find duplicate elements in a list
		Set<Integer> unique = new HashSet<>();
		Predicate<Integer> p = num -> !unique.add(num);

		Set<Integer> duplicates = numbers.stream().filter(p).collect(Collectors.toSet());
		System.out.println(duplicates);

//      3. Find the first non-repeating character in a string
		String str = "swiss";
		Predicate<Map.Entry<Character, Long>> p1 = entry -> entry.getValue() == 1;

		Optional<Character> firstNonRepeating = str.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(p1).map(Map.Entry::getKey).findFirst();
		firstNonRepeating.ifPresent(System.out::println);

		// when use boxed
		Optional<Integer> firstNonRepeating1 = str.chars().boxed()
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(entry -> entry.getValue() == 1).map(Map.Entry::getKey).findFirst();
		firstNonRepeating1.ifPresent(System.out::println);

// 		4. Count occurrences of each word in a list
		List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "banana");

		Map<String, Long> wordCount = words.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(wordCount);

//		5. Find the longest word in a list
		List<String> fruits = Arrays.asList("apple", "banana", "cherry", "watermelon", "kiwi");
		Comparator<String> maxLengthComparator = (s1, s2) -> s1.length() - s2.length();
        Comparator<String> lengthComparator = Comparator.comparingInt(String::length);


		Optional<String> longestWord = words.stream().max(maxLengthComparator);
		longestWord.ifPresent(System.out::println);

		


	}

}
