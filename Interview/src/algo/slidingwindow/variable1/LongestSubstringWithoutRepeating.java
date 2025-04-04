package algo.slidingwindow.variable1;

import java.util.HashSet;

public class LongestSubstringWithoutRepeating {
	public static int lengthOfLongestSubstring(String s) {
		HashSet<Character> set = new HashSet<>();
		int start = 0, maxLen = 0;

		for (int end = 0; end < s.length(); end++) {
			char ch = s.charAt(end);

			// If duplicate is found, shrink window from left
			while (set.contains(ch)) {
				set.remove(s.charAt(start));
				start++;
			}

			set.add(ch); // Add new character to window
			maxLen = Math.max(maxLen, end - start + 1);
		}
		return maxLen;
	}

	public static void main(String[] args) {
		String s = "abcabcbb";
		System.out.println(lengthOfLongestSubstring(s)); // Output: 3
	}
}
