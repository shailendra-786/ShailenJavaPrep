package com.serilazi;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Parent implements Serializable {

	private static final long serialVersionUID = 1L;
}

class Child extends Parent {

	private static final long serialVersionUID = 1L;
	private String name;

	public Child(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}

public class SerializationWithInheritance {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileOutputStream fos = new FileOutputStream("Child.ser");
		try (var oos = new ObjectOutputStream(fos)) {
			oos.writeObject(new Child("shailu"));
		}

		try (FileInputStream fis = new FileInputStream("Child.ser");
				ObjectInputStream ois = new ObjectInputStream(fis)) {
			Child r = (Child) ois.readObject();
			System.out.println(r.getName());
		}
	}

}
