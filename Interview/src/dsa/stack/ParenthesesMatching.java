package dsa.stack;

import java.util.Stack;

public class ParenthesesMatching {
    public static boolean isParenthesesBalanced(String input) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (isOpenParentheses(ch)) {
                stack.push(ch);
            } else if (isCloseParentheses(ch)) {
                if (stack.isEmpty() || !isMatchingPair(stack.pop(), ch)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private static boolean isOpenParentheses(char ch) {
        return ch == '(' || ch == '[' || ch == '{';
    }

    private static boolean isCloseParentheses(char ch) {
        return ch == ')' || ch == ']' || ch == '}';
    }

    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') || (open == '[' && close == ']') || (open == '{' && close == '}');
    }

    public static void main(String[] args) {
        String input = "(([{[()]}]))";
        boolean isBalanced = isParenthesesBalanced(input);
        System.out.println("Parentheses Balanced: " + isBalanced);
    }
}
