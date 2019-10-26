package com.group9.viceright;

import android.graphics.Color;
import android.nfc.Tag;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.group9.viceright.model.IntakenSubstance;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.HashMap;
import java.util.List;

import static android.media.CamcorderProfile.get;

public class GraphActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        GlobalData globalData = (GlobalData)getApplication();
        GraphView graph = findViewById(R.id.graph);

        List<IntakenSubstance> substanceList = globalData.getDoseRecords();
        HashMap<String, Double> substanceMap = new HashMap();

        //summing substance usage
        for(int i =0; i < substanceList.size(); i++){
            IntakenSubstance substance = substanceList.get(i);
            Double priorSubstanceUse = substanceMap.get(substance.name);
            if(priorSubstanceUse != null){
                substanceMap.put(substance.name, priorSubstanceUse + substance.amount);
            }else{
                substanceMap.put(substance.name, substance.amount);
            }
        }

        //adding substance usage to graph
        int index = 0;
        for (String i : substanceMap.keySet()) {
            final BarGraphSeries<DataPoint> series = new BarGraphSeries<>(new DataPoint[] {
                    new DataPoint(index + 1, substanceMap.get(i))
            });

            graph.addSeries(series);
            series.setTitle(i);
            series.setValueDependentColor(new ValueDependentColor<DataPoint>() {
                @Override
                public int get(DataPoint data) {
                    series.setColor(Color.rgb((int) data.getX()*255/4, (int) Math.abs(data.getY()*255/6), 100));
                    return Color.rgb((int) data.getX()*255/4, (int) Math.abs(data.getY()*255/6), 100);
                }
            });
            series.setSpacing(50);
            index++;
        }

        //setting graphView boundaries
        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(0);
        graph.getViewport().setMaxX(index + 1);
        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setMinY(0);

        graph.getLegendRenderer().setVisible(true);
        graph.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
    }
}
