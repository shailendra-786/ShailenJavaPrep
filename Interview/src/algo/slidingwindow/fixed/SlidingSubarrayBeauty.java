package algo.slidingwindow.fixed;

import java.util.*;

public class SlidingSubarrayBeauty {

	public static int[] getSubarrayBeauty(int[] nums, int k, int x) {
		int n = nums.length;
		int[] result = new int[n - k + 1];

		// Using a frequency array to track occurrences of negative numbers
		int[] freq = new int[51]; // Since we only care about negative numbers, ranging from -1 to -50

		int left = 0; // Left pointer of the sliding window
		int right = 0; // Right pointer of the sliding window

		while (right < n) {
			// Add the current element to the window if it's negative
			if (nums[right] < 0) {
				freq[-nums[right]]++;
			}

			// If window is valid (i.e., its size is k)
			if (right - left + 1 == k) {
				// Now we need to find the x-th smallest negative number
				int count = 0;
				int beauty = 0;

				// Find the x-th negative number
				for (int i = 50; i >= 1; i--) {
					count += freq[i]; // freq[i] contains how many times -i appears in the window

					if (count >= x) {
						beauty = -i; // The x-th negative number is -i
						break;
					}
				}

				// If there are fewer than x negative numbers, beauty remains 0
				result[left] = beauty;

				// Remove the leftmost element (as the window slides)
				if (nums[left] < 0) {
					freq[-nums[left]]--;
				}

				// Slide the window
				left++;
			}

			right++;
		}

		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 1, -1, -3, -2, 3, -1, -2 };
		int k = 3;
		int x = 2;

		int[] result = getSubarrayBeauty(nums, k, x);
		System.out.println(Arrays.toString(result)); // Output: [-2, -3, -2, -2, -1]
	}
}
