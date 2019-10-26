package com.group9.viceright;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewAction;
import android.widget.CheckBox;

import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.isChecked;
import static android.support.test.espresso.matcher.ViewMatchers.isNotChecked;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class ViceDetailTest {
    @Test
    public void checkbox() {
        onView(withId(R.id.CityHidden)).perform((ViewAction) isChecked());
        onView(withId(R.id.CityHidden)).perform((ViewAction) isNotChecked());
    }
}