package br.edu.ifrn.entities;
import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;


import java.io.Serializable;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;


public class Serialization implements Serializable {
	
	public static void saveContactList(Object obj) {
		try {
			System.err.println("entrou no try");
			FileOutputStream fos = new FileOutputStream("file.data");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(obj);
			oos.close();
			System.out.println("salvou");
		}catch(Throwable error) {
			System.out.println("errorrororo" + error);
		}
	}
	
	public static ArrayList<Contact> contactListLoading() {
		try {
			FileInputStream fis = new FileInputStream("file.data");
			ObjectInputStream ois = new ObjectInputStream(fis);
			ArrayList<Contact> objectRead = (ArrayList<Contact>) ois.readObject();
			ois.close();
			return objectRead;
		}catch(Throwable error) {
			System.out.println("error: " + error);
			return null;
		}
	}
	
	
}

























