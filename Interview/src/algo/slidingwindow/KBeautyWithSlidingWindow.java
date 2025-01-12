package algo.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class KBeautyWithSlidingWindow {

	public static int findKBeauty(int number, int k) {
		String numStr = Integer.toString(number);
		Set<String> uniqueSubstrings = new HashSet<>();
		int count = 0;

		// Slide over the string and extract substrings of length k
		for (int i = 0; i <= numStr.length() - k; i++) {
			String substring = numStr.substring(i, i + k);

			// Convert substring to integer and check divisibility
			int num = Integer.parseInt(substring);
			if (num % k == 0) {
				// Use a set to keep track of unique valid substrings
				if (!uniqueSubstrings.contains(substring)) {
					uniqueSubstrings.add(substring);
					count++;
				}
			}
		}
		System.out.println(uniqueSubstrings);
		return count;
	}

	public static void main(String[] args) {
		int number = 240220;
		int k = 2;
		System.out.println("K-beauty of " + number + " with K = " + k + " is: " + findKBeauty(number, k)); // Output: 4
	}
}
