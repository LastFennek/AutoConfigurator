package com.company;

import java.util.HashSet;

public class c_Auto {
    Plattform plattform;
    HashSet<String> pakete = new HashSet<>();


    public int getPrice(b_DB DB){

        int preis = 0;

        preis += this.plattform.basePreis;

        HashSet<String> features = new HashSet<>();
        for (String x : this.pakete) {
            preis += DB.getPakete().get(x).basePrice;
            for (String s : DB.getPakete().get(x).features) {
                if (features.contains(s)) {
                    continue;
                } else {
                    features.add(s);
                    preis += DB.getFeatures().get(s).Preis;
                }

            }
        }
        return preis;
    }

    public int getPrice(b_DB DB , String Packet){

        HashSet<String> features = new HashSet<>();
        for (String x : this.pakete) {
            for (String s : DB.getPakete().get(x).features) {
                if (features.contains(s)) {
                    continue;
                } else {
                    features.add(s);
                }

            }
        }

        int preisPac = 0;
        preisPac += DB.getPakete().get(Packet).basePrice;
        for (String s : DB.getPakete().get(Packet).features) {
            if (features.contains(s)) {
                continue;
            } else {
                features.add(s);
                preisPac += DB.getFeatures().get(s).Preis;
            }

        }
        return preisPac;
    }

    public int getDauer(b_DB DB){

        int dauer = 0;

        dauer += this.plattform.deliveryTime;

        HashSet<String> features = new HashSet<>();
        for (String x : this.pakete) {
            dauer += DB.getPakete().get(x).deliveryTime;
            for (String s : DB.getPakete().get(x).features) {
                if (features.contains(s)) {
                    continue;
                } else {
                    features.add(s);
                    dauer += DB.getFeatures().get(s).deliveryTime;
                }

            }
        }
        return dauer;
    }
}
