package algo.slidingwindow.fixed;

import java.util.*;

public class AnagramFinder {
    
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();
        
        if (sLen < pLen) {
            return result;  // If s is shorter than p, no anagrams can exist
        }
        
        // Frequency arrays for characters in 'a' to 'z'
        int[] pCount = new int[26];  // To store frequency of characters in p
        int[] sCount = new int[26];  // To store frequency of current window in s
        
        // Populate the frequency count for string p
        for (int i = 0; i < pLen; i++) {
            pCount[p.charAt(i) - 'a']++;
        }
        
        // First window in s
        for (int i = 0; i < pLen; i++) {
            sCount[s.charAt(i) - 'a']++;
        }
        
        // Check the first window
        if (Arrays.equals(pCount, sCount)) {
            result.add(0);
        }
        
        // Sliding window
        for (int i = pLen; i < sLen; i++) {
            // Remove the character that goes out of the window
            sCount[s.charAt(i - pLen) - 'a']--;
            // Add the new character that comes into the window
            sCount[s.charAt(i) - 'a']++;
            
            // Compare current window with p's frequency array
            if (Arrays.equals(pCount, sCount)) {
                result.add(i - pLen + 1);
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> result = findAnagrams(s, p);
        System.out.println(result);  // Output: [0, 6]
    }
}

