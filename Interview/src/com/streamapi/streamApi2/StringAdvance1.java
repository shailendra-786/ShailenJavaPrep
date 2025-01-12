package com.streamapi.streamApi2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringAdvance1 {

	public static void main(String[] args) {
// ------------------------------------------------------------------------------

		// Longest String Without Repeating Characters
		String[] arr = { "abc", "aabb", "xyz", "abac" };

		Predicate<String> chkStrContainDupliChar = str -> {
			Set<Character> charSet = new HashSet<>();
			for (char c : str.toCharArray()) {
				if (!charSet.add(c)) {
					return false;
				}
			}
			return true;
		};
		String str = Arrays.stream(arr).filter(chkStrContainDupliChar).collect(Collectors.joining(","));
		System.out.println(str);

// ------------------------------------------------------------------------------
		// Top K Frequent Words
		String[] arr1 = { "java", "java", "stream", "java", "api", "stream" };
		int k = 2;
		Map<String, Integer> map = new HashMap<>();
		Arrays.stream(arr1).forEach(s -> map.put(s, map.getOrDefault(s, 0) + 1));
		List<String> result = map.entrySet().stream().filter(entry -> entry.getValue() >= k).map(Map.Entry::getKey) // Extract
				.collect(Collectors.toList());
		System.out.println(result);

		// Map Strings to Their Length
// ------------------------------------------------------------------------------
		String[] arr2 = { "java", "stream", "api" };

		Arrays.stream(arr2).collect(Collectors.toMap(w -> w, String::length)).forEach((k2, v) -> {
			System.out.println(k2 + " " + v);
		});

// ------------------------------------------------------------------------------
		// Partition Strings by Vowel Start
		String[] fruitBasket = { "apple", "banana", "orange", "grape" };
		Arrays.stream(fruitBasket)
				.collect(Collectors.partitioningBy(fruit -> "aieou".indexOf(fruit.substring(0, 1)) != -1))
				.forEach((k2, v) -> {
					System.out.println(k2 + " " + v);
				});

// ------------------------------------------------------------------------------
		// Find Strings That Are Rotations
		String[] arr4 = { "erbottlewat", "bottle", "waterbottle" };
		String base = "waterbottle";
		Stream.of(arr4).filter(w -> (w + w).contains(base)).forEach(System.out::println);

	}

	@SuppressWarnings("unused")
	private static boolean m1(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}

		// Check if s2 is a substring of s1 + s1
		for (int i = 0; i < s1.length(); i++) {
			if (s2.equals(s1.substring(i) + s1.substring(0, i))) {
				return true;
			}
		}
		return false;
	}

}
