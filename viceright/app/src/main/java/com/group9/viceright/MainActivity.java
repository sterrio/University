package com.group9.viceright;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.group9.viceright.model.User;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth authentication;
    FirebaseFirestore database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //getting authentication
        authentication = FirebaseAuth.getInstance();

        //getting current user
        final FirebaseUser user = authentication.getCurrentUser();
        if(user == null){
        //no user logged in

            Toast.makeText(getApplicationContext(), "Not logged in!",
                    Toast.LENGTH_LONG).show();

            //directing user to login page
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);

        }else{
        //user logged in

            database = FirebaseFirestore.getInstance();
            final GlobalData globalData = (GlobalData)getApplication();

            setContentView(R.layout.activity_main);
            LayoutInflater layoutInflater  = (LayoutInflater)getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
            View popupView =layoutInflater.inflate(R.layout.popup, null);
            final PopupWindow popupWindow = new PopupWindow(popupView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

            findViewById(R.id.constraintLayout).post(new Runnable() {
                public void run() {
                    popupWindow.showAtLocation(findViewById(R.id.constraintLayout), Gravity.CENTER, 0, 0);
                }
            });

            globalData.retrieveData(authentication, database, popupWindow);
        }
    }
    //This method is combined with button Main to go to userDetail page.
    public void userDetail(View view){
        Intent intent = new Intent(this, UserDetail.class);
        startActivity(intent);
    }
}
