package com.rajeshchinni;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);   // this is a static variable. all static methods can access it directly.
    private static MobilePhone mobilePhone = new MobilePhone("551 229 6851");  // this is a static variable. all static methods can access it directly.

    public static void main(String[] args) {

        // Create a program that implements a simple mobile phone with the following capabilities.
        // Able to store, modify, remove and query contact names.
        // You will want to create a separate class for Contacts (name and phone number).
        // Create a master class (MobilePhone) that holds the ArrayList of Contacts
        // The MobilePhone class has the functionality listed below.
        // Add a menu of options that are available.
        // Options:  Quit, print list of contacts, add new contact, update existing contact, remove contact
        // and search/find contact.
        // When adding or updating be sure to check if the contact already exists (use name)
        // Be sure not to expose the inner workings of the Arraylist to MobilePhone
        // e.g. no ints, no .get(i) etc
        // MobilePhone should do everything with Contact objects only.

        boolean quit = true;
        startPhone();
        printActions();
        while (quit) {
            System.out.println("\nEnter action: (6 to show available actions)");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("\nShutting down....");
                    quit = false;
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


    private static void startPhone() {
        System.out.println("Starting Phone.....");
    }



    private static void printActions() {
        System.out.println("\nAvailable actions: \npress");
        System.out.println("0 - to shutdown\n" +
                "1 - to print contacts\n" +
                "2 - to add a new contact\n " +
                "3 - to update an existing contact\n " +
                "4 - to remove a contact\n " +
                "5 - to search for a contact\n" +
                "6 - to print a list of available actions");
        System.out.println("Choose your action: ");
    }

    private static void addNewContact() {
        System.out.println("Enter new contact name");
        String name = scanner.nextLine();
        System.out.println("Enter Phone number");
        String pnumber = scanner.nextLine();
        Contacts new_peru_marayu_number = Contacts.createContact(name, pnumber); // we are able to do as we have used static in Contacts class for createContact method

        if (mobilePhone.addNewContact(new_peru_marayu_number)) {                 // Alternatively, mobilePhone.addNewContact(new_peru_marayu_number) == true
            System.out.println(" New contact added: name = " + name + ", phone = " + pnumber);
        } else {
            System.out.println("Cannot add " + name + " as it already exists");
        }
    }

    private static void updateContact() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contacts existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found");
            return;                                                      // https://www.geeksforgeeks.org/return-keyword-java/
        }
        System.out.println("Enter new contact name: ");
        String newName = scanner.nextLine();
        System.out.println("Enter new contact Phone number");
        String newNumber = scanner.nextLine();
        Contacts newContactrecord = Contacts.createContact(newName, newNumber);
        if (mobilePhone.updateContact(existingContactRecord, newContactrecord)) {  // alternatively, mobilePhone.updateContact(existingContactRecord, newContactrecord) == true
            System.out.println("Successfully updated record");
        } else {
            System.out.println("Error updating record. ");
        }

    }

    private static void removeContact() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contacts existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found");
            return;                                                            // https://www.geeksforgeeks.org/return-keyword-java/
        }
        if(mobilePhone.removeContact(existingContactRecord)){

            System.out.println("Successfully deleted");
        } else {
            System.out.println("Error deleting record");
        }
    }


    private static void queryContact() {
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        Contacts existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found");
            return;
        }
        System.out.println("Name: " + existingContactRecord.getName() + " phone number is " + existingContactRecord.getPhoneNumber());
    }

}
