package com.group9.viceright;

import android.support.test.runner.AndroidJUnit4;

import com.group9.viceright.model.IntakenSubstance;
import com.group9.viceright.model.Substance;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class ConsumptionHistoryTest {

    @Test
    public void FilterByDay(){
        IntakenSubstance[] intakenSubtances = new IntakenSubstance[3];
        GregorianCalendar dayBeforeThisWeek = new GregorianCalendar();
        int dayFromMonday = (dayBeforeThisWeek.get(Calendar.DAY_OF_MONTH) + 7 - Calendar.MONDAY) % 7;
        dayBeforeThisWeek.add(Calendar.DATE, -dayFromMonday-1);

        Substance alcohol = new Substance("Alcohol", "A drink", Double.parseDouble("20"), false, "");
        Substance coffee = new Substance("Coffee", "Another drink", Double.parseDouble("200"), false, "");
        Substance cannabis = new Substance("Cannabis", "Not a drink", Double.parseDouble("200"), false, "");

        IntakenSubstance intakenAlcohol = new IntakenSubstance(alcohol, Date.from(Instant.now()), 2);
        IntakenSubstance intakenCoffee = new IntakenSubstance(coffee, Date.from(Instant.now()), 20);
        IntakenSubstance intakenCannabis = new IntakenSubstance(cannabis, dayBeforeThisWeek.getTime(), 10);

        intakenSubtances[0] = intakenAlcohol;
        intakenSubtances[1] = intakenCoffee;
        intakenSubtances[2] = intakenCannabis;

        String dayPattern = ".*day\\.";
        assertEquals(true, TimeframeQuery.query("Daily", intakenSubtances).matches(dayPattern));

    }

    @Test
    public void FilterByWeek(){
        IntakenSubstance[] intakenSubtances = new IntakenSubstance[3];
        GregorianCalendar dayBeforeThisWeek = new GregorianCalendar();
        int dayFromMonday = (dayBeforeThisWeek.get(Calendar.DAY_OF_MONTH) + 7 - Calendar.MONDAY) % 7;
        dayBeforeThisWeek.add(Calendar.DATE, -dayFromMonday-1);

        Substance alcohol = new Substance("Alcohol", "A drink", Double.parseDouble("20"), false, "");
        Substance coffee = new Substance("Coffee", "Another drink", Double.parseDouble("200"), false, "");
        Substance cannabis = new Substance("Cannabis", "Not a drink", Double.parseDouble("200"), false, "");

        IntakenSubstance intakenAlcohol = new IntakenSubstance(alcohol, Date.from(Instant.now()), 2);
        IntakenSubstance intakenCoffee = new IntakenSubstance(coffee, Date.from(Instant.now()), 20);
        IntakenSubstance intakenCannabis = new IntakenSubstance(cannabis, dayBeforeThisWeek.getTime(), 10);

        intakenSubtances[0] = intakenAlcohol;
        intakenSubtances[1] = intakenCoffee;
        intakenSubtances[2] = intakenCannabis;

        String weekPattern = ".*week\\.";
        assertEquals(true, TimeframeQuery.query("Weekly", intakenSubtances).matches(weekPattern));
    }

    @Test
    public void FilterByMonth() {
        IntakenSubstance[] intakenSubtances = new IntakenSubstance[3];

        GregorianCalendar dayBeforeThisWeek = new GregorianCalendar();
        int dayFromMonday = (dayBeforeThisWeek.get(Calendar.DAY_OF_WEEK) + 7 - Calendar.MONDAY) % 7;
        dayBeforeThisWeek.add(Calendar.DATE, -dayFromMonday-1);

        Substance alcohol = new Substance("Alcohol", "A drink", Double.parseDouble("20"), false, "");
        Substance coffee = new Substance("Coffee", "Another drink", Double.parseDouble("200"), false, "");
        Substance cannabis = new Substance("Cannabis", "Not a drink", Double.parseDouble("200"), false, "");

        IntakenSubstance intakenAlcohol = new IntakenSubstance(alcohol, Date.from(Instant.now()), 2);
        IntakenSubstance intakenCoffee = new IntakenSubstance(coffee, Date.from(Instant.now()), 20);
        IntakenSubstance intakenCannabis = new IntakenSubstance(cannabis, dayBeforeThisWeek.getTime(), 10);

        intakenSubtances[0] = intakenAlcohol;
        intakenSubtances[1] = intakenCoffee;
        intakenSubtances[2] = intakenCannabis;

        String monthPattern = ".*month\\.";

        assertEquals(true, TimeframeQuery.query("Monthly", intakenSubtances).matches(monthPattern));
    }

    @Test
    public void FilterByYear(){
        IntakenSubstance[] intakenSubtances = new IntakenSubstance[3];
        GregorianCalendar dayBeforeThisWeek = new GregorianCalendar();
        int dayFromMonday = (dayBeforeThisWeek.get(Calendar.DAY_OF_MONTH) + 7 - Calendar.MONDAY) % 7;
        dayBeforeThisWeek.add(Calendar.DATE, -dayFromMonday-1);

        Substance alcohol = new Substance("Alcohol", "A drink", Double.parseDouble("20"), false, "");
        Substance coffee = new Substance("Coffee", "Another drink", Double.parseDouble("200"), false, "");
        Substance cannabis = new Substance("Cannabis", "Not a drink", Double.parseDouble("200"), false, "");

        IntakenSubstance intakenAlcohol = new IntakenSubstance(alcohol, Date.from(Instant.now()), 2);
        IntakenSubstance intakenCoffee = new IntakenSubstance(coffee, Date.from(Instant.now()), 20);
        IntakenSubstance intakenCannabis = new IntakenSubstance(cannabis, dayBeforeThisWeek.getTime(), 10);

        intakenSubtances[0] = intakenAlcohol;
        intakenSubtances[1] = intakenCoffee;
        intakenSubtances[2] = intakenCannabis;

        String yearPattern = ".*year\\.";
        assertEquals(true, TimeframeQuery.query("Yearly", intakenSubtances).matches(yearPattern));
    }

    @Test
    public void FilterWithNoData() {
        IntakenSubstance[] intakenSubtances = new IntakenSubstance[0];
        String emptyPattern = "You have not taken any substances for the selected time period.";
        assertEquals(true, TimeframeQuery.query("You have not taken any substances for the selected time period.", intakenSubtances).matches(emptyPattern));
    }
}
