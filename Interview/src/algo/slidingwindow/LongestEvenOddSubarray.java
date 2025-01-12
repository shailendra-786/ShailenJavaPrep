package algo.slidingwindow;

public class LongestEvenOddSubarray {

	public int longestEvenOddSubarray(int[] arr, int threshold) {
		int maxLength = 0; // To store the maximum length of the valid subarray
		int start = 0; // Start pointer of the sliding window

		// Iterate through the array using the end pointer
		for (int end = 0; end < arr.length; end++) {
			// Check if the current element is greater than the threshold
			if (arr[end] > threshold) {
				start = end + 1; // Reset the window if the element is invalid
				continue;
			}

			// Check if the current element follows the even-odd alternation
			if (end > start && (arr[end] % 2 == arr[end - 1] % 2)) {
				start = end; // If not alternating, reset the window
			}

			// Calculate the length of the current valid window
			int currentLength = end - start + 1;
			// Update the maximum length if the current window is larger
			maxLength = Math.max(maxLength, currentLength);
			System.out.println(start + " " + end);
		}
		return maxLength; // Return the maximum length of the valid subarray
	}

	public static void main(String[] args) {
		LongestEvenOddSubarray solution = new LongestEvenOddSubarray();

		// Example test case
		int[] arr = { 4, 3, 2, 5, 6, 7 };
		int threshold = 4;

		int result = solution.longestEvenOddSubarray(arr, threshold);
		System.out.println("Longest Even-Odd Subarray Length: " + result); // Output: 3
	}
}
