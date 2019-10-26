package com.group9.viceright;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import com.group9.viceright.model.IntakenSubstance;
import com.group9.viceright.model.Substance;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ViceDetail extends AppCompatActivity {
    private CheckBox govHidden;
    private boolean checked = false;
    private Substance vice;
    private List<Substance> substances = GlobalData.getSubstances();
    FirebaseFirestore database;
    FirebaseAuth authentication;
    FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        authentication = FirebaseAuth.getInstance();
        database = FirebaseFirestore.getInstance();
        firebaseUser = authentication.getCurrentUser();

        setContentView(R.layout.activity_vice_detail);
        govHidden = findViewById(R.id.CityHidden);
        TextView viceHeader = findViewById(R.id.viceHeader);
        TextView description = findViewById(R.id.substanceDescription);
        String s = getIntent().getStringExtra("Selected");
        vice = Substance.poll(substances, s);
        viceHeader.setText(vice.name);
        description.setText(vice.description);
        govHidden.setOnClickListener((v)->{
            if(checked){
                checked = false;
            }
            else{
                checked = true;
            }
        });

    }

    public void gotoDetail (View view){
        finish();
    }

    public void onCheckboxClicked(View view){
        if(checked){
            Log.d("Works", "Works");
        }
        else{
            GlobalData globalData = (GlobalData)getApplication();
            Boolean bool = Boolean.TRUE;
            vice.govHidden = bool;
            CollectionReference ref = database.collection("Users")
                    .document(firebaseUser.getUid()).collection("Intaken");
            IntakenSubstance substance = new IntakenSubstance(vice, new Date(), 1);
            ref.add(substance);
            globalData.addLocalDoseRecord(substance);
        }
        finish();
    }
}
