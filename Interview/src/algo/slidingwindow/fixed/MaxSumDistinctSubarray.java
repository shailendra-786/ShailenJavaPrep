package algo.slidingwindow.fixed;

import java.util.HashSet;
import java.util.Set;

public class MaxSumDistinctSubarray {

	public static int maximumSumOfDistinctSubarrays(int[] nums, int k) {
		int n = nums.length;
		if (k > n) {
			return 0; // If k is larger than the array size
		}

		int maxSum = 0;
		int currentSum = 0;
		HashSet<Integer> windowSet = new HashSet<>();

		int left = 0; // Left pointer for the sliding window

		for (int right = 0; right < n; right++) {
			// If current element is already in the set, shrink the window from the left
			while (windowSet.contains(nums[right])) {
				windowSet.remove(nums[left]);
				currentSum -= nums[left];
				left++;
			}

			// Add the current element to the set and update the current sum
			windowSet.add(nums[right]);
			currentSum += nums[right];

			// Check if the window has exactly K elements, and update the max sum
			if (right - left + 1 == k) {
				maxSum = Math.max(maxSum, currentSum);

				// Shrink the window by removing the leftmost element
				windowSet.remove(nums[left]);
				currentSum -= nums[left];
				left++;
			}
		}

		return maxSum;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 5, 5, 4, 4, 2, 9, 9, 9 };
		int k = 3;
		System.out.println("Maximum sum of distinct subarrays with length " + k + " is: "
				+ maximumSumOfDistinctSubarrays(nums, k));
		System.out
				.println("Maximum sum of distinct subarrays with length " + k + " is: " + maximumSubarraySum(nums, k));
	}

	public static long maximumSubarraySum(int[] nums, int k) {
		int n = nums.length;
		int start = 0, end = 0;
		Long sum = 0l, max = 0l;
		Set<Integer> set = new HashSet<>();
		while (end < n) {
			int val = nums[end];
			while (set.contains(val) || (end - start + 1 > k) && start < end) {
				sum -= nums[start];
				set.remove(nums[start++]);
			}
			sum += val;
			set.add(val);
			if (end - start + 1 == k)
				max = Math.max(max, sum);
			end++;
		}
		return max;
	}
}
