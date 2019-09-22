package com.company;

import java.util.ArrayList;
import java.util.Date;

public class Paket {

    public Paket(int deliveryTime, int basePrice, String name, ArrayList<String> features) {
        this.deliveryTime = deliveryTime;
        this.basePrice = basePrice;
        this.name = name;
        this.features = features;
    }

    int deliveryTime;
    int basePrice;
    String name;
    ArrayList<String> features = new ArrayList<>();


}
