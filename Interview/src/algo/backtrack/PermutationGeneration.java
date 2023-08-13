package algo.backtrack;

import java.util.ArrayList;
import java.util.List;

public class PermutationGeneration {
    public static List<List<Integer>> generatePermutations(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), new boolean[nums.length], permutations);
        return permutations;
    }

    private static void backtrack(int[] nums, List<Integer> currentPermutation, boolean[] used, List<List<Integer>> permutations) {
        if (currentPermutation.size() == nums.length) {
            permutations.add(new ArrayList<>(currentPermutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            currentPermutation.add(nums[i]);
            used[i] = true;
            backtrack(nums, currentPermutation, used, permutations);
            used[i] = false;
            currentPermutation.remove(currentPermutation.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permutations = generatePermutations(nums);

        for (List<Integer> permutation : permutations) {
            System.out.println(permutation);
        }
    }
}
