package com.leetarray;

public class FirstMissingPostiveNum {
	public static void main(String[] args) {
		int[] nums = {3, 4, -1, 1};
		int missing = firstMissingPositive(nums);
		System.out.println("First Missing Positive: " + missing);

	}

	public static int firstMissingPositive(int[] nums) {
		int n = nums.length;

		// Step 1: Mark visited indices
		for (int i = 0; i < n; i++) {
			if (nums[i] > 0 && nums[i] <= n) {
				int pos = nums[i] - 1;
				if (nums[pos] > 0) {
					nums[pos] = -nums[pos];
				}
			}
		}

		// Step 2: Find first missing positive
		for (int i = 0; i < n; i++) {
			if (nums[i] > 0) {
				return i + 1;
			}
		}

		// Step 3: No positive numbers found, return next positive integer
		return n + 1;
	}

}
