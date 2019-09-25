package com.IO;

import com.logic.Feature;
import com.logic.Paket;
import com.logic.Plattform;
import java.util.HashMap;

public class DB {


    DB(){

    }

    private HashMap<String, Feature> features = new HashMap<>();
    private HashMap<String, Paket> pakete = new HashMap<>();
    private HashMap<String, Plattform> plattformen = new HashMap<>();


    public HashMap<String, Feature> getFeatures() {
        return features;
    }

    public Feature getFeature(String name){
        if(features.containsKey(name)){
            return features.get(name);
        }else{
            return null;
        }
    }

    public HashMap<String, Paket> getPakete() {
        return pakete;
    }

    public Paket getPaket(String name){
        if(pakete.containsKey(name)){
            return pakete.get(name);
        }else{
            return null;
        }
    }

    public HashMap<String, Plattform> getPlattformen(){
            return plattformen;
    }

    public Plattform getPlattform(String name){
        if(plattformen.containsKey(name)){
            return plattformen.get(name);
        }else{
            return null;
        }
    }
}