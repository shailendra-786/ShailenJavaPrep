package com.shailu;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetHard2 {
	

	

	public static void main(String[] args) {
		
		
		String sortWord = "Myself2 Me1 I4 and3";
		System.out.println(sortSentence(sortWord));
		String sorder = "";
		String[] sword = sortWord.split(" ");
		for (int i = 0; i < sword.length; i++) {
			String a = i + 1 + "";
			for (int j = 0; j < sword.length; j++) {
				if (sword[j].contains(a)) {
					sorder += sword[j] + " ";
				}
			}
		}
		System.out.println(sorder.trim().replaceAll("[0-9]", ""));


		

		

		String splitString = "RLRRLLRLRL";

		int count1 = 0;
		int balance = 0;
		for (char c : splitString.toCharArray()) {
			if (c == 'L') {
				balance++;
			} else {
				balance--;
			}
			if (balance == 0) {
				count1++;
			}
		}

		System.out.println(count1);

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
	}

	public static String sortSentence(String s) {
		String[] words = s.split(" ");
		Arrays.sort(words, (a, b) -> {
			int len1 = a.length();
			int len2 = b.length();
			if (len1 != len2) {
				return len1 - len2;
			} else {
				return a.compareTo(b);
			}
		});
		StringBuilder sb = new StringBuilder();
		for (String word : words) {
			sb.append(word.substring(0, word.length() - 1));
			sb.append(" ");
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

	

	
}
