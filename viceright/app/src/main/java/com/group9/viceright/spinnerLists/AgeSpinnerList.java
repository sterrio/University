package com.group9.viceright.spinnerLists;

import java.util.ArrayList;
import java.util.List;

public class AgeSpinnerList {

    private List<String> ageList;

    public AgeSpinnerList(){

        ageList = new ArrayList<>();
        ageList.add("10 - 20");
        ageList.add("20 - 30");
        ageList.add("30 - 40");
        ageList.add("40 - 50");
        ageList.add("50 - 60");
        ageList.add("60 +");

    }

    public List<String> getAgeList(){

        return ageList;

    }

}
