package algo.slidingwindow.variable1;

public class VariableSlidingWindow {
	public static int longestSubarrayWithSumAtMostK(int[] arr, int K) {
		int start = 0, end = 0, sum = 0, maxLen = 0;

		for (end = 0; end < arr.length; end++) {
			sum += arr[end];

			while (sum > K) { // Shrink window
				sum -= arr[start];
				start++;
			}

			maxLen = Math.max(maxLen, end - start + 1);
		}
		return maxLen;
	}

	public static void main(String[] args) {
		int[] arr = { 3, 1, 2, 5, 1, 1, 2, 3 };
		int K = 5;
		System.out.println(longestSubarrayWithSumAtMostK(arr, K)); // Output: 3
	}
}
