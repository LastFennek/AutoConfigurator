package com.IO;

import com.logic.Feature;
import com.logic.Paket;
import com.logic.Plattform;
import java.util.HashMap;

public class DB {


    DB(){

    }

    private HashMap<String, Feature> Features = new HashMap<>();
    private HashMap<String, Paket> Pakete = new HashMap<>();
    private HashMap<String, Plattform> Plattformen = new HashMap<>();


    public HashMap<String, Feature> getFeatures() {
        return Features;
    }

    public HashMap<String, Paket> getPakete() {
        return Pakete;
    }

    public HashMap<String, Plattform> getPlattformen(){
            return Plattformen;
    }
}