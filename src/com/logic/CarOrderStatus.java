package com.logic;
import com.IO.DB;
import java.util.HashSet;

public class CarOrderStatus {
    private Plattform plattform;
    private HashSet<Paket> packages = new HashSet<>();
    private DB usedPricesDB;

    CarOrderStatus(DB DB){
        this.usedPricesDB = DB;
    }

    public int getPrice(){
        int preis = 0;
        HashSet<String> features = new HashSet<>();

        preis += this.plattform.getPrice();
        for (Paket x : this.packages) {
            preis += x.getPrice();
            for (String s : x.getFeatures()) {
                if (features.contains(s)) {
                    continue;
                } else {
                    features.add(s);
                    preis += usedPricesDB.getFeatures().get(s).getPrice();
                }

            }
        }
        return preis;
    }

    public int getPrice(String Packet){

        HashSet<String> features = new HashSet<>();
        for (String x : this.packages) {
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

    public int getDauer(){

        int dauer = 0;

        dauer += this.plattform.deliveryTime;

        HashSet<String> features = new HashSet<>();
        for (String x : this.packages) {
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