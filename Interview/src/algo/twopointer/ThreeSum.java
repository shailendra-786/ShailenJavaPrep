package algo.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	// Method to find all unique triplets that sum up to zero
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums); // Sort the array

		for (int i = 0; i < nums.length - 2; i++) {
			// Avoid duplicate values for the first number
			if (i > 0 && nums[i] == nums[i - 1])
				continue;

			int left = i + 1;
			int right = nums.length - 1;

			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];

				if (sum < 0) {
					left++;
				} else if (sum > 0) {
					right--;
				} else {
					result.add(Arrays.asList(nums[i], nums[left], nums[right]));
					// Avoid duplicate values for the second number
					while (left < right && nums[left] == nums[left + 1])
						left++;
					// Avoid duplicate values for the third number
					while (left < right && nums[right] == nums[right - 1])
						right--;
					left++;
					right--;
				}
			}
		}

		return result;
	}

	// Main method to run tests
	public static void main(String[] args) {
		ThreeSum solution = new ThreeSum();

		// Test cases
		int[] test1 = { -1, 0, 1, 2, -1, -4 };
		int[] test2 = { 0, 0, 0, 0 };
		int[] test3 = { -1, 0, 1 };
		int[] test4 = { 1, 2, -2, -1 };

		// Print the results
		System.out.println("Test 1: " + solution.threeSum(test1)); // [[-1, -1, 2], [-1, 0, 1]]
		System.out.println("Test 2: " + solution.threeSum(test2)); // [[0, 0, 0]]
		System.out.println("Test 3: " + solution.threeSum(test3)); // [[-1, 0, 1]]
		System.out.println("Test 4: " + solution.threeSum(test4)); // []
	}
}
