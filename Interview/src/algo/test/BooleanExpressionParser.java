package algo.test;

import java.util.*;

public class BooleanExpressionParser {
	public static boolean parseBooleanExpression(String expression) {
		Deque<Character> st = new ArrayDeque<>();
		for (int i = 0; i < expression.length(); i++) {
			char c = expression.charAt(i);
			if (c == ')') {
				Set<Character> seen = new HashSet<>();
				while (st.peek() != '(')
					seen.add(st.pop());
				st.pop(); // remove (
				char operator = st.pop(); 
				if (operator == '&') {
					st.push(seen.contains('f') ? 'f' : 't');
				} else if (operator == '|') {
					st.push(seen.contains('t') ? 't' : 'f');
				} else if (operator == '!') {
					st.push(seen.contains('t') ? 'f' : 't');
				}

			} else if (c != ',') {
				st.push(c);
			}
		}
		return st.pop() == 't';
	}

	public static void main(String[] args) {
		String expression1 = "&(|(f))";
		boolean result1 = parseBooleanExpression(expression1);
		System.out.println("Result 1: " + result1); // Output: false

		String expression2 = "|(f,f,f,t)";
		boolean result2 = parseBooleanExpression(expression2);
		System.out.println("Result 2: " + result2); // Output: true

		String expression3 = "!(&(t,f,t))";
		boolean result3 = parseBooleanExpression(expression3);
		System.out.println("Result 3: " + result3); // Output: true
	}
}
