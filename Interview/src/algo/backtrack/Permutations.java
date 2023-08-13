package algo.backtrack;

import java.util.*;

public class Permutations {

	public static void main(String[] args) {
		int arr[] = { 2, 1, 3 };
		permute(arr).stream().forEach(System.out::println);
	}

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return result;
		}
		backtrack(nums, new ArrayList<>(), result);
		return result;
	}

	private static void backtrack(int[] nums, List<Integer> temp, List<List<Integer>> result) {
		if (temp.size() == nums.length) {
			result.add(new ArrayList<>(temp));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (temp.contains(nums[i])) {
				continue;
			}
			System.out.println("let see");
			temp.add(nums[i]);
			backtrack(nums, temp, result);
			temp.remove(temp.size() - 1);
		}
	}
}
