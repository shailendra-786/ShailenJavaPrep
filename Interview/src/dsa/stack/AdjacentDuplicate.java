package dsa.stack;

import java.util.Stack;

//Remove All Adjacent Duplicates In String

public class AdjacentDuplicate {

	public static void main(String[] args) {
		String s = "azxxza";
		System.out.println(removeDuplicates(s));
	}
	public static String removeDuplicates(String s) {
		Stack<Character> st = new Stack<Character>();
		for(Character c : s.toCharArray()) {
			if(!st.isEmpty() && st.peek()==c) {
				st.pop();
				continue;
			}
			st.push(c);
		}
		StringBuilder sb = new StringBuilder();
		while(!st.isEmpty()) {
			sb.append(st.pop());
		}
		return sb.reverse().toString();
    }
}

