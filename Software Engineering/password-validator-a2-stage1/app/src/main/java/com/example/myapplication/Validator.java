package com.example.myapplication;


public class Validator {
    public static int validate (String pass) {

        int counter = 0;
        if (pass.toLowerCase() == "password") counter++;
        if (pass.length() > 8) counter++;

        return counter;
    }
}