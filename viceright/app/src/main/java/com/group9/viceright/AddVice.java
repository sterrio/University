package com.group9.viceright;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.group9.viceright.model.Substance;

import org.w3c.dom.Text;

public class AddVice extends AppCompatActivity {
    FirebaseAuth authentication;
    FirebaseFirestore database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vice);

        authentication = FirebaseAuth.getInstance();
        final FirebaseUser user = authentication.getCurrentUser();
        database = FirebaseFirestore.getInstance();
        final GlobalData globalData = (GlobalData)getApplication();

        // Text field id's to use
        final EditText viceName = findViewById(R.id.viceName);
        final EditText viceDesc = findViewById(R.id.viceDesc);
        final EditText maxWarning = findViewById(R.id.maxWarning);
        Button finishButton = findViewById(R.id.finishButton);

        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               String name =  viceName.getText().toString();
               String desc = viceDesc.getText().toString();
               double max = Double.parseDouble(maxWarning.getText().toString());

               if (name.length() == 0 || desc.length() == 0){

                   Toast.makeText(AddVice.this,"Invalid field, Add both a Name & Description",Toast.LENGTH_SHORT).show();

               }else {

                   // Use the hidden boolean here to change whether the city can see the substance or not.
                   Substance vice = new Substance(name, desc, max, true, "ImageURL");

                   DocumentReference ref = database.collection("Users")
                           .document(user.getUid()).collection("Substances").document();
                   ref.set(vice);
                   globalData.addLocalSubstance(vice);
                   finish();

               }
            }
        });

    }

}
