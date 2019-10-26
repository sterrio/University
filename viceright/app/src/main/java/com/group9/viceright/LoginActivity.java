package com.group9.viceright;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class LoginActivity extends AppCompatActivity {

    FirebaseAuth authentication;
    FirebaseFirestore database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //initializing view elements
        final EditText emailEditText = findViewById(R.id.emailEditText);
        final EditText passEditText = findViewById(R.id.passwordEditText);
        Button loginButton = findViewById(R.id.loginButton);
        TextView newAccountTextView = findViewById(R.id.createAccountTextView);

        //initializing firebase objects
        authentication = FirebaseAuth.getInstance();
        database = FirebaseFirestore.getInstance();

        //making login request when submit button is pressed
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //retrieving login data from fields
                String email = emailEditText.getText().toString();
                String password = passEditText.getText().toString();

                if(email.equals("") || password.equals("")){
                //email & password not filled

                    Toast.makeText(getApplicationContext(), "Email and/or password are empty!",
                            Toast.LENGTH_LONG).show();

                }else{
                //email & password are filled

                    //attempting login
                    authentication.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    //verifying login
                                    if(task.isSuccessful()){

                                        Log.d("Sign in", "signInWithEmail:success");

                                        //directing user to main page
                                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                        startActivity(intent);
                                        finish();

                                    }else{

                                        Log.d("Sign in", "signInWithEmail:failure", task.getException());
                                        Toast.makeText(LoginActivity.this, "Authentication failed.",
                                                Toast.LENGTH_SHORT).show();

                                    }
                                }
                            });
                }

            }
        });

        //directing user to create account page
        newAccountTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), CreateAccountActivity.class);
                startActivity(intent);

            }
        });

    }
}
