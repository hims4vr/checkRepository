package testpackage.serial.ex;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TestTransientVal implements Serializable{

	private static final long serialVersionUID = -22L;
	private String name;
	transient private int age =10;

	TestTransientVal(int age, String name) {
//		this.age = age;
		this.name = name;
	}

	public static void main(String[] args) {
		TestTransientVal c = new TestTransientVal(1, "ONE");
		System.out.println("Before serialization:" + c.name + " " + c.age);
		try {
			FileOutputStream fs = new FileOutputStream("testTransient.ser");
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(c);
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			FileInputStream fis = new FileInputStream("testTransient.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			c = (TestTransientVal) ois.readObject();
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("After  de-serialization:" + c.name + " " + c.age);
	}
}
