package com.javaRelatedCode;

class SingleTon {
	private static SingleTon obj = null;

	private SingleTon() {
	}

	public static SingleTon getObj() {
		if (obj == null) {
			obj = new SingleTon();
		}
		return obj;
	}
}

public class SingletonClass {
	public static void main(String[] args) {
		System.out.println(SingleTon.getObj().hashCode());
		System.out.println(SingleTon.getObj().hashCode());
	}
}
