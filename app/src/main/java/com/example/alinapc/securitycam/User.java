package com.example.alinapc.securitycam;

/**
 * Created by AlinaPc on 12.06.2015.
 */
public class User {
    String fname, surname, username, pass, retype;
    int age;

    public User(String fname, String surname, int age, String username, String pass, String retype){
        this.fname = fname;
        this.surname = surname;
        this.age = age;
        this.username = username;
        this.pass = pass;
        this.retype = retype;

    }


    public User(String username, String pass, String retype){
        this.username = username;
        this.pass = pass;
        this.retype = retype;
        age = -1;
        fname = "";
        surname = "";

    }
}
