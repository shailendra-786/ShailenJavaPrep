package com.practice;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> numToIndex = new HashMap<>();
		int[] result = new int[2];

		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			// Check if the complement exists in the map
			if (numToIndex.containsKey(complement)) {
				result[0] = numToIndex.get(complement);
				result[1] = i;
				return result;
			}
			// Store the current number and its index
			numToIndex.put(nums[i], i);
		}

		return result; // No solution found
	}

	public static void main(String[] args) {
		int[] nums = { 2, 11, 9, 15, 7 };
		int target = 11;
		int[] result = twoSum(nums, target);

		System.out.println("Indices of the two numbers that add up to the target: " + result[0] + ", " + result[1]);
	}
}
