package com.streamapi;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveVowels {

	public static void main(String[] args) {
		String str = "Shailen@9510";
		System.out.println(str.length());

		Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

		String a = str.chars().filter(c -> !vowels.contains((char) c))
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
		System.out.println(a);
		System.out.println(str.replaceAll("[a-z]", ""));
		System.out.println(str.replaceAll("[^a-z]", ""));
		System.out.println(str.replaceAll("(?i)[a-z]", ""));

		String[] sentences = { "alice and bob love leetcode", "i think so too", "this is great thanks very much" };
		List<String> sentences1 = Arrays.asList(sentences);
		int a1 = sentences1.stream().map(st1 -> st1.split(" ").length).mapToInt(Integer::intValue).max().getAsInt();
		System.out.println(a1);
		
		

		// Sample stream of characters
		String inputString = "Hello, Stream API!";

		// Collect characters into a StringBuilder using Stream API
		StringBuilder stringBuilder = inputString.chars().mapToObj(c -> (char) c).collect(StringBuilder::new,
				StringBuilder::append, StringBuilder::append);

		// Output the StringBuilder content
		System.out.println(stringBuilder.toString());
		
	}

}
