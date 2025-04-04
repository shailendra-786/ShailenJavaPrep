package algo.slidingwindow.variable1;

import java.util.*;

public class LongestSubstringKDistinct {
    public static int longestSubstringKDistinct(String s, int K) {
        Map<Character, Integer> freqMap = new HashMap<>();
        int start = 0, maxLen = 0;

        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);

            while (freqMap.size() > K) {  // Shrink window
                char startChar = s.charAt(start);
                freqMap.put(startChar, freqMap.get(startChar) - 1);
                if (freqMap.get(startChar) == 0) {
                    freqMap.remove(startChar);
                }
                start++;
            }

            maxLen = Math.max(maxLen, end - start + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "eceba";
        int K = 2;
        System.out.println(longestSubstringKDistinct(s, K)); // Output: 3 ("ece")
    }
}
