package algo.slidingwindow.variable1;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagrams {
	public static List<Integer> findAnagrams(String s, String p) {
		List<Integer> result = new ArrayList<>();
		if (s.length() < p.length())
			return result;

		int[] countP = new int[26]; // Frequency count for pattern
		int[] countS = new int[26]; // Frequency count for sliding window

		// Populate frequency of p in countP
		for (char ch : p.toCharArray()) {
			countP[ch - 'a']++;
		}

		int left = 0, right = 0, matches = 0;

		while (right < s.length()) {
			char rChar = s.charAt(right);
			countS[rChar - 'a']++;

			// Check if countS matches countP
			if (right - left + 1 == p.length()) {
				if (matches(countP, countS)) {
					result.add(left);
				}

				// Remove leftmost character as window slides
				char lChar = s.charAt(left);
				countS[lChar - 'a']--;
				left++;
			}
			right++;
		}
		return result;
	}

	private static boolean matches(int[] a, int[] b) {
		for (int i = 0; i < 26; i++) {
			if (a[i] != b[i])
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		String s = "cbaebabacd", p = "abc";
		System.out.println(findAnagrams(s, p)); // Output: [0, 6]

		String s2 = "abab", p2 = "ab";
		System.out.println(findAnagrams(s2, p2)); // Output: [0, 1, 2]
	}
}
