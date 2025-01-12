package algo.slidingwindow.fixed;

public class MaximumAverageSubarray {
	public static double findMaxAverage(int[] nums, int k) {
		// Step 1: Calculate the sum of the first window of size k
		double maxSum = 0, currentSum = 0;

		// Calculate the sum for the first k elements
		for (int i = 0; i < k; i++) {
			currentSum += nums[i];
		}

		// Initialize maxSum with the sum of the first k elements
		maxSum = currentSum;

		// Step 2: Slide the window across the array
		for (int i = k; i < nums.length; i++) {
			// Slide the window by subtracting the element that's sliding out
			// and adding the element that's coming into the window
			currentSum += nums[i] - nums[i - k];

			// Update the maxSum if the current window's sum is larger
			maxSum = Math.max(maxSum, currentSum);
		}

		// Step 3: Return the maximum average
		return maxSum / k;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 12, -5, -6, 50, 3 };
		int k = 4;
		System.out.println("Maximum Average Subarray I: " + findMaxAverage(nums, k)); // Output: 12.75
	}
}
