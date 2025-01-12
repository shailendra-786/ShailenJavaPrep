package algo.slidingwindow;

public class MinimumRecolorsToGetKConsecutiveBlackBlocks {
	public int minimumRecolors(String blocks, int K) {
		int minRecolors = Integer.MAX_VALUE;
		int currentRecolors = 0;

		// Initialize the sliding window by counting 'W' in the first window of size K
		for (int i = 0; i < K; i++) {
			if (blocks.charAt(i) == 'W') {
				currentRecolors++;
			}
		}
		System.out.println(currentRecolors);

		// Set the minimum recolors for the first window
		minRecolors = currentRecolors;

		// Slide the window through the rest of the string
		for (int i = K; i < blocks.length(); i++) {
			// Add the next character in the window
			if (blocks.charAt(i) == 'W') {
				currentRecolors++;
			}

			// Remove the first character of the previous window
			if (blocks.charAt(i - K) == 'W') {
				currentRecolors--;
			}

			// Update the minimum recolors
			minRecolors = Math.min(minRecolors, currentRecolors);
		}

		return minRecolors;
	}

	public static void main(String[] args) {
		MinimumRecolorsToGetKConsecutiveBlackBlocks solution = new MinimumRecolorsToGetKConsecutiveBlackBlocks();
		String blocks = "WBWBBBW";
		int K = 2;
		System.out.println("Minimum recolors: " + solution.minimumRecolors(blocks, K)); // Output: 1
	}

}

//int minimumRecolors(string blocks, int k) {
//    int back = 0, front = 0, count_w = 0, ans = INT_MAX;
//    while(front < blocks.size()){
//        if(blocks[front] == 'W'){ count_w++; }
//        if(front - back + 1 == k){
//            ans = min(ans, count_w);
//            if(blocks[back] == 'W') count_w--;
//            back++;
//        }
//        front++;
//    }
//    return ans;
//}
