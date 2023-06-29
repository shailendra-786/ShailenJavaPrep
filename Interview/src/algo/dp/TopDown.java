package algo.dp;

import java.util.Arrays;

public class TopDown {

	public static void main(String[] args) {
		int[] arr = { 2, 4, 6, 8 };
		System.out.println(maxSubsetSum(arr));
	}

	public static int maxSubsetSum(int[] nums) {
		int[] dp = new int[nums.length];
		Arrays.fill(dp, -1);	
		return maxSubsetSumHelper(nums, dp, 0);
	}

	private static int maxSubsetSumHelper(int[] nums, int[] dp, int i) {
		if (i >= nums.length) {
			return 0;
		}
		if (dp[i] != -1) {
			return dp[i];
		}
		int sum1 = nums[i] + maxSubsetSumHelper(nums, dp, i + 2);
		int sum2 = maxSubsetSumHelper(nums, dp, i + 1);
		dp[i] = Math.max(sum1, sum2);
		System.out.println("call"+i);
		return dp[i];
	}
	
	

}
