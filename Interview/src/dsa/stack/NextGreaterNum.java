package dsa.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterNum {

	public static void main(String[] args) {
		int[] nums1 = { 4, 1, 2 }, nums2 = { 1, 3, 4, 2 };
		Arrays.stream(nextGreaterElement(nums1, nums2)).forEach(System.out::println);
	}

	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
		Map<Integer, Integer> map = new HashMap<>();
		Stack<Integer> stack = new Stack<>();
		for (int num : nums2) {
			while (!stack.isEmpty() && num > stack.peek()) {
				map.put(stack.pop(), num);
			}
			stack.push(num);
		}
		while (!stack.isEmpty()) {
			map.put(stack.pop(), -1);
		}
		int[] result = new int[nums1.length];
		for (int i = 0; i < nums1.length; i++) {
			result[i] = map.get(nums1[i]);
		}
		return result;
	}

	public static int[] nextGreaterMy(int nums1[], int nums2[]) {
		int len1 = nums1.length;
		int len2 = nums2.length;
		int num3[] = new int[len1];
		Arrays.fill(num3, -1);
		for (int i = 0; i < len1; i++) {
			for (int j = 0; j < len2 - 1; j++) {
				if (nums1[i] == nums2[j] && nums2[j] < nums2[j + 1]) {
					num3[i] = nums2[j + 1];
				}
			}
		}

		return num3;
	}

}
