package algo.slidingwindow.variable1;

import java.util.HashMap;

public class LongestSubstringOptimized {
	public static int lengthOfLongestSubstring(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		int start = 0, maxLen = 0;

		for (int end = 0; end < s.length(); end++) {
			char ch = s.charAt(end);

			// If duplicate is found, update `start` to avoid redundant scans
			if (map.containsKey(ch)) {
				start = Math.max(start, map.get(ch) + 1);
			}

			map.put(ch, end);
			maxLen = Math.max(maxLen, end - start + 1);
		}
		return maxLen;
	}

	public static void main(String[] args) {
		String s = "abcabcbb";
		System.out.println(lengthOfLongestSubstring(s)); // Output: 3
	}
}
