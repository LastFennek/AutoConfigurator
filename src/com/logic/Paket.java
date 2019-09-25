package com.logic;

import java.util.ArrayList;

public class Paket extends CarProductionResource{

    private ArrayList<String> features = new ArrayList<>();


    public Paket(int price, int time, String name, ArrayList<String> features) {
        super(price,time,name);
        this.setFeatures(features);
    }

    private void setFeatures(ArrayList<String> features){
        this.features = features;
    }




}
