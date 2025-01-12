package com.practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PalindromRecursive {
	public static void main(String[] args) {
		 System.out.println(isPalindrome1("hello"));
	}
	
	public static boolean checkPalindrom(String str) {
		int len = str.length() / 2;
		int j = str.length() - 1;
		for (int i = 0; i < len; i++) {
			if (str.charAt(i) != str.charAt(j - i)) {
				return false;
			}

		}
		return true;
	}
	
	 public static boolean isPalindrome(String s) {
	        // Base case: if the string has 0 or 1 characters, it's a palindrome
	        if (s.length() <= 1) {
	            return true;
	        }
	        
	        // Compare the first and last characters
	        if (s.charAt(0) != s.charAt(s.length() - 1)) {
	            return false;
	        }
	        
	        // Recursive case: check the substring between the first and last characters
	        return isPalindrome(s.substring(1, s.length() - 1));
	    }
	 
	 public static boolean isPalindrome1(String s) {
	        s = s.toLowerCase(); // Convert to lowercase for case-insensitive comparison
	        
	        Stack<Character> stack = new Stack<>();
	        Queue<Character> queue = new LinkedList<>();
	        
	        // Populate the stack and queue with characters from the string
	        for (int i = 0; i < s.length(); i++) {
	            char c = s.charAt(i);
	            if (Character.isLetterOrDigit(c)) { // Ignore non-alphanumeric characters
	                stack.push(c);
	                queue.add(c);
	            }
	        }
	        System.out.println(stack.toString());
	        System.out.println(queue.toString());
	        // Compare characters from the front and back of the stack and queue
	        while (!stack.isEmpty()) {
	        	System.out.println(queue.peek()+" "+stack.peek());
	            if (!stack.pop().equals(queue.poll())) {
	                return false;
	            }
	        }
	        
	        return true;
	    }
	
}
