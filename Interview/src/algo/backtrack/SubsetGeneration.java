package algo.backtrack;

import java.util.ArrayList;
import java.util.List;

public class SubsetGeneration {
    public static List<List<Integer>> generateSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), subsets);
        return subsets;
    }

    private static void backtrack(int[] nums, int index, List<Integer> currentSubset, List<List<Integer>> subsets) {
        subsets.add(new ArrayList<>(currentSubset));

        for (int i = index; i < nums.length; i++) {
            currentSubset.add(nums[i]);
            backtrack(nums, i + 1, currentSubset, subsets);
            currentSubset.remove(currentSubset.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = generateSubsets(nums);

        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}

