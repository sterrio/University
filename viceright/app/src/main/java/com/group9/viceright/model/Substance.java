package com.group9.viceright.model;

import java.io.Serializable;
import java.util.List;

public class Substance implements Serializable {

    // Used to create a new Substance
    public String name;
    public String description;
    public Boolean govHidden;
    public Double maxWarning;
    public String image;

    public Substance (){

    }

    /**
     * substance data
     * @param name name of substance
     * @param description description of the substance
     * @param maxWarning threshold of dosage that will trigger health warning
     * @param govHidden privacy preference for sharing data on the substance
     * @param image image of the substance
     */
    public Substance(String name, String description, Double maxWarning, Boolean govHidden, String image){
        this.name = name;
        this.description = description;
        this.maxWarning = maxWarning;
        this.govHidden = govHidden;
        this.image = image;
    }

    public static Substance poll(List<Substance> substances, String s){
        Substance vice;
        for(Substance sub : substances){
            if(sub.name.equals(s)){
                vice = sub;
                return vice;
            }
        }
        return null;
    }
}
