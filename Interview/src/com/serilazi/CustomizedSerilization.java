/**
 * 
 */
package com.serilazi;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author ss982
 *
 */

class UserData implements Serializable {

	private static final long serialVersionUID = 5486775491439778961L;
	String userName = "shailendra";
	transient int passwordPin = 2;
	transient int password = 4959*2;

	private void writeObject(ObjectOutputStream oos) throws Exception {
		// Use default serialization for non-transient fields
		oos.defaultWriteObject();
		// Custom serialization logic
		oos.writeInt(password + 50);
		oos.writeInt(passwordPin + 50);
	}

	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		// Use default deserialization for non-transient fields
		in.defaultReadObject();
		// Custom deserialization logic
		password = in.readInt() - 50;
		passwordPin = in.readInt() - 50;
	}

}

public class CustomizedSerilization {
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		FileOutputStream fos = new FileOutputStream("UserData.ser");
		try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			UserData userData = new UserData();
			oos.writeObject(userData);
		}
		FileInputStream fis = new FileInputStream("UserData.ser");
		try (ObjectInputStream ois = new ObjectInputStream(fis)) {
			UserData readObject = (UserData) ois.readObject();
			System.out.println(readObject.password/readObject.passwordPin);
		}
	}

}
