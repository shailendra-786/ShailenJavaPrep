package algo.backtrack;

import java.util.*;

public class BacktrackingExample {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		List<List<Integer>> subsets = subsets(nums);
		System.out.println(subsets);
	}

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		backtrack(nums, result, new ArrayList<>(), 0);
		return result;
	}

	private static void backtrack(int[] nums, List<List<Integer>> result, List<Integer> current, int start) {
		result.add(new ArrayList<>(current));
		for (int i = start; i < nums.length; i++) {
			current.add(nums[i]);
			backtrack(nums, result, current, i + 1);
			current.remove(current.size() - 1);
		}
	}
}
