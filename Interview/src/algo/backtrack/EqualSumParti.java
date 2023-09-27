package algo.backtrack;

public class EqualSumParti {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {10,5,5,1,1};
		System.out.println(canPartition(nums));

	}
	
	public static boolean canPartition(int[] nums) {
	    int sum = 0;
	    for (int num : nums) {
	        sum += num;
	    }
	    if (sum % 2 != 0) {  // If the sum is odd, we cannot partition into equal subsets
	        return false;
	    }
	    return backtrack(nums, 0, sum / 2, 0);
	}

	private static boolean backtrack(int[] nums, int index, int target, int currSum) {
	    if (currSum == target) {
	        return true;  // Found a partition that sums to target
	    }
	    if (currSum > target || index >= nums.length) {
	        return false;  // Exceeded target or reached end of array
	    }
	    // Try including current element in the subset
	    if (backtrack(nums, index + 1, target, currSum + nums[index])) {
	        return true;  // Found a partition that sums to target
	    }
	    // Try excluding current element from the subset
	    return backtrack(nums, index + 1, target, currSum);
	}


}
