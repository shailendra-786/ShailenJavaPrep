package com.shailu.ser;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serilization {

	public static void main(String[] args) throws Exception {

		Person person = new Person("John Doe", "password");
		try (FileOutputStream fos = new FileOutputStream("person.ser1");
		     ObjectOutputStream oos = new ObjectOutputStream(fos)) {
		    oos.writeObject(person);
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		try (FileInputStream fis = new FileInputStream("person.ser1");
			     ObjectInputStream ois = new ObjectInputStream(fis)) {
			    Person deserializedPerson = (Person) ois.readObject();
			    System.out.println(deserializedPerson.getName() + ", " + deserializedPerson.getPassword());
			} catch (IOException | ClassNotFoundException e) {
			    e.printStackTrace();
			}


	}

}
