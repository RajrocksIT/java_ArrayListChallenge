package com.rajeshchinni;

import javax.naming.ldap.Control;
import java.util.ArrayList;

public class MobilePhone {

    private String myNumber;     // just listed for name sake. serves no purpose.
    private ArrayList<Contacts> myContacts;

//    public MobilePhone(String myNumber, ArrayList<Contacts> myContacts) {
//        this.myNumber = myNumber;
//        this.myContacts = myContacts;
//    }

    // constructor
    public MobilePhone(String myNumber) {   // parameter listed for name sake. serves no purpose.
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contacts>(); // this is manually done and it is an empty list
    }

    // method
    private int findContact(Contacts peru_marayu_number){
        return this.myContacts.indexOf(peru_marayu_number);
    }

    // below is method overloading
    private int findContact( String contactName){
        for (int i = 0; i < this.myContacts.size(); i++){
            Contacts peru_marayu_number = this.myContacts.get(i);
            if (peru_marayu_number.getName().equals(contactName)){       // https://www.geeksforgeeks.org/java-util-arrays-equals-java-examples/
                return i;                                                // https://howtodoinjava.com/java/collections/arraylist/compare-two-arraylists/
            }
        }
        return -1;
    }

    // method
    public boolean addNewContact(Contacts peru_marayu_number){

        if (findContact(peru_marayu_number.getName()) >= 0){
            System.out.println("Contact already exists");
            return false;
        }
        myContacts.add(peru_marayu_number);
        return true;
    }

    public boolean updateContact(Contacts old_peru_marayu_number, Contacts new_peru_marayu_number){
        int foundPosition = findContact(old_peru_marayu_number);
        if (foundPosition < 0){
            System.out.println(old_peru_marayu_number.getName() + " was not found");
            return false;
        }
        this.myContacts.set(foundPosition, new_peru_marayu_number);   // try to understand more about .set
        System.out.println(old_peru_marayu_number.getName() + " Was replaced with " + new_peru_marayu_number.getName());
        return true;
    }

    public boolean removeContact(Contacts peru_marayu_number){
        int foundPosition = findContact(peru_marayu_number);
        if (foundPosition < 0){
            System.out.println(peru_marayu_number.getName() + " was not found");
            return false;
        }
        this.myContacts.remove(foundPosition);
        System.out.println(peru_marayu_number.getName() + " ,was deleted");
        return true;
    }



//    public String queryContact(Contacts peru_marayu_number){
//        if (findContact(peru_marayu_number) >= 0){
//            return peru_marayu_number.getName();
//        }
//        return null;
//    }

    public Contacts queryContact(String name){   // return type is Contacts
        int position = findContact(name);
        if (position >= 0){
            return this.myContacts.get(position);
        }
        return null;
    }

    public void printContacts(){
        System.out.println("Contacts lists");
        for (int i = 0; i < this.myContacts.size(); i++){
            System.out.println((i+1) + "." + this.myContacts.get(i).getName() + " # " + this.myContacts.get(i).getPhoneNumber());
        }
    }

}

