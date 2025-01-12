package com.streamapi.streamApi2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringAdvance {

	public static void main(String[] args) {
		// Group Strings by Length
		String[] arr = { "java", "stream", "api", "map" };

		Map<Integer, List<String>> groupedByLength = Stream.of(arr).collect(Collectors.groupingBy(String::length));
		System.out.println(groupedByLength);

		// Join Strings with a Delimiter
		String strDelimiter = Stream.of(arr).collect(Collectors.joining(","));
		System.out.println(strDelimiter);

		// Find Duplicate Strings
		String[] arr2 = { "java", "stream", "java", "api", "stream" };
		Set<String> seen = new HashSet<>();
		Predicate<String> checkDuplicate = w -> !seen.add(w);
		String[] duplicateFromArray = Arrays.stream(arr2).filter(checkDuplicate).toArray(String[]::new);
		System.out.println(Arrays.toString(duplicateFromArray));

//		Set<String> seen1 = new HashSet<>();
//		Set<String> duplicates = Arrays.stream(arr2).peek(w -> System.out.println("Processing: " + w)).filter(w -> {
//			boolean isAdded = seen1.add(w); // Attempt to add to 'seen'
//			System.out.println("Adding to seen: " + w + " -> " + isAdded);
//			return !isAdded; // Keep it if it’s a duplicate
//		}).peek(w -> System.out.println("Duplicate found: " + w)).collect(Collectors.toSet());
//
//		System.out.println("Duplicates: " + duplicates);

		// Check for Palindromes in a List
		String[] arr3 = { "madam", "apple", "racecar", "banana" };
		Predicate<String> checkPalindrom = str -> {
			int left = 0;
			int right = str.length() - 1;
			while (left < right) {
				if (str.charAt(left) != str.charAt(right)) {
					return false;
				}
				left++;
				right--;
			}
			return true;
		};

		String[] arrOfPalindrom = Stream.of(arr3).filter(checkPalindrom).toArray(String[]::new);
		System.out.println(Arrays.toString(arrOfPalindrom));

		// Frequency of Each Character
		String str = "banana";
		Map<Character, Long> mapChars = str.chars() // produce intstream
				.mapToObj(c -> (char) c) // Convert each int to a char
				.collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		System.out.println(mapChars);
		
		Map<String, Long> map = Pattern.compile("").splitAsStream(str).filter(c -> !c.isEmpty())
				.collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		System.out.println(map);
	}

}
