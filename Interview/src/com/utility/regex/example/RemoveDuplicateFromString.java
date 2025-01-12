package com.utility.regex.example;

public class RemoveDuplicateFromString {
	public static void main(String[] args) {
		String input = "Thiiiis is aaaawesomeee!";
		String output = makeGreat(input);

		System.out.println("Original: " + input);
		System.out.println("Modified: " + output);
		camelToSnake();
	}

	public static String makeGreat(String input) {
		// Use regex to replace consecutive duplicate characters with a single
		// occurrence
		String regex = "(.)\\1+";
		return input.replaceAll(regex, "$1");
	}

	public static void understad$1() {

		String input = "apple apple banana banana";
		String regex = "(\\b\\w+\\b)\\s\\1"; // Capturing a word and then checking for its repetition

		String replacement = "$1 is repeated"; // Using $1 in the replacement string

		String result = input.replaceAll(regex, replacement);
		System.out.println("Result: " + result);
	}

	public static void camelToSnake() {
		String str = "ShailendraKumarSingh";
		// Regular Expression
		String regex = "([a-z])([A-Z]+)";

		// Replacement string
		String replacement = "$1_$2";

		// Replace the given regex
		// with replacement string
		// and convert it to lower case.
		str = str.replaceAll(regex, replacement).toLowerCase();
		System.out.println(str);

	}
}
