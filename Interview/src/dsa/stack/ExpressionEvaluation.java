package dsa.stack;

import java.util.Stack;

public class ExpressionEvaluation {
	public static int evaluateExpression(String expression) {
		Stack<Integer> operandStack = new Stack<>();
		Stack<Character> operatorStack = new Stack<>();

		for (int i = 0; i < expression.length(); i++) {
			char ch = expression.charAt(i);

			if (Character.isDigit(ch)) {
				StringBuilder sb = new StringBuilder();
				while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
					sb.append(expression.charAt(i));
					i++;
				}
				i--; // Decrement i to account for the last digit in the number
				operandStack.push(Integer.parseInt(sb.toString()));
			} else if (ch == '(') {
				operatorStack.push(ch);
			} else if (ch == ')') {
				while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
					performOperation(operandStack, operatorStack);
				}
				operatorStack.pop(); // Discard the opening parenthesis
			} else if (isOperator(ch)) {
				while (!operatorStack.isEmpty() && hasHigherPrecedence(ch, operatorStack.peek())) {
					performOperation(operandStack, operatorStack);
				}
				operatorStack.push(ch);
			}
		}

		while (!operatorStack.isEmpty()) {
			performOperation(operandStack, operatorStack);
		}

		return operandStack.pop();
	}

	private static boolean isOperator(char ch) {
		return ch == '+' || ch == '-' || ch == '*' || ch == '/';
	}

	private static boolean hasHigherPrecedence(char op1, char op2) {
		if (op2 == '(' || op2 == ')') {
			return false;
		}
		return (op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-');
	}

	private static void performOperation(Stack<Integer> operandStack, Stack<Character> operatorStack) {
		int operand2 = operandStack.pop();
		int operand1 = operandStack.pop();
		char operator = operatorStack.pop();
		int result = applyOperator(operand1, operand2, operator);
		operandStack.push(result);
	}

	private static int applyOperator(int operand1, int operand2, char operator) {
		switch (operator) {
		case '+':
			return operand1 + operand2;
		case '-':
			return operand1 - operand2;
		case '*':
			return operand1 * operand2;
		case '/':
			return operand1 / operand2;
		default:
			return 0;
		}
	}

	public static void main(String[] args) {
		String expression = "13+(4*5)-(6/2)";
		int result = evaluateExpression(expression);
		System.out.println("Expression Result: " + result);
	}
}
