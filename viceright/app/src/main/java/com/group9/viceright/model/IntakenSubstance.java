package com.group9.viceright.model;

import java.util.Date;

public class IntakenSubstance extends Substance {
    public Date date;
    public double amount;

    public IntakenSubstance() {
        // should set default values maybe today, and 1g for amount
    }

    public IntakenSubstance(Substance substance, Date date, double amount) {
        super(substance.name, substance.description, substance.maxWarning, substance.govHidden, substance.image);
        this.date = date;
        this.amount = amount;
    }

}
