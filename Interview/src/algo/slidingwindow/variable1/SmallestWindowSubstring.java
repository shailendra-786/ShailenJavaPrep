package algo.slidingwindow.variable1;

import java.util.HashMap;

public class SmallestWindowSubstring {
	public static String minWindow(String s, String t) {
		if (s.length() < t.length())
			return "";

		HashMap<Character, Integer> tMap = new HashMap<>();
		for (char ch : t.toCharArray()) {
			tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
		}

		int left = 0, right = 0, minLen = Integer.MAX_VALUE, startIndex = 0;
		int required = tMap.size(); // Unique characters in t
		int matched = 0;

		HashMap<Character, Integer> window = new HashMap<>();

		while (right < s.length()) {
			char rChar = s.charAt(right);
			window.put(rChar, window.getOrDefault(rChar, 0) + 1);

			if (tMap.containsKey(rChar) && window.get(rChar).intValue() == tMap.get(rChar).intValue()) {
				matched++;
			}

			// Try to shrink the window
			while (matched == required) {
				if (right - left + 1 < minLen) {
					minLen = right - left + 1;
					startIndex = left;
				}

				char lChar = s.charAt(left);
				window.put(lChar, window.get(lChar) - 1);

				if (tMap.containsKey(lChar) && window.get(lChar).intValue() < tMap.get(lChar).intValue()) {
					matched--;
				}

				left++; // Shrink window
			}

			right++; // Expand window
		}

		return minLen == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLen);
	}

	public static void main(String[] args) {
		System.out.println(minWindow("ADOBECODEBANC", "ABC")); // Output: "BANC"
		System.out.println(minWindow("a", "a")); // Output: "a"
		System.out.println(minWindow("a", "aa")); // Output: ""
	}
}
