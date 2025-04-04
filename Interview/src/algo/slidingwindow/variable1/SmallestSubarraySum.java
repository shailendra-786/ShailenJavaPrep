package algo.slidingwindow.variable1;

public class SmallestSubarraySum {
	public static int minSubarrayWithSumAtLeastK(int[] arr, int K) {
		int start = 0, sum = 0, minLen = Integer.MAX_VALUE;

		for (int end = 0; end < arr.length; end++) {
			sum += arr[end];

			while (sum >= K) { // Shrink window
				minLen = Math.min(minLen, end - start + 1);
				sum -= arr[start];
				start++;
			}
		}
		return minLen == Integer.MAX_VALUE ? 0 : minLen;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 3, 1, 2, 4, 3 };
		int K = 7;
		System.out.println(minSubarrayWithSumAtLeastK(arr, K)); // Output: 2
	}
}
