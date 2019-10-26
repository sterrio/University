package com.group9.viceright;


import com.group9.viceright.model.IntakenSubstance;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TimeframeQuery {

    public static List<IntakenSubstance> queryAmountTaken(String timeframe, IntakenSubstance[] intakenSubstances) {
        List<IntakenSubstance> filteredIntakenSubstances = new ArrayList<IntakenSubstance>();

        Calendar calendar = Calendar.getInstance();
        Date afterDate;

        // Filter by specific timeframe
        switch(timeframe){
            case "Weekly":
                calendar.add(Calendar.DATE, -7);
                afterDate = calendar.getTime();
                break;
            case "Daily":
                calendar.add(Calendar.DATE, -1);
                afterDate = calendar.getTime();
                break;
            case "Monthly":
                calendar.add(Calendar.DATE, -30);
                afterDate = calendar.getTime();
                break;
            case "Yearly":
                calendar.add(Calendar.DATE, -365);
                afterDate = calendar.getTime();
                break;
            default:
                // TODO: Use a better solution
                calendar.add(Calendar.DATE, -1000000);
                afterDate = calendar.getTime();
                break;
        }

        for (int i = 0; i < intakenSubstances.length; i++) {

            if (intakenSubstances[i].date.after(afterDate)) filteredIntakenSubstances.add(intakenSubstances[i]);
        }

        return filteredIntakenSubstances;
    }

    public static String query(String timeframe, IntakenSubstance[] intakenSubstances){
        List<IntakenSubstance> filteredIntakenSubstances = queryAmountTaken(timeframe, intakenSubstances);

        String endSentence;

        switch(timeframe){
            case "Weekly":
                endSentence = "week.";
                break;
            case "Daily":
                endSentence = "day.";
                break;
            case "Monthly":
                endSentence = "month.";
                break;
            case "Yearly":
                endSentence = "year.";
                break;
            default:
                // TODO: Use a better solution
                endSentence = ".";
                break;
        }


        // Handle the case with no data
        if (filteredIntakenSubstances.size() == 0) {
            return "You have not taken any substances for the selected time period.";
        }


        int totalTaken = 0;
        for (int i = 0; i < filteredIntakenSubstances.size(); i++) {
            totalTaken += filteredIntakenSubstances.get(i).amount;
        }

        return "You've taken " + totalTaken + "g of " + filteredIntakenSubstances.get(0).name + " in the past " + endSentence;
    }
}
