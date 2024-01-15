package br.edu.ifrn.entities;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.io.Serializable;
import java.lang.*;

public class PhoneBook implements Serializable{
	private ArrayList<Contact> contacts = new ArrayList<Contact>();
	Serialization serialization = new Serialization();
	
	public PhoneBook() {
		updateContactList();
	}
	
	public boolean insert(String name, String phoneNumber) {
		Contact contact = new Contact(name, phoneNumber);
		Contact contactExists = search(name);
		
		if(contactExists != null) {
			return false;
		} else {
			boolean addedContact = contacts.add(contact);
			sortList();
			return addedContact;
		}
	}
	
	public Contact search(String name) {
		for(Contact contact: contacts) {
			if(contact.getName().equals(name)) {
				return contact;
			}
		}
		return null;
	}

	
	public boolean delete(String name) {
		Contact contactFound = search(name);
		
		if(contactFound == null) {
			return false;
		} else {
			return contacts.remove(contactFound);
		}
	}
	
	public void sortList() {
		Collections.sort(contacts);
	}
	
	public int lenghtContacts() {
		return contacts.size();
	}
	
    public  ArrayList<Contact> deepCopyContacts() {
        ArrayList<Contact> copyContacts = new ArrayList<Contact>(contacts.size());

        for (Contact contact : contacts) {
        	copyContacts.add(contact);
        }
        return copyContacts;
    }
    
    
    public void updateContactList() {
        ArrayList<Contact> savedContacts = (ArrayList<Contact>) serialization.contactListLoading();
        contacts = savedContacts;
    }
}