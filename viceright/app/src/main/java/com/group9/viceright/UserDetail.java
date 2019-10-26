package com.group9.viceright;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.group9.viceright.model.IntakenSubstance;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class UserDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        FirebaseAuth authentication;
        FirebaseFirestore database;

        authentication = FirebaseAuth.getInstance();
        final FirebaseUser user = authentication.getCurrentUser();
        database = FirebaseFirestore.getInstance();
        GlobalData globalData = (GlobalData)getApplication();

        String[] arr = {"vice", "Alcohol"};
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        List<IntakenSubstance> doseRecords = globalData.getDoseRecords();


        TableLayout list = findViewById(R.id.table);
        TextView usernameTV = findViewById(R.id.userName);
        TextView emailTV = findViewById(R.id.emailAddress);
        Button signOutBtn = findViewById(R.id.signOutButton);

        String name = globalData.getUserData().fname + ", " + globalData.getUserData().lname;
        usernameTV.setText(name);
        emailTV.setText(user.getEmail());
        // For
        for (int row = 0; row < Math.min(4, globalData.getDoseRecords().size()); row++) {

            TableRow tr = new TableRow(this);
            tr.setId(100 + row);
            if (row % 2 != 0) {
                tr.setBackgroundColor(Color.parseColor("#ecf0f1"));
            }
            tr.setMinimumHeight(110);
            tr.setGravity(Gravity.CENTER_VERTICAL);
            tr.setPadding(42,0,0,0);

            TableLayout.LayoutParams params = new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT, 1f);

            TextView rowTitle = new TextView(this);
            TextView rowDate = new TextView(this);
            rowDate.setText(dateFormat.format(doseRecords.get(row).date));
            TextView rowAmount = new TextView(this);
            rowAmount.setText(doseRecords.get(row).amount + "g");

            rowAmount.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

            rowTitle.setTextSize(20);
            rowTitle.setText(doseRecords.get(row).name);

            TableRow.LayoutParams textParams = new TableRow.LayoutParams();
            rowTitle.setLayoutParams(textParams);

            tr.addView(rowTitle);
            tr.addView(rowDate);
            tr.addView(rowAmount);

          //textParams.gravity = Gravity.CENTER;
            tr.setLayoutParams(params);
            list.addView(tr, params);
        }
        list.setStretchAllColumns(true);

        signOutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                authentication.signOut();
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }

    //This method is combined with button Main to go back to main page.
    public void gotoMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    //This method is combined with button Main to go back to consumptionHistory page.
    public void gotoHistory(View view){
        Intent intent = new Intent(this, ConsumptionHistory.class);
        startActivity(intent);
    }

    public void gotoAdd (View view){
        Intent intent = new Intent (this, AddActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onRestart(){
        super.onRestart();

        final Intent i = new Intent(this, UserDetail.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);

    }
}

