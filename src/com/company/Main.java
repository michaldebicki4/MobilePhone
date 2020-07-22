package com.company;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("796 098 079");

    public static void main(String[] args) {
        boolean quit = false;
        startPhone();
        printActions();
        while (!quit) {
            System.out.println("Enter action: (6 to show available actions");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    System.out.println("Quit.");
                    quit = true;
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;

                case 6:
                    printActions();
                    break;
            }
        }
    }

    public static void printActions() {
        System.out.println("0: Shut down");
        System.out.println("1: Print of the list contacts.");
        System.out.println("2: Add contact.");
        System.out.println("3. Update existing contact.");
        System.out.println("4: Remove existing Contact.");
        System.out.println("5: Query if existing contact exist.");
        System.out.println("6: Print a list of available actions.");

    }

    private static void startPhone() {
        System.out.println("Starting Phone...");
    }

    private static void printContacts() {
        mobilePhone.printContacts();
    }

    private static void addNewContact() {
        System.out.println("Enter your contact name: ");
        String name = scanner.nextLine();
        System.out.println("Enter phone number: ");
        String phone = scanner.nextLine();
        Contacts newContact = Contacts.createContact(name, phone);
        if (mobilePhone.addContact(newContact)) {
            System.out.println("New contact added: name = " + name + ", phone = " + phone);
        } else {
            System.out.println("Cannot add, " + name + " already on file");
        }
    }

    private static void updateContact() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contacts existingCOntactRecord = mobilePhone.queryContacts(name);
        if (existingCOntactRecord == null) {
            System.out.println("Contact not found");
            return;
        }
        System.out.println("Enter new contact name: ");
        String newName = scanner.nextLine();
        System.out.println("Enter new contact phone number");
        String newNumber = scanner.nextLine();
        Contacts newContact = Contacts.createContact(newName, newNumber);
        if (mobilePhone.updateContact(existingCOntactRecord, newContact)) {
            System.out.println("Succesfully updated record");
        } else {
            System.out.println("Error updating record");
        }
    }

    private static void removeContact() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contacts existingCOntactRecord = mobilePhone.queryContacts(name);
        if (existingCOntactRecord == null) {
            System.out.println("Contact not found");
            return;
        }
        if (mobilePhone.removeContact(existingCOntactRecord)) {
            System.out.println("Succesfully deleated");
        } else {
            System.out.println("Error");
        }
    }
    private static void queryContact() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contacts existingCOntactRecord = mobilePhone.queryContacts(name);
        if (existingCOntactRecord == null) {
            System.out.println("Contact not found");
            return;
        }

            System.out.println("Name: " + existingCOntactRecord.getName() + " phone number is " + existingCOntactRecord.getNumber());

    }
}
