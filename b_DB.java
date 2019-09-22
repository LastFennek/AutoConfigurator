package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class b_DB {


    b_DB(){
        this.read();
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

    private void read(){
        try (BufferedReader br = Files.newBufferedReader(Paths.get("C:\\OneDrive\\OneDrive - Bundeshandelsakademie und Bundeshandelsschule Imst\\23_POS_DOBL\\190922\\src\\com\\company\\PPF.txt"))) {

            // read line by line
            String line;
            int mode = -1;
            while ((line = br.readLine()) != null) {

                if(line.equals("Features:")){
                    mode = 1;
                }else if(line.equals("Pakete:")){
                    mode = 2;
                }else if(line.equals("Plattformen:")){
                    mode = 3;
                }else{
                    String[] parts = line.split(";");
                    if(mode == 1){
                        if(Features.get(parts[2]) == null){
                            Features.put(parts[2],new Feature(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]),parts[2]));
                        }else{
                            System.out.println("Dublikat in Features!");
                        }
                    }else if(mode == 2){
                        if(Pakete.get(parts[2]) == null){
                            Pakete.put(parts[2],new Paket(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]),parts[2], new ArrayList<String>(Arrays.asList(Arrays.copyOfRange(parts,3,parts.length)))));
                        }else{
                            System.out.println("Dublikat in Pakete!");
                        }
                    }else if(mode == 3){
                        if(Plattformen.get(parts[2]) == null){
                            Plattformen.put(parts[2],new Plattform(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]),parts[2], new ArrayList<String>(Arrays.asList(Arrays.copyOfRange(parts,3,parts.length)))));
                        }else{
                            System.out.println("Dublikat in Plattformen!");
                        }
                    }else{

                        System.out.println("Fehler beim einlesen der Datei! Mode: "+ mode);
                        break;
                    }
                }
            }

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

}