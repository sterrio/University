package com.group9.viceright;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.firebase.firestore.CollectionReference;
import com.group9.viceright.model.IntakenSubstance;
import com.group9.viceright.model.Substance;
import com.group9.viceright.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrivateActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_private);
        GlobalData globalData = (GlobalData) getApplication();
        List<Substance> sList = globalData.getSubstances();
        ArrayList<String> names = new ArrayList<>();
        for(Substance s : sList){
            names.add(s.name);
        }

        //populate listview with private list
        ListView list = findViewById(R.id.privateList);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                names);
        list.setAdapter(arrayAdapter);


        //select item from your private list
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selected = (String) parent.getItemAtPosition(position);
                Intent intent = new Intent(PrivateActivity.this, ViceDetail.class);
                intent.putExtra("Selected", selected);
                startActivity(intent);
            }
        });


    }
}
