package com.leetarray;

import java.util.Arrays;

public class MinimumSizeSubarraySum {
	public static void main(String[] args) {
		int target = 7;
		int[] nums = { 2, 3, 1, 2, 4, 3 };

		int result = minSubarrayLen(target, nums);
		System.out.println("Minimum subarray length: " + result);
		System.out.println(Arrays.toString(findSubarray(nums, target)));
	}

	// to get length
	
	public static int minSubarrayLen(int target, int[] nums) {
		int left = 0;
		int right = 0;
		int minLength = nums.length + 1;
		int currentSum = 0;

		while (right < nums.length) {
			currentSum += nums[right];

			while (currentSum >= target) {
				minLength = Math.min(minLength, right - left + 1);
				System.out.println("min len "+minLength);
				currentSum -= nums[left];
				left++;
			}

			right++;
		}

		return (minLength > nums.length) ? 0 : minLength;
	}

	// to get array
//	int target = 7;
//	int[] nums = { 2, 3, 1, 2, 4, 3 };
	public static int[] findSubarray(int[] nums, int targetSum) {
		int left = 0, right = 0;
		int currentSum = 0, minLength = nums.length + 1;
		int[] subarray = new int[0];

		while (right < nums.length) {
			currentSum += nums[right];

			while (currentSum >= targetSum) {
				if (right - left + 1 < minLength) {
					minLength = right - left + 1;
					subarray = Arrays.copyOfRange(nums, left, left + minLength);
				}

				currentSum -= nums[left];
				left++;
			}

			right++;
		}

		return subarray;
	}

}
