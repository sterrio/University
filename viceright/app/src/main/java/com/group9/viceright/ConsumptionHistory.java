package com.group9.viceright;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import com.group9.viceright.model.IntakenSubstance;
import com.group9.viceright.model.Substance;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

public class ConsumptionHistory extends AppCompatActivity {
    private Spinner timeframe;
    private Spinner substanceType;
    private TextView substanceHistory;
    private TextView warning;
    private Button graphButton;

    FirebaseFirestore database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consumption_history);

        //Initializing Firebase
        database = FirebaseFirestore.getInstance();

        substanceHistory = findViewById(R.id.substanceHistory);
        substanceType = findViewById(R.id.substanceType);
        timeframe = findViewById(R.id.timeFrame);
        warning = findViewById(R.id.warning);
        graphButton = findViewById(R.id.graphButton);

        substanceType.setOnItemSelectedListener(new ItemSelectedListener());
        timeframe.setOnItemSelectedListener(new ItemSelectedListener());

        GlobalData globalData = (GlobalData)getApplication();
        List<Substance> substanceList = globalData.getSubstances();

        String[] items = new String[substanceList.size()];
        for (int i = 0; i < substanceList.size(); i++) {
            items[i] = substanceList.get(i).name;
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        substanceType.setAdapter(adapter);

        graphButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(), GraphActivity.class);
                startActivity(i);

            }
        });

    }

    //This method is combined with button Main to go back to userDetail page.
    public void userDetail(View view) {
        Intent intent = new Intent(this, UserDetail.class);
        startActivity(intent);
    }

    //This method is combining the columns with the drop down tool bar.
    public class ItemSelectedListener implements AdapterView.OnItemSelectedListener {

        //get strings of first item
        String firstItem = String.valueOf(substanceType.getSelectedItem());

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            warning.setText("");
            substanceHistory.setText("");

            if (firstItem.equals(String.valueOf(substanceType.getSelectedItem()))) {
                substanceHistory.setText("Please select a substance");
            } else {
                GlobalData globalData = (GlobalData)getApplication();

                IntakenSubstance[] intakenArray = new IntakenSubstance[globalData.getDoseRecords().size()];
                for (int i = 0; i < globalData.getDoseRecords().size(); i++) {
                    intakenArray[i] = globalData.getDoseRecords().get(i);
                }

                List<IntakenSubstance> intakenSubstances = TimeframeQuery.queryAmountTaken(String.valueOf(timeframe.getSelectedItem()), intakenArray);

                List<IntakenSubstance> intakenSubstances2 = new ArrayList<IntakenSubstance>();
                for (int i = 0; i < intakenSubstances.size(); i++) {
                    if (intakenSubstances.get(i).name.equals(String.valueOf(substanceType.getSelectedItem()))) {
                        intakenSubstances2.add(intakenSubstances.get(i));
                        intakenSubstances.remove(intakenSubstances.get(i));
                    }
                }

                int totalTaken = 0;
                for (int i = 0; i < intakenSubstances2.size(); i++) {
                    totalTaken += intakenSubstances2.get(i).amount;
                }

                String result = "Your " + String.valueOf(timeframe.getSelectedItem()).toLowerCase() +
                        " consumption of " + String.valueOf(substanceType.getSelectedItem()).toLowerCase() + " is " + totalTaken;
                substanceHistory.setText(result);
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }

    }
}
