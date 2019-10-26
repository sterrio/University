package com.group9.viceright.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {

    //need to be public to create account
    public String fname;
    public String lname;
    public String age;

    public User(){

    }

    public User(String fname, String lname, String age){
        this.fname = fname;
        this.lname = lname;
        this.age = age;
    }

}
