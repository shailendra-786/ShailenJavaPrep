package dsa.stack;

import java.util.Stack;

//Make The String Great

public class MakeStringGreat {

	public static void main(String[] args) {
		String str = "lEetcode";
//		String str = "abBAabBAcC";
		System.out.println("with stack " + makeGood(str));
		System.out.println("without stack " + removeAdjacentDuplicateLowerAndUpperLetter(str));

	}

	public static StringBuilder makeGood(String s) {
		Stack<Character> st = new Stack<>();
		for (Character c : s.toCharArray()) {
			if (!st.isEmpty() && Character.toLowerCase(st.peek()) == Character.toLowerCase(c) && st.peek() != c) {
				st.pop();
				continue;
			}
			st.push(c);
		}
		StringBuilder sb = new StringBuilder();
		while (!st.isEmpty()) {
			sb.append(st.pop());
		}
		return sb.reverse();
	}

	public static String removeAdjacentDuplicateLowerAndUpperLetter(String s1) {

		StringBuilder s = new StringBuilder(s1);
		for (int i = 0; i < s.length() - 1;) {
			char c1 = s.charAt(i);
			char c2 = s.charAt(i + 1);
			if (c1 != c2 && Character.toLowerCase(c1) == Character.toLowerCase(c2)) {
				s.delete(i, i + 2);
				if (i > 0) {
					i--;
				}

			} else {
				i++;
			}
		}

		return s.toString();
	}

}
