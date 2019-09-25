package com.logic;

import com.IO.DB;
import java.util.HashSet;

public class CalculateTime {

    /**
     * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * Das ist absolut idiotisch!
     * BITTE EINFACH IGNORIEREN
     * RICHTIGER MÜLL
     * @param CarOStatus
     * @return preis des CarOrderStatus
     */
    public int calcTime(CarOrderStatus CarOStatus){
        int time = 0;
        HashSet<String> features = new HashSet<>();

        time += CarOStatus.getUsedPricesDB().getPlattformen().get(CarOStatus.getPlattform()).getTime();

        for (String pack : CarOStatus.getPackages()) {
            time += CarOStatus.getUsedPricesDB().getPakete().get(pack).getTime();
            time += this.calcTime(CarOStatus.getUsedPricesDB().getPakete().get(pack), CarOStatus.getUsedPricesDB(), features);
        }
        return time;
    }

    private int calcTime(Paket paket, DB usedPrices, HashSet features){
        int time = 0;
        for (String s : paket.getFeatures()) {
            if (!features.contains(s)) {
                time += usedPrices.getFeatures().get(s).getTime();
            }
            features.add(s);

        }
        return time;
    }

    public int calcTime(CarOrderStatus CarOStatus, String pack){
        int time = 0;
        HashSet<String> features = new HashSet<>();

        for (String COSP : CarOStatus.getPackages()) {
            for (String s : CarOStatus.getUsedPricesDB().getPakete().get(COSP).getFeatures()) {
                features.add(s);
            }
        }

        for (String s : CarOStatus.getUsedPricesDB().getPakete().get(pack).getFeatures()) {
            if(!features.contains(s)){
                features.add(s);
                time += CarOStatus.getUsedPricesDB().getFeatures().get(s).getTime();
            }
        }

        return time;
    }

}
