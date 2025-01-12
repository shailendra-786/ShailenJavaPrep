package geeks.array;

public class FindMinimumJumpToReachEnd {
	public static int minJumps(int[] arr) {
		int n = arr.length;
		int[] jumps = new int[n]; // To store the minimum jumps required to reach each position
		jumps[0] = 0; // Minimum jumps required to reach the first position is 0

		for (int i = 1; i < n; i++) {
			jumps[i] = Integer.MAX_VALUE;
			for (int j = 0; j < i; j++) {
				if (j + arr[j] >= i && jumps[j] != Integer.MAX_VALUE) {
					jumps[i] = Math.min(jumps[i], jumps[j] + 1);
				}
			}
		}

		return jumps[n - 1];
	}

	public static void main(String[] args) {
		int[] arr = { 2, 3, 1, 1, 4 }; // Example input array
//        int[] arr = {1, 1, 1, 1, 1}; // Example input array
		System.out.println("Minimum number of jumps: " + minJumps(arr));
	}
}
