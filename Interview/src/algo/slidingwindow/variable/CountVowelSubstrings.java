package algo.slidingwindow.variable;

import java.util.HashSet;
import java.util.Set;

public class CountVowelSubstrings {
    public int countVowelSubstrings(String word) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        int count = 0;
        int n = word.length();

        // Iterate through the string to find contiguous vowel substrings
        for (int start = 0; start < n; start++) {
            if (isVowel(word.charAt(start))) {
                // Found a potential starting point for vowel substrings
                Set<Character> currentVowels = new HashSet<>();
                for (int end = start; end < n; end++) {
                    if (!isVowel(word.charAt(end))) {
                        break; // Stop if we encounter a non-vowel
                    }
                    currentVowels.add(word.charAt(end));

                    // Check if we have all five vowels
                    if (currentVowels.size() == 5) {
                        count++; // This substring contains all vowels

                        // Count all possible substrings from here to the end
                        count += (end - start);
                    }
                }
            }
        }

        return count;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String[] args) {
        CountVowelSubstrings solution = new CountVowelSubstrings();
        System.out.println(solution.countVowelSubstrings("aeiouu"));         // Output: 2
        System.out.println(solution.countVowelSubstrings("unicornarihan"));  // Output: 0
        System.out.println(solution.countVowelSubstrings("cuaieuouac"));     // Output: 7
    }
}
