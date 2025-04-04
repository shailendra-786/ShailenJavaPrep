package algo.slidingwindow.variable1;

public class LongestSubarrayAtMostKOdds {
	public static int longestSubarrayWithAtMostKOdds(int[] arr, int K) {
		int start = 0, maxLen = 0, oddCount = 0;

		for (int end = 0; end < arr.length; end++) {
			// Check if current element is odd
			if (arr[end] % 2 != 0) {
				oddCount++;
			}

			// If we exceed K odd numbers, shrink the window from the left
			while (oddCount > K) {
				if (arr[start] % 2 != 0) {
					oddCount--;
				}
				start++;
			}

			// Update the maximum length found
			maxLen = Math.max(maxLen, end - start + 1);
		}

		return maxLen;
	}

	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 3, 4, 5, 6, 7 };
		int K1 = 2;
		System.out.println(longestSubarrayWithAtMostKOdds(arr1, K1)); // Output: 4

		int[] arr2 = { 2, 4, 6, 8, 10 };
		int K2 = 1;
		System.out.println(longestSubarrayWithAtMostKOdds(arr2, K2)); // Output: 5

		int[] arr3 = { 1, 3, 5, 7, 9 };
		int K3 = 2;
		System.out.println(longestSubarrayWithAtMostKOdds(arr3, K3)); // Output: 2
	}
}
