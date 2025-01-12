package com.shailu;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeating {

	public static void main(String[] args) {
		String str = "pwwkew";
		System.out.println(longestSubstringWithoutRepeatingCharacters(str));
	}

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
