package algo.twopointer;

import java.util.HashSet;

public class LongestUniqueSubstring {

	// Method to find the length of the longest substring without repeating
	// characters
	public int lengthOfLongestSubstring(String s) {
		HashSet<Character> seen = new HashSet<>();
		int left = 0;
		int maxLength = 0;

		for (int right = 0; right < s.length(); right++) {
			char currentChar = s.charAt(right);

			// While the current character is in the set, remove characters from the left
			while (seen.contains(currentChar)) {
				seen.remove(s.charAt(left));
				left++;
			}

			// Add the current character to the set
			seen.add(currentChar);

			// Update the maximum length of the substring
			maxLength = Math.max(maxLength, right - left + 1);
		}

		return maxLength;
	}

	// Main method to run tests
	public static void main(String[] args) {
		LongestUniqueSubstring solution = new LongestUniqueSubstring();

		// Test cases
		String test1 = "abcabcbb";
		String test2 = "bbbbb";
		String test3 = "pwwkew";
		String test4 = "";

		// Print the results
		System.out.println("Test 1: " + solution.lengthOfLongestSubstring(test1)); // 3 ("abc")
		System.out.println("Test 2: " + solution.lengthOfLongestSubstring(test2)); // 1 ("b")
		System.out.println("Test 3: " + solution.lengthOfLongestSubstring(test3)); // 3 ("wke")
		System.out.println("Test 4: " + solution.lengthOfLongestSubstring(test4)); // 0 ("")
	}
}
