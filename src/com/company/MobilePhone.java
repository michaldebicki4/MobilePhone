package com.company;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contacts> myContacts;



    public MobilePhone(String myNumber){
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contacts>();
    }

    public boolean addContact(Contacts contact){
        if(findContact(contact.getName()) >= 0){
            System.out.println("Contact is already in file");
            return false;
        }

        myContacts.add(contact);
        return true;
    }
    public boolean updateContact(Contacts oldContact, Contacts newContact){
        int foundPosition = findContact(oldContact);
        if(foundPosition < 0){
            System.out.println(oldContact.getName() + ", was not found.");
            return false;
        } else if(findContact(newContact.getName()) != -1) {
            System.out.println("Contact with name " + newContact.getName() + " already exist. Update was not successful.");
            return false;

        }
        this.myContacts.set(foundPosition, newContact);
        System.out.println(oldContact.getName() + ", was repleaced with " + newContact.getName());
        return true;
    }

    private  int findContact(Contacts contact){
        return this.myContacts.indexOf(contact);
    }
    private int findContact(String contactName){
        for(int i = 0; i<this.myContacts.size(); i++){
            Contacts contact = this.myContacts.get(i);
            if(contact.getName().equals(contactName)){
                return i;
            }
        }
        return -1;
    }
    private String queryContact(Contacts contact){
        if(findContact(contact) >= 0){
            return contact.getName();
        }
        return null;
    }
    public boolean removeContact(Contacts contact){
        int foundPosition = findContact(contact);
        if(foundPosition < 0){
            System.out.println(contact.getName() + ", was not found.");
            return false;
        }
        this.myContacts.remove(foundPosition);
        System.out.println(contact.getName() + "was deleated ");
        return true;
    }
    public void printContacts(){
        System.out.println("Contact List");
        for(int i = 0; i<this.myContacts.size(); i++){
            System.out.println((i +1) + "." + this.myContacts.get(i).getName() + " -> " + this.myContacts.get(i).getNumber());
        }
    }
    public Contacts queryContacts(String name){
        int position = findContact(name);
        if(position>= 0) {
            return this.myContacts.get(position);
        }
        return  null;
    }



}
