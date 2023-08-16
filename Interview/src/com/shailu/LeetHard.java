package com.shailu;

import java.util.Arrays;

public class LeetHard {
	
	
	
	public static void main(String[] args) {
		int[] arr  = {0,0,0,2,0,0};
		System.out.println(countZeroSubarrays(arr));
	}
	
	public static int countZeroSubarrays(int[] nums) {
	    int count = 0;
	    int left = 0;
	    int right = 0;

	    while (right < nums.length) {
	        if (nums[right] == 0) {
	        	System.out.println(right);
	            count += (right - left + 1);
	        } else {
	            left = right + 1;
	        }
	        right++;
	    }

	    return count;
	}

	public static int numZeroFilledSubarrays(int[] arr) {
	    int left = 0, right = 0, count = 0;
	    while (right < arr.length) {
	        if (arr[right] == 0) {
	            count++;
	        }
	        while (count > 0) {
	            if (arr[left] == 0) {
	                count--;
	            }
	            left++;
	        }
	        right++;
	    }
	    return count;
	}

	public static void main2(String[] args) {
	    int n = 1000000;
	    String s = "";
	    long start = System.currentTimeMillis();
	    for (int i = 0; i < n; i++) {
	        s += "a";
	    }
	    long end = System.currentTimeMillis();
	    System.out.println("Time taken by String concatenation: " + (end - start) + " ms");
	    
	    StringBuilder sb = new StringBuilder();
	    start = System.currentTimeMillis();
	    for (int i = 0; i < n; i++) {
	        sb.append("a");
	    }
	    end = System.currentTimeMillis();
	    System.out.println("Time taken by StringBuilder: " + (end - start) + " ms");
	}
	public static void main1(String[] args) {
//		System.out.println(longestValidParentheses(")((()())())"));
		int[] a = { 7, 2,11, 3, 1, 2, 4, 3 };
		findSubarray(a,7);
//		System.out.println(longestPalindrome("aabacc"));
		System.out.println(longestValidParenthesesDP("()("));
	}

	// Input: nums = [7,2, 3, 1, 2, 4, 3], targetSum = 7
//	Output: [2, 4, 3]
	public static int longestValidParenthesesDP(String s) {
	    int n = s.length();
	    int[] dp = new int[n];
	    int maxLen = 0;
	    
	    for (int i = 1; i < n; i++) {
	        if (s.charAt(i) == ')') {
	            if (s.charAt(i - 1) == '(') {
	                dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
	            } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
	                dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0);
	            }
	            maxLen = Math.max(maxLen, dp[i]);
	        }
	    }
	    
	    return maxLen;
	}

	public static String longestPalindrome(String s) {
	    int n = s.length();
	    boolean[][] dp = new boolean[n][n];
	    String longest = "";

	    // Mark all substrings of length 1 as palindromes
	    for (int i = 0; i < n; i++) {
	        dp[i][i] = true;
	        longest = s.substring(i, i+1);
	    }

	    // Mark all substrings of length 2 as palindromes
	    for (int i = 0; i < n-1; i++) {
	        if (s.charAt(i) == s.charAt(i+1)) {
	            dp[i][i+1] = true;
	            longest = s.substring(i, i+2);
	        }
	    }

	    // Check substrings of length 3 or greater
	    for (int len = 3; len <= n; len++) {
	        for (int i = 0; i <= n-len; i++) {
	            int j = i+len-1;
	            if (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]) {
	                dp[i][j] = true;
	                longest = s.substring(i, j+1);
	            }
	        }
	    }

	    return longest;
	}


	public static int[] findSubarray(int[] nums, int targetSum) {
		int left = 0, right = 0;
		int currentSum = 0, minLength = nums.length + 1;
		int[] subarray = new int[0];

		while (right < nums.length) {
			currentSum += nums[right];

			while (currentSum >= targetSum) {
				if (right - left + 1 < minLength) {
					minLength = right - left + 1;
					subarray = Arrays.copyOfRange(nums, left, left + minLength);
				}

				currentSum -= nums[left];
				left++;
			}

			right++;
		}

		return subarray;
	}

	public static int longestValidParentheses(String s) {
		int maxLen = 0;
		int left = 0, right = 0;
		// Traverse from left to right
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				left++;
			} else {
				right++;
			}
			if (right > left) {
				left = right = 0;
			} else if (left == right) {
				maxLen = Math.max(maxLen, 2 * right);
			}
		}
		left = right = 0;
		// Traverse from right to left
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == ')') {
				right++;
			} else {
				left++;
			}
			if (left > right) {
				left = right = 0;
			} else if (left == right) {
				maxLen = Math.max(maxLen, 2 * left);
			}
		}
		return maxLen;
	}

}
