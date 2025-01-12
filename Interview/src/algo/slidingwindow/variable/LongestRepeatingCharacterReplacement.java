package algo.slidingwindow.variable;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {


	    public static int characterReplacement(String s, int k) {
	        Map<Character, Integer> countMap = new HashMap<>();  // HashMap to track character frequency
	        int left = 0;  // Left pointer for the sliding window
	        int maxLength = 0;  // Maximum length of valid substring
	        int maxFreq = 0;  // Maximum frequency of any character in the current window

	        // Sliding window with the right pointer expanding the window
	        for (int right = 0; right < s.length(); right++) {
	            char rightChar = s.charAt(right);
	            countMap.put(rightChar, countMap.getOrDefault(rightChar, 0) + 1);  // Update the character frequency

	            // Update the max frequency in the current window
	            maxFreq = Math.max(maxFreq, countMap.get(rightChar));

	            // Check if the current window is valid by comparing (window size - maxFreq) <= k
	            while ((right - left + 1) - maxFreq > k) {
	                char leftChar = s.charAt(left);
	                countMap.put(leftChar, countMap.get(leftChar) - 1);  // Decrease the frequency of the left character
	                left++;  // Shrink the window from the left
	            }

	            // Update the maximum length of the valid window
	            maxLength = Math.max(maxLength, right - left + 1);
	        }

	        return maxLength;
	    }

	  

	public static int characterReplacement1(String s, int k) {
		int[] count = new int[26]; // Array to count frequency of each character
		int left = 0; // Left pointer of the window
		int maxLength = 0; // Store the length of the longest valid window
		int maxFreq = 0; // Store the maximum frequency of any character in the current window

		for (int right = 0; right < s.length(); right++) {
			char rightChar = s.charAt(right);
			
			System.out.println(rightChar);
			count[rightChar - 'A']++; // Increment the count of the current character
			maxFreq = Math.max(maxFreq, count[rightChar - 'A']); // Update maxFreq
			System.out.println(count[right]);
//			System.out.println(maxFreq);
			// Check if the current window is valid (i.e., the number of characters to
			// replace is <= k)
			while ((right - left + 1) - maxFreq > k) {
				char leftChar = s.charAt(left);
				count[leftChar - 'A']--; // Remove the leftmost character from the window
				left++; // Shrink the window
			}

			// Calculate the maximum length of the valid window
			maxLength = Math.max(maxLength, right - left + 1);
		}

		return maxLength;
	}

	public static void main(String[] args) {
		String s = "AABABBA";
		int k = 1;
		System.out.println("Longest repeating character replacement: " + characterReplacement(s, k)); // Output: 4
	}
}
