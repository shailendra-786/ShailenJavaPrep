package com.serilazi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
// The transient keyword is not apply to both static and final so the both variable will participate in serialization
import java.io.Serializable;

class Student implements Serializable {
	private static final long serialVersionUID = 1L;
	transient int num1 = 10;
	transient final int num2 = 20; // here in this case transient keyword will not eliminated num2 because of final
									// block
	//	The transient keyword doesn't apply to final and static variables because final variables are constants
	transient static int num3 = 30; // here in this case transient keyword will not eliminated num3 because of
									// static block
	// static variables belong to the class, not the instance.
}

public class TransientStaticAndFinalAndIssue {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		FileOutputStream fos = new FileOutputStream("student.ser");
		try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			Student s = new Student();
			oos.writeObject(s);
		}
		FileInputStream fis = new FileInputStream("student.ser");
		try (ObjectInputStream ois = new ObjectInputStream(fis)) {
			Student readObject = (Student) ois.readObject();
			System.out.println(readObject.num1);
			System.out.println(readObject.num2);
			System.out.println(Student.num3); // because this is static variable
		}

	}

}
