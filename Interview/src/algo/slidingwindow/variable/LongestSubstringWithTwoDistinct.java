package algo.slidingwindow.variable;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithTwoDistinct {

	public static int lengthOfLongestSubstringTwoDistinct(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		Map<Character, Integer> charCountMap = new HashMap<>(); // Map to track character frequency
		int left = 0; // Left pointer of the sliding window
		int maxLength = 0; // Store the maximum length of the substring

		// Traverse the string using the right pointer
		for (int right = 0; right < s.length(); right++) {
			char rightChar = s.charAt(right);
			charCountMap.put(rightChar, charCountMap.getOrDefault(rightChar, 0) + 1);

			// If there are more than two distinct characters, shrink the window from the
			// left
			while (charCountMap.size() > 2) {
				char leftChar = s.charAt(left);
				charCountMap.put(leftChar, charCountMap.get(leftChar) - 1);

				// If the count of the left character becomes zero, remove it from the map
				if (charCountMap.get(leftChar) == 0) {
					charCountMap.remove(leftChar);
				}
				left++; // Move the left pointer to shrink the window
			}

			// Update the maximum length of the valid window
			maxLength = Math.max(maxLength, right - left + 1);
		}

		return maxLength;
	}

	public static void main(String[] args) {
		String s = "eadfdgceba";
		System.out.println("Longest substring length with at most 2 distinct characters: "
				+ lengthOfLongestSubstringTwoDistinct(s)); // Output: 3
	}
}
