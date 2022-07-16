package com.example.waterdelivery;

public class User {

    public String userName;
    public  String email;
    public String userPassword;
    public  String phoneNo;

    public User() {

    }

    public User ( String userName, String email, String userPassword, String mobileNo) {
        this.userName = userName;
        this.email = email;
        this.userPassword = userPassword;
        this.phoneNo = mobileNo;

    }
}
