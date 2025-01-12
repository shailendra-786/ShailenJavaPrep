package com.shailu;

import java.util.Arrays;
import java.util.List;

public class FindLongestPalindromFromSubstring {
	public static void main(String[] args) {
		String str = "bbbccd";
		System.out.println(LongestSub(str));
		
	}

	public static String LongestSub(String str) {
		String longest = "";

		for (int i = 0; i < str.length(); i++) {
			for (int j = str.length() - 1; j > i; j--) {
				if (str.charAt(i) == str.charAt(j)) {
					String current = str.substring(i, j + 1);
					if (current.length() > longest.length() && isPlalindrom(current)) {
						longest = current;
					}

				}
			}
		}

		return longest;
	}

	public static boolean isPlalindrom(String str) {
		for (int i = 0; i < str.length() / 2; i++) {
			if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}
}
