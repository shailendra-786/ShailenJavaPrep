package com.javaRelatedCode;

class P {
	public  void method() {
		System.out.println("parent");
	}
}

class C extends P {
	public  void method() {
		System.out.println("child");
	}
}

public class MethodHiding {

	public static void main(String[] args) {
		P p = new C();
		p.method();
	}

}



//public class MainClass {
//	 public static void main(String[] args) {
//	  Parent p = new Child();
//	  System.out.println(p.getObject().x);
//	 }
//	}
//	 
//	class Parent {
//	 int x = 10;
//	 
//	 public Parent getObject() {
//	  return new Parent();
//	 }
//	} 
//	 
//	class Child extends Parent {
//	 int x = 20;
//	 
//	 public Child getObject() {
//	  return new Child();
//	 }
//	}