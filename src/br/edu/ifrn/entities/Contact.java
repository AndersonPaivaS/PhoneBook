package br.edu.ifrn.entities;
import java.io.Serializable;
import java.lang.Comparable;

public class Contact implements Comparable<Contact>, Serializable {
	private String name, phoneNumber;

	public Contact() {
	}

	public Contact(String name, String phoneNumber) {
		setName(name);
		setPhoneNumber(phoneNumber);
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	@Override
	public int compareTo(Contact contact){
		return name.compareTo(contact.getName());
	}
}