package com.serilazi;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class SerializationAndDeSerExample {

	public static void main(String[] args) throws IOException {

//		try {
//			Person person = new Person("Pooja", 26,"Sada hak");
//			FileOutputStream fileout = new FileOutputStream("person.ser");
//			ObjectOutputStream out = new ObjectOutputStream(fileout);
//			out.writeObject(person);
//			fileout.close();
//			out.close();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
		
		FileInputStream filein = new FileInputStream("person.ser");
		ObjectInputStream in = new ObjectInputStream(filein);
		try {
			Person person = (Person)in.readObject();
			System.out.println(person.toString());
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}

	}

}
