package algo.dp;
import java.util.*;

public class LargestDivisibleSubset {
 public static void main(String[] args) {
	 int[] nums = {1,2,4,8};
	System.out.println(largestDivisibleSubset(nums));
}
 
 public static List<Integer> largestDivisibleSubset(int[] nums) {
	    List<Integer> result = new ArrayList<>();
	    if (nums == null || nums.length == 0) {
	        return result;
	    }
	    int n = nums.length;
	    Arrays.sort(nums);
	    int[] dp = new int[n];
	    int[] prev = new int[n];
	    Arrays.fill(dp, 1);
	    Arrays.fill(prev, -1);
	    int maxIndex = 0;
	    for (int i = 1; i < n; i++) {
	        for (int j = 0; j < i; j++) {
	            if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
	                dp[i] = dp[j] + 1;
	                prev[i] = j;
	            }
	        }
	        if (dp[i] > dp[maxIndex]) {
	            maxIndex = i;
	        }
	    }
	    while (maxIndex != -1) {
	        result.add(nums[maxIndex]);
	        maxIndex = prev[maxIndex];
	    }
	    return result;
	}

}
