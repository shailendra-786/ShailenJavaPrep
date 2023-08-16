package com.shailu;

public class MakeStringPalindrom {

	public static void main(String[] args) {
		System.out.println(makePalindrome("nitian"));
		System.out.println(makePalindrome("nitina"));
		System.out.println(makePalindrome("anitin"));
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

}
