package algo.backtrack;

import java.util.*;

public class CombinationSum {

	public static void main(String[] args) {
		int[] arr = { 2, 3 };
		System.out.println("data " + combinationSum(arr, 8));
		combinationSum(arr, 8).stream().forEach(System.out::println);
		;
//		System.out.println("data " + combinationSum2(arr, 8));

	}

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> current = new ArrayList<>();
		Arrays.sort(candidates);
		combinationSumHelper(candidates, target, 0, current, result);
		return result;
	}

	static void combinationSumHelper(int[] candidates, int target, int start, List<Integer> current,
			List<List<Integer>> result) {
		if (target == 0) {
			result.add(new ArrayList<>(current));
			return;
		}
		for (int i = start; i < candidates.length && candidates[i] <= target; i++) {
			current.add(candidates[i]);
			combinationSumHelper(candidates, target - candidates[i], i, current, result);
			current.remove(current.size() - 1);
		}
	}

	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(candidates);
		backtrack(candidates, target, 0, new ArrayList<>(), result);
		return result;
	}

	private static void backtrack(int[] candidates, int target, int start, List<Integer> current,
			List<List<Integer>> result) {
		if (target == 0) {
			result.add(new ArrayList<>(current));
			return;
		}

		for (int i = start; i < candidates.length; i++) {
			if (i > start && candidates[i] == candidates[i - 1]) {
				continue; // skip duplicates
			}
			if (candidates[i] > target) {
				break; // optimization: stop early if the remaining candidates are too large
			}
			current.add(candidates[i]);
			backtrack(candidates, target - candidates[i], i + 1, current, result);
			current.remove(current.size() - 1);
		}
	}
}
