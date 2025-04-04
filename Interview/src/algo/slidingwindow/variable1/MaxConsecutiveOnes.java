package algo.slidingwindow.variable1;

public class MaxConsecutiveOnes {
	public static int longestOnes(int[] nums, int k) {
		int left = 0, maxLength = 0, zeroCount = 0;

		for (int right = 0; right < nums.length; right++) {
			if (nums[right] == 0) {
				zeroCount++;
			}

			while (zeroCount > k) { // Too many zeroes, shrink window
				if (nums[left] == 0) {
					zeroCount--;
				}
				left++; // Move left pointer
			}

			maxLength = Math.max(maxLength, right - left + 1);
		}

		return maxLength;
	}

	public static void main(String[] args) {
		System.out.println(longestOnes(new int[] { 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1 }, 2)); // Output: 8
		System.out.println(longestOnes(new int[] { 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0 }, 3)); // Output: 10
	}
}
