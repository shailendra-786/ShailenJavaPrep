package algo.twopointer;

public class ValidPalindrome {

	// Method to check if a given string is a valid palindrome
	public boolean isPalindrome(String s) {
		int left = 0;
		int right = s.length() - 1;

		while (left < right) {
			// Move left pointer to next alphanumeric character
			while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
				left++;
			}
			// Move right pointer to previous alphanumeric character
			while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
				right--;
			}
			// Compare characters (ignoring case)
			if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
				return false;
			}
			// Move towards the middle
			left++;
			right--;
		}
		return true;
	}

	// Main method to run tests
	public static void main(String[] args) {
		ValidPalindrome solution = new ValidPalindrome();

		// Test cases
		String test1 = "A man, a plan, a canal: Panama";
		String test2 = "race a car";
		String test3 = " ";

		// Print the results
		System.out.println("Test 1: " + solution.isPalindrome(test1)); // true
		System.out.println("Test 2: " + solution.isPalindrome(test2)); // false
		System.out.println("Test 3: " + solution.isPalindrome(test3)); // true
	}
}
