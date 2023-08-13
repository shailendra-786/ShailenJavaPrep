package dsa.stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreater2 {

	public static void main(String[] args) {
		int[] nums = {1,2,1};
		Arrays.stream(nextGreaterElements(nums)).forEach(System.out::println);
	}

	public static int[] nextGreaterElements(int[] nums) {
		int n = nums.length;
		int[] result = new int[n];	
		Arrays.fill(result, -1);
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < 2 * n; i++) {
			int j = i % n;
			System.out.println(j);
			while (!stack.isEmpty() && nums[stack.peek()] < nums[j]) {
//				System.out.println(stack.peek()+" st");
				result[stack.pop()] = nums[j];
			}
			stack.push(j);  
		}
		return result;
	}

}
