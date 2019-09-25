package com.company;

import java.util.ArrayList;
import java.util.Date;

public class Plattform {

    public Plattform(int deliveryTime, int basePreis, String name, ArrayList<String> pakete) {
        this.deliveryTime = deliveryTime;
        this.basePreis = basePreis;
        this.name = name;
        this.pakete = pakete;
    }

    int deliveryTime;
    int basePreis;
    String name;
    ArrayList<String> pakete = new ArrayList<>();



}
