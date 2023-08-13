package com.shailu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class LeetHard2 {
	public static List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();
		for (String str : strs) {
			char[] chars = str.toCharArray();
			Arrays.sort(chars);
			String key = new String(chars);
			if (!map.containsKey(key)) {
				map.put(key, new ArrayList<>());
			}
			map.get(key).add(str);
		}
		return new ArrayList<>(map.values());
	}

	public static String makePalindrome(String s) {
		int i = 0, j = s.length() - 1;
		while (i < j) {
			if (s.charAt(i) != s.charAt(j)) {
				// try removing the character at i
				if (isPalindrome(s.substring(i + 1, j + 1))) {
					return s.substring(0, i) + s.substring(i + 1);
				}
				// try removing the character at j
				if (isPalindrome(s.substring(i, j))) {
					return s.substring(0, j) + s.substring(j + 1);
				}
				// if neither works, the string cannot be made a palindrome
				return "Cannot be made a palindrome by removing at most one character.";
			}
			i++;
			j--;
		}
		// the string is already a palindrome
		return s;
	}

	public static boolean isPalindrome(String s) {
		int i = 0, j = s.length() - 1;
		while (i < j) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args) {
		String[] str1 ={"eat","tea","tan","ate","nat","bat"};
		System.out.println(groupAnagrams(str1));
		
		System.out.println(makePalindrome("nitain"));
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

		String sentence = "thequickbrownfoxjumpsoverthelazydog";

		Set<Character> count3 = sentence.chars().map(Character::toLowerCase).filter(Character::isAlphabetic)
				.mapToObj(c -> (char) c).collect(Collectors.toSet());
		System.out.println(count3.size());

		String s1 = "abBAabBAcC";
		StringBuilder s = new StringBuilder(s1);
		for (int i = 0; i < s.length() - 1;) {
			char c1 = s.charAt(i);
			char c2 = s.charAt(i + 1);
			if (c1 != c2 && Character.toLowerCase(c1) == Character.toLowerCase(c2)) {
				s.delete(i, i + 2);
				if (i > 0) {
					i--;
				}

			} else {
				i++;
			}
		}
		System.out.println(s);

		String jewels = "z", stones = "ZZ";
		int count = 0;
		for (int i = 0; i < jewels.length(); i++) {
			for (int j = 0; j < stones.length(); j++) {
				if (jewels.charAt(i) == stones.charAt(j)) {
					count++;
					System.out.println("count " + count);
				}
			}
		}
		System.out.println(count);

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

	
	public static boolean isPlalindrom(String str) {
		for (int i = 0; i < str.length() / 2; i++) {
			if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	public static String LongestSub(String str) {
		String longest = "";

		for (int i = 0; i < str.length(); i++) {
			for (int j = str.length() - 1; j > i; j--) {
				if (str.charAt(i) == str.charAt(j)) {
					String substr = str.substring(i, j + 1);
					if (isPlalindrom(substr) && substr.length() > longest.length()) {
						longest = substr;
					}
				}
			}
		}

		return longest;
	}

	// abcabcbb
	public static String longestSubstringWithoutRepeatingCharacters(String s) {
		int i = 0;
		String longest = "";
		Set<Character> seen = new HashSet<>();

		for (int j = 0; j < s.length(); j++) {
			if (!seen.contains(s.charAt(j))) {
				seen.add(s.charAt(j));
				String current = s.substring(i, j + 1);
				if (current.length() > longest.length()) {
					longest = current;
				}
			} else {
				System.out.println(s.charAt(j) + " " + s.charAt(i));
				System.out.println(s.charAt(i) != s.charAt(j));
				while (s.charAt(i) != s.charAt(j)) {
					seen.remove(s.charAt(i));
					i++;
				}
				i++;
			}
		}

		return longest;
	}

}
