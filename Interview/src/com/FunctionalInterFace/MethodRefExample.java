package com.FunctionalInterFace;

@FunctionalInterface
interface TriFunction<T, U, V, R> {
	R apply(T t, U u, V v);
}

class Calculator {
	public static int add(int a, int b, int c) {
		return a + b + c;
	}

	public int add1(int a, int b, int c) {
		return a + b + c;
	}
}

public class MethodRefExample {
	public static void main(String[] args) {
		// Method Reference for a method with three parameters
		TriFunction<Integer, Integer, Integer, Integer> addRef = Calculator::add;
		TriFunction<Integer, Integer, Integer, Integer> addRefNonStatic = new Calculator()::add1;
		int result = addRef.apply(10, 20, 30);
		System.out.println("Result: " + result); // Output: Result: 60
	}
}
