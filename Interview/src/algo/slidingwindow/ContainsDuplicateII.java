package algo.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateII {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		// Create a HashSet to store the elements in the current window
		HashSet<Integer> window = new HashSet<>();

		// Iterate over the array
		for (int i = 0; i < nums.length; i++) {
			// If the element is already in the window, we found a duplicate
			if (window.contains(nums[i])) {
				return true;
			}

			// Add the current element to the window
			window.add(nums[i]);

			// If the window size exceeds k, remove the oldest element (sliding the window)
			if (window.size() > k) {
				window.remove(nums[i - k]); // Remove the element that's sliding out of the window
			}
		}

		// No duplicates found within the window size of k
		return false;
	}

	public boolean containsNearbyDuplicateLeetCode(int[] nums, int k) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (i > k) {
				set.remove(nums[i - k - 1]);
			}
			if (!set.add(nums[i])) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		ContainsDuplicateII solution = new ContainsDuplicateII();

		// Example test case
		int[] nums = { 1, 2, 3, 1 };
		int k = 3;

		System.out.println(solution.containsNearbyDuplicate(nums, k)); // Output: true
	}
}
