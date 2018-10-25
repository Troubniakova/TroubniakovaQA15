package com.telRan.addressbok.model;

public class Contact {
    private  String firstName;
    private  String lastName;
    private  String adress;
    private  String mobile;
    private  String email;


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAdress() {
        return adress;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public Contact setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Contact setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Contact setAdress(String adress) {
        this.adress = adress;
        return this;
    }

    public Contact setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public Contact setEmail(String email) {
        this.email = email;
        return this;
    }



}
