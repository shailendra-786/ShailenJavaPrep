package algo.slidingwindow.fixed;

import java.util.HashSet;
import java.util.Set;

public class BinaryCodesInString {

	public static boolean hasAllCodes(String s, int k) {
		int n = s.length();
		if (n < k) {
			return false; // If the string is shorter than k, it can't contain all codes
		}

		Set<String> seen = new HashSet<>();
		int totalCodes = 1 << k; // This is 2^k, the total number of distinct binary codes
		System.out.println(totalCodes);
		// Sliding window over the string to extract all substrings of length k
		for (int i = 0; i <= n - k; i++) {
			String substring = s.substring(i, i + k);
			seen.add(substring);

			// Early exit: If we have already seen all possible binary codes, return true
			if (seen.size() == totalCodes) {
				return true;
			}
		}

		// If we didn't find all possible codes, return false
		return seen.size() == totalCodes;
	}

	public static void main(String[] args) {
		String s = "00110110";
		int k = 2;

		System.out.println("Does the string contain all binary codes of size " + k + "? " + hasAllCodes(s, k)); // Output:
																												// true
	}
}
