package com.logic;

import java.util.ArrayList;

public class Plattform extends CarProductionResource{

    private  ArrayList<String> packages = new ArrayList<>();

    public Plattform(int price, int time, String name, ArrayList<String> packages) {
        super(price,time,name);
        this.setPackages(packages);
    }

    private void setPackages(ArrayList<String> packages){
        this.packages = packages;
    }

    public String[] getPackages(){
        return packages.toArray(String[]::new);
    }

}
