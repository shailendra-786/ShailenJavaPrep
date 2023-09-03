package com.javaRelatedCode;

// here we will see method overloading with different return data type along with access modifier and priority between wrapper class
// and primitive type. this is last one Object and String which one will be going to call and i am kidding there is one more
// type promotion..

class Parent {
	int getData(int data) { // always goes priority to primitive type first ... Note if you comment this
							// function then float will called because type promotion and second primitive
							// type(Since widening has precedence over boxing, the first method is chosen.)
		System.out.println("int");
		return data;
	}

//	Integer getData(Integer i) {
//		System.out.println("integer");
//		return i;
//	}

	protected float getData(float data) {
		return data;
	}

	// let go through with ambiguis overloading

	// here in this example more specific method will call here String will call
	// because Object is parent of String.
	public Object getData(Object name) {
		System.out.println("object");
		return name;
	}

	public String getData(String name) {
		System.out.println("String");
		return name;
	}

	public void getData(float i, int j) {
		System.out.println("float and int");
	}

	public void getData(int i, float j) {
		System.out.println("int and float");
	}

	// int is primitive type in java but int[] is not primitive and it is class
	// which extends Object class.
//	you can pass null to int[] because it is object and passing null to int will give compiler error.
	public void test(int... i) {
		System.out.println("method 1");
	}

	public void test(Integer... i) {
		System.out.println("method 2");
	}

//Note: Methods with varargs (...) have the lowest priority.
//           Priority goes as Widening --> Boxing --> Var args.
	public void test(int i) {
		System.out.println("Int");
	}

	public void test(char... c) {
		System.out.println("Char varargs");
	}

}

public class PolymorphismStatic {
	public static void main(String[] args) {
		Parent p = new Parent();
		System.out.println(p.getData(null)); // to check ambiguity here uncommented Integer getData method because
												// String and Integer both are at same level in hierarchy
		p.getData(1, 1.1f);
//		p.getData(1,1); // here you will get error because of type promotion int is converted into float

	}
}
