package com.serilazi;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

// if you are serialize class Dog then you have to serialize cat and rat class also because here dog call cat. cat call rat show all class 
//here will be serialize. make sure to all class will implement Serializable otherwise at R.E you will get check yourself 
class Dog implements Serializable {
	
	private static final long serialVersionUID = 1L;
	Cat c = new Cat();
}

class Cat implements Serializable {
	
	private static final long serialVersionUID = 1L;
	Rat r = new Rat();
}

class Rat implements Serializable {
	
	private static final long serialVersionUID = 1L;
	String name = "Bhushaneshawr";
}

public class SerializeGraph {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		try (FileOutputStream fos = new FileOutputStream("Dog.ser");
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(new Dog());
			oos.writeObject(new Cat());
			oos.writeObject(new Rat());
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (FileInputStream fis = new FileInputStream("Dog.ser");
				ObjectInputStream ois = new ObjectInputStream(fis)) {
			// the order in which object are serialize in same order here(Deserialize) we have to read obj
			Dog d = (Dog)ois.readObject();
			Cat c = (Cat)ois.readObject();
			Rat r = (Rat)ois.readObject();
			System.out.println(r.name);
		}

	}

}
