package dsa.stack;

import java.util.Stack;

public class BacktrackingUsingStack {
    public static void backtrack(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        backtrackHelper(nums, stack, 0);
    }

    private static void backtrackHelper(int[] nums, Stack<Integer> stack, int startIndex) {
        // Process the current solution
        processSolution(stack);

        for (int i = startIndex; i < nums.length; i++) {
            // Make a choice
            stack.push(nums[i]);

            // Explore further
            backtrackHelper(nums, stack, i + 1);

            // Undo the choice
            stack.pop();
        }
    }

    private static void processSolution(Stack<Integer> stack) {
        System.out.println(stack);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        backtrack(nums);
    }
}

