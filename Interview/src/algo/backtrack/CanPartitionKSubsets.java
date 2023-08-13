package algo.backtrack;

public class CanPartitionKSubsets {

	public static void main1(String[] args) {
		int[] nums = { 1, 2, 3, 4 };
		int k = 2;
		System.out.println(canPartitionKSubsets(nums, k));
	}

	public static boolean canPartition(int[] arr) {
		int n = arr.length;
		int totalSum = 0;

		// Compute the total sum of the array
		for (int i = 0; i < n; i++) {
			totalSum += arr[i];
		}

		// If the total sum is odd, we cannot partition the array into two equal-sum
		// subsets
		if (totalSum % 2 != 0) {
			return false;
		}

		// Initialize the P array
		boolean[][] P = new boolean[n + 1][totalSum / 2 + 1];
		for (int i = 0; i <= n; i++) {
			P[i][0] = true;
		}

		System.out.println(n);
		// Compute the values of P using the recurrence relation
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= totalSum / 2; j++) {
				P[i][j] = P[i - 1][j];
				System.out.println(P[i][j]);
				if (j >= arr[i - 1]) {
					P[i][j] = P[i][j] || P[i - 1][j - arr[i - 1]];
					System.out.println(P[i][j]);
				}
			}
		}

		// Return the value of P[n][totalSum / 2], which tells us whether the array can
		// be partitioned into two equal-sum subsets
		System.out.println(n);
		return P[n][totalSum / 2];
	}

	// Example usage
	public static void main(String[] args) {
		int[] arr = { 1, 5, 11, 5 };
		boolean result = canPartition(arr);
		System.out.println(result); // Output: true
	}

	public static boolean canPartitionKSubsets(int[] nums, int k) {
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		if (sum % k != 0) {
			return false;
		}
		int target = sum / k;
		boolean[] used = new boolean[nums.length];
		return backtrack(nums, k, 0, 0, target, used);
	}

	private static boolean backtrack(int[] nums, int k, int start, int curSum, int target, boolean[] used) {
		if (k == 0) {
			return true;
		}
		if (curSum == target) {
			return backtrack(nums, k - 1, 0, 0, target, used);
		}
		for (int i = start; i < nums.length; i++) {
			if (!used[i] && curSum + nums[i] <= target) {
				used[i] = true;
				if (backtrack(nums, k, i + 1, curSum + nums[i], target, used)) {
					return true;
				}
				used[i] = false;
			}
		}
		return false;
	}

}
