package com.group9.viceright;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.group9.viceright.model.Substance;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class AddActivity extends AppCompatActivity {

    FirebaseAuth authentication;
    FirebaseFirestore database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        authentication = FirebaseAuth.getInstance();
        database = FirebaseFirestore.getInstance();
        FirebaseUser fbUser = authentication.getCurrentUser();

        GlobalData globalData = (GlobalData)getApplication();
        final List<Substance> substanceList = globalData.getSubstances();

        //populating view with available substances

        for(int row = 0; row < substanceList.size(); row++){

            if(substanceList.get(row).govHidden != null &&
                    substanceList.get(row).govHidden.booleanValue()){ continue;}

            TableLayout list = findViewById(R.id.substanceList);
            final TableRow tr = new TableRow(AddActivity.this);
            TextView rowTitle = new TextView(AddActivity.this);

            tr.setId(100 + row);
            tr.setMinimumHeight(120);
            if (row % 2 != 0) tr.setBackgroundColor(Color.parseColor("#ecf0f1"));
            tr.setGravity(Gravity.CENTER);



            rowTitle.setPadding(15, 0, 0,0);
            rowTitle.setTextSize(16);
            rowTitle.setText(substanceList.get(row).name);

            tr.addView(rowTitle);
            list.addView(tr);
            list.setStretchAllColumns(true);

            tr.setOnClickListener((v)->{
                String substance = rowTitle.getText().toString();
                Intent intent = new Intent(this, ViceDetail.class);
                intent.putExtra("Selected", substance);
                startActivity(intent);
            });

        }

    }

    @Override
    protected void onRestart(){
        super.onRestart();

        final Intent i = new Intent(this, AddActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);

    }

    public void gotoVice (View view){
        Intent intent = new Intent (this,AddVice.class);
        startActivity(intent);
    }

    public void gotoPrivate (View view){
        Intent intent = new Intent (this,PrivateActivity.class);
        startActivity(intent);
    }
}
