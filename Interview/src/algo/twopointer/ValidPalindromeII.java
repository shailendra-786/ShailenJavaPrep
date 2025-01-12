package algo.twopointer;

public class ValidPalindromeII {
    
    // Main method to check if the string can be a palindrome by removing at most one character
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                // Check if removing either left or right character results in a valid palindrome
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
        }
        return true;
    }

    // Helper method to check if a substring is a palindrome
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Main method to run tests
    public static void main(String[] args) {
        ValidPalindromeII solution = new ValidPalindromeII();

        // Test cases
        String test1 = "abca";
        String test2 = "racecar";
        String test3 = "abcd";
        String test4 = "ab";

        // Print the results
        System.out.println("Test 1: " + solution.validPalindrome(test1)); // true
        System.out.println("Test 2: " + solution.validPalindrome(test2)); // true
        System.out.println("Test 3: " + solution.validPalindrome(test3)); // false
        System.out.println("Test 4: " + solution.validPalindrome(test4)); // true
    }
}
