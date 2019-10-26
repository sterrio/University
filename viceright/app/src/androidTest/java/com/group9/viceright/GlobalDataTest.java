package com.group9.viceright;

import android.widget.PopupWindow;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.group9.viceright.model.IntakenSubstance;
import com.group9.viceright.model.Substance;
import com.group9.viceright.model.User;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class GlobalDataTest {

    @Test
    public void retrieveData() {

        FirebaseAuth authentication;
        FirebaseFirestore database;

        PopupWindow popupWindow = new PopupWindow();
        authentication = FirebaseAuth.getInstance();
        database = FirebaseFirestore.getInstance();
        GlobalData globalData = new GlobalData();
        globalData.retrieveData(authentication, database, popupWindow);

    }

    @Test
    public void getUserData() {

        final FirebaseAuth authentication;
        final FirebaseFirestore database;

        String email = "testing-user@test.com";
        String password ="password";

        final String fname = "Testing";
        final String lname = "User";
        final String age = "10 - 20";

        PopupWindow popupWindow = new PopupWindow();

        authentication = FirebaseAuth.getInstance();
        database = FirebaseFirestore.getInstance();
        authentication.signInWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {

                GlobalData globalData = new GlobalData();
                globalData.retrieveData(authentication, database, popupWindow);

                User user = globalData.getUserData();

                String fields = user.fname + "" + user.lname + "" + user.age;
                assertEquals(fname + "" + lname + "" + age, fields);

            }
        });

    }

    @Test
    public void getSubstances() {

        final FirebaseAuth authentication;
        final FirebaseFirestore database;

        String email = "testing-user@test.com";
        String password ="password";
        PopupWindow popupWindow = new PopupWindow();

        authentication = FirebaseAuth.getInstance();
        database = FirebaseFirestore.getInstance();
        authentication.signInWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {

                String testString = "AlcoholAlcoholCannabisCannabisParacetemolParacetemolTestSubstanceTestSubstance";
                String firebaseData = "";

                List<Substance> substances;

                GlobalData globalData = new GlobalData();
                globalData.retrieveData(authentication, database, popupWindow);

                 substances = globalData.getSubstances();

                 for(int i = 0; i < substances.size(); i++){

                     Substance substance = substances.get(i);
                     firebaseData += substance.name + substance.description;

                 }

                 assertEquals(testString, firebaseData);

            }
        });

    }

    @Test
    public void getDoseRecords() {

        final FirebaseAuth authentication;
        final FirebaseFirestore database;

        String email = "testing-user@test.com";
        String password ="password";

        final String name = "TestSubstance";
        final String description = "TestSubstance";
        final String dose = "1";
        PopupWindow popupWindow = new PopupWindow();

        authentication = FirebaseAuth.getInstance();
        database = FirebaseFirestore.getInstance();
        authentication.signInWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {

                String firebaseData = "";

                List<IntakenSubstance> records;

                GlobalData globalData = new GlobalData();
                globalData.retrieveData(authentication, database, popupWindow);

                records = globalData.getDoseRecords();

                for(int i = 0; i < records.size(); i++){

                    IntakenSubstance intakenSubstance = records.get(i);
                    firebaseData += intakenSubstance.name + intakenSubstance.description;

                }

                assertEquals(name + description + dose, firebaseData);

            }
        });

    }
}