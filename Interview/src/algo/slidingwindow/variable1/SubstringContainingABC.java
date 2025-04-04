package algo.slidingwindow.variable1;

public class SubstringContainingABC {
    public static int numberOfSubstrings(String s) {
        int left = 0, count = 0;
        int[] freq = new int[3]; // Frequency of 'a', 'b', 'c'

        for (int right = 0; right < s.length(); right++) {
            freq[s.charAt(right) - 'a']++;

            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                count += s.length() - right; // Count all valid substrings
                freq[s.charAt(left) - 'a']--;
                left++; // Shrink window
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(numberOfSubstrings("abcabc")); // Output: 10
        System.out.println(numberOfSubstrings("aaacb"));  // Output: 3
    }
}
