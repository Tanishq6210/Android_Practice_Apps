package com.example.recycler_view_contacts;

public class Contact {
    private int sno;
    private String phoneNumber;
    private String name;

    public Contact(int sno, String phoneNumber, String name) {
        this.sno = sno;
        this.phoneNumber = phoneNumber;
        this.name = name;
    }

    public int getSno() {
        return sno;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }
}
