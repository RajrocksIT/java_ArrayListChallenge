package com.rajeshchinni;

public class Contacts {

    private String name;
    private String PhoneNumber;

    // constructor
    public Contacts(String name, String phoneNumber) {
        this.name = name;
        PhoneNumber = phoneNumber;
    }

    // getter
    public String getName() {
        return name;
    }

    // getter
    public String getPhoneNumber() {
        return PhoneNumber;
    }

    // static is important thing below
    public static Contacts createContact(String name, String phoneNumber){  // return type is Contacts
        return new Contacts(name, phoneNumber);
    }
}
