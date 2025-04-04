package algo.slidingwindow.variable1;

public class LongestRepeatingCharacterReplacement {
	public static int characterReplacement(String s, int k) {
		int left = 0, maxLen = 0, maxFreq = 0;
		int[] count = new int[26]; // Store frequency of letters

		for (int right = 0; right < s.length(); right++) {
			count[s.charAt(right) - 'A']++;
			maxFreq = Math.max(maxFreq, count[s.charAt(right) - 'A']);

			while ((right - left + 1) - maxFreq > k) {
				count[s.charAt(left) - 'A']--;
				left++; // Shrink window
			}

			maxLen = Math.max(maxLen, right - left + 1);
		}

		return maxLen;
	}

	public static void main(String[] args) {
		System.out.println(characterReplacement("AABABBA", 1)); // Output: 4
//		System.out.println(characterReplacement("ABBAB", 2)); // Output: 4
	}
}
