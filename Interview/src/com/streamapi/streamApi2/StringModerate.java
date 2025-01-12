package com.streamapi.streamApi2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StringModerate {

	public static void main(String[] args) {
// ------------------------------------------------------------------------------
		// Convert a List of Strings to Uppercase
		String arr[] = { "java", "stream", "api" };

		String[] upperCase = Stream.of(arr).map(String::toUpperCase).toArray(String[]::new);
		System.out.println(Arrays.toString(upperCase));

// ------------------------------------------------------------------------------
		// Sort Strings by Length
		String[] sortedArr = Stream.of(arr).sorted(Comparator.comparingInt(String::length)).toArray(String[]::new);
		System.out.println(Arrays.toString(sortedArr));

		String[] sortedArrDesc = Stream.of(arr).sorted(Comparator.comparingInt(String::length).reversed())
				.toArray(String[]::new);
		System.out.println(Arrays.toString(sortedArrDesc));

// ------------------------------------------------------------------------------
		// Find the Longest String
		String[] arr1 = { "apple", "banana", "cherry", "date" };

		int maxLen = Arrays.stream(arr1).map(String::length).mapToInt(Integer::intValue).max().getAsInt();
		String maxLenStr = Arrays.stream(arr1).filter(word -> word.length() == maxLen).findFirst().get();
		System.out.println(maxLenStr);

		String maxLenStrGbt = Arrays.stream(arr1).max(Comparator.comparingInt(String::length)).get();
		System.out.println(maxLenStrGbt);

// ------------------------------------------------------------------------------
		// Filter Strings Containing a Substring
		String[] arr2 = { "apple", "apricot", "banana" };
		String subStr = "ap";

		Predicate<String> checkSubStrIntoStr = w -> w.contains(subStr);
		String[] subStrArr = Stream.of(arr2).filter(checkSubStrIntoStr).toArray(String[]::new);
		System.out.println(Arrays.toString(subStrArr));

//------------------------------------------------------------------------------
		// Count Strings Matching a Predicate
		Predicate<String> checkStartStrIntoStr = w -> w.startsWith("a");
		long totalWord = Stream.of(arr2).filter(checkStartStrIntoStr).count();
		System.out.println(totalWord);

	}

}
