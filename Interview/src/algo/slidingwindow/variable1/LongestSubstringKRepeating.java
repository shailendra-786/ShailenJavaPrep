package algo.slidingwindow.variable1;

public class LongestSubstringKRepeating {
	public static int longestSubstring(String s, int k) {
		if (s.length() == 0)
			return 0;

		int[] freq = new int[26]; // Count occurrences of each character
		for (char c : s.toCharArray()) {
			freq[c - 'a']++;
		}

		for (int i = 0; i < s.length(); i++) {
			if (freq[s.charAt(i) - 'a'] > 0 && freq[s.charAt(i) - 'a'] < k) {
				// Found a "bad" character → Split the string
				int left = longestSubstring(s.substring(0, i), k);
				int right = longestSubstring(s.substring(i + 1), k);
				return Math.max(left, right);
			}
		}

		// If no bad character found, the whole string is valid
		return s.length();
	}

	public static void main(String[] args) {
		System.out.println(longestSubstring("aaabb", 3)); // Output: 3
		System.out.println(longestSubstring("ababbc", 2)); // Output: 5
	}
}
