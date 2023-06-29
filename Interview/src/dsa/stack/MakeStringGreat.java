package dsa.stack;

import java.util.Stack;

//Make The String Great

public class MakeStringGreat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "lEetcode";
		System.out.println(makeGood(str));

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

}
