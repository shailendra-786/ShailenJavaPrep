package algo.slidingwindow.fixed;

public class SubarraysWithAverage {
	public static int numOfSubarrays(int[] nums, int k, int threshold) {
		int count = 0;
		int targetSum = threshold * k; // The sum that corresponds to the threshold
		int currentSum = 0;

		// Calculate the sum of the first window
		for (int i = 0; i < k; i++) {
			currentSum += nums[i];
		}

		// Check if the first window meets the requirement
		if (currentSum >= targetSum) {
			count++;
		}

		// Slide the window over the rest of the array
		for (int i = k; i < nums.length; i++) {
			// Slide the window: remove the element that's sliding out and add the new
			// element
			currentSum += nums[i] - nums[i - k];

			// Check if the new window meets the requirement
			if (currentSum >= targetSum) {
				count++;
			}
		}

		return count;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 1, 3, 5, 1, 8, 3, 9 };
		int k = 3;
		int threshold = 4;
		System.out.println("Number of subarrays: " + numOfSubarrays(nums, k, threshold)); // Output: 3
	}
}
