package com.group9.viceright;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.group9.viceright.model.User;
import com.group9.viceright.spinnerLists.AgeSpinnerList;

public class CreateAccountActivity extends AppCompatActivity {

    FirebaseAuth authentication;
    FirebaseFirestore database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        //list of age ranges for ageSpinner
        AgeSpinnerList ageSpinnerList = new AgeSpinnerList();

        //initializing view elements
        final EditText fnameEditText = findViewById(R.id.fnameEditText);
        final EditText lnameEditText = findViewById(R.id.lnameEditText);
        final EditText emailEditText = findViewById(R.id.emailEditText);
        final EditText passwordEditText = findViewById(R.id.passwordEditText);
        final EditText passConfEditText = findViewById(R.id.passConfEditText);
        final Spinner ageSpinner = findViewById(R.id.ageSpinner);;
        Button createAccountButton = findViewById(R.id.createAccountButton);

        //creating adapter for ageSpinner and populating
        ArrayAdapter<String> ageAdapter = new ArrayAdapter<>(this,
                R.layout.support_simple_spinner_dropdown_item, ageSpinnerList.getAgeList());
        ageAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        ageSpinner.setAdapter(ageAdapter);

        //initializing firebase objects
        authentication = FirebaseAuth.getInstance();
        database = FirebaseFirestore.getInstance();

        //making account creation request when submit button is pressed
        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //retrieving user data from fields
                final String fname = fnameEditText.getText().toString();
                final String lname = lnameEditText.getText().toString();
                final String age = ageSpinner.getSelectedItem().toString();
                final String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                String passConf = passConfEditText.getText().toString();

                //checking if all fields have been filled
                if(fname.equals("") ||
                    lname.equals("") ||
                    email.equals("") ||
                    password.equals("") ||
                    passConf.equals("")) {
                    //fields have not been filled

                    Toast.makeText(getApplicationContext(), "Make sure to fill in each field!",
                            Toast.LENGTH_LONG).show();

                }else{
                //fields all filled

                    if(password.equals(passConf)){
                    //password confirmation is correct

                        //attempting user creation
                        authentication.createUserWithEmailAndPassword(email, password)
                                .addOnCompleteListener(CreateAccountActivity.this, new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {

                                        //verifying account was created
                                        if(task.isSuccessful()){

                                            Log.d("Create Account", "createUserWithEmail:success");

                                            //creating document for supplemental user data
                                            //document id is set to the user's uid
                                            User user = new User(fname, lname, age);
                                            DocumentReference ref = database
                                                    .collection("Users")
                                                    .document(authentication.getUid());
                                            ref.set(user);

                                            //directing user to main page
                                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                            startActivity(intent);

                                        }else{

                                            Log.d("Create Account", "createUserWithEmail:failure", task.getException());
                                            Toast.makeText(CreateAccountActivity.this, "Account creation failed.",
                                                    Toast.LENGTH_SHORT).show();

                                        }
                                    }
                                });
                    }else{
                    //password confirmation is not correct
                        Toast.makeText(getApplicationContext(), "Passwords do not match!",
                                Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
