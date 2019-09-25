package com.logic;

import com.IO.DB;
import java.util.HashSet;

public class CalculateCost {

    /**
     * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * Das ist absolut idiotisch!
     * BITTE EINFACH IGNORIEREN
     * RICHTIGER MÜLL
     * @param CarOStatus
     * @return preis des CarOrderStatus
     */
    public int calcPrice(CarOrderStatus CarOStatus){
        int price = 0;
        HashSet<String> features = new HashSet<>();

        price += CarOStatus.getUsedPricesDB().getPlattformen().get(CarOStatus.getPlattform()).getPrice(); //Das alles nutzt noch getPlattformen anstatt getPlattform

        for (String pack : CarOStatus.getPackages()) {
            price += CarOStatus.getUsedPricesDB().getPakete().get(pack).getPrice();
            price += this.calcPrice(CarOStatus.getUsedPricesDB().getPakete().get(pack), CarOStatus.getUsedPricesDB(), features);
        }
        return price;
    }

    private int calcPrice(Paket paket, DB usedPrices, HashSet features){
        int price = 0;
        for (String s : paket.getFeatures()) {
            if (!features.contains(s)) {
                price += usedPrices.getFeatures().get(s).getPrice();
            }
            features.add(s);

        }
        return price;
    }

    public int calcPrice(CarOrderStatus CarOStatus, String pack){
        int price = 0;
        HashSet<String> features = new HashSet<>();

        for (String COSP : CarOStatus.getPackages()) {
            for (String s : CarOStatus.getUsedPricesDB().getPakete().get(COSP).getFeatures()) {
                features.add(s);
            }
        }

        for (String s : CarOStatus.getUsedPricesDB().getPakete().get(pack).getFeatures()) {
            if(!features.contains(s)){
                features.add(s);
                price += CarOStatus.getUsedPricesDB().getFeatures().get(s).getPrice();
            }
        }

        return price;
    }

}
