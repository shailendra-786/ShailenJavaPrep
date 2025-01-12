package algo.slidingwindow;

public class SubstringsOfSizeThreeWithDistinctCharacters {
	public int countGoodSubstrings(String s) {
		int count = 0;

		// Traverse the string with a sliding window of size 3
		for (int i = 0; i <= s.length() - 3; i++) {
			char c1 = s.charAt(i);
			char c2 = s.charAt(i + 1);
			char c3 = s.charAt(i + 2);

			// Check if all three characters are distinct
			if (c1 != c2 && c2 != c3 && c1 != c3) {
				count++;
			}
		}

		return count;
	}

	public static void main(String[] args) {
		SubstringsOfSizeThreeWithDistinctCharacters solution = new SubstringsOfSizeThreeWithDistinctCharacters();
		String s = "xyzzaz";
		System.out.println("Number of good substrings: " + solution.countGoodSubstrings(s)); // Output: 2
	}
}
