package algo.slidingwindow.variable;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeating {

	public static int lengthOfLongestSubstring(String s) {
		Set<Character> seen = new HashSet<>();
		int left = 0; // Left pointer of the sliding window
		int maxLength = 0; // Maximum length of substring without repeating characters

		// Sliding window with right pointer
		for (int right = 0; right < s.length(); right++) {
			char currentChar = s.charAt(right);

			// If the character is already in the set, move the left pointer
			while (seen.contains(currentChar)) {
				seen.remove(s.charAt(left));
				left++;
			}

			// Add the current character to the set
			seen.add(currentChar);

			// Update the maximum length
			maxLength = Math.max(maxLength, right - left + 1);
		}

		return maxLength;
	}

	public static void main(String[] args) {
		String s = "abcabcbb";
		System.out.println(
				"Length of the longest substring without repeating characters: " + lengthOfLongestSubstring(s)); // Output:
																													// 3
	}
}
