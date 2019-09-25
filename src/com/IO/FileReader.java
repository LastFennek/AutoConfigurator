package com.IO;
import com.Translate.Translate;
import com.logic.Feature;
import com.logic.Paket;
import com.logic.Plattform;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class FileReader {

    void loadDB(DB DB, String file){

        try (BufferedReader br = Files.newBufferedReader(Paths.get("C:\\OneDrive\\OneDrive - Bundeshandelsakademie und Bundeshandelsschule Imst\\23_POS_DOBL\\190922\\src\\com\\PPF.txt"))){//Translate.file_paths(file))))) {
            String line;
            int mode = 0;
            while ((line = br.readLine()) != null) {

                if(line.equals("Features:")){       //Ich dachte ich lasse das Mal so, wenn ich es richtig mache, sollte man es ja leicht austauschen können!
                    mode = 1;
                }else if(line.equals("Pakete:")){
                    mode = 2;
                }else if(line.equals("Plattformen:")){
                    mode = 3;
                }else{
                    this.addLineToDB(DB, line, mode);
                }

            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addLineToDB(DB DB, String line, int mode) throws Exception {

        String[] parts = line.split(";");
        if(mode == 0){
            throw new IOException("Fehler beim einlesen der Datei!");
        }else if(mode == 1){

            if(DB.getFeature(parts[2]) == null){
                DB.getFeatures().put(parts[2],new Feature(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]),parts[2]));}
            else{System.out.println("Dublikat in Features!");}

        }else if(mode == 2){

            if(DB.getPakete().get(parts[2]) == null){
                DB.getPakete().put(parts[2],new Paket(Integer.parseInt(parts[1]),Integer.parseInt(parts[0]),parts[2], new ArrayList<String>(Arrays.asList(Arrays.copyOfRange(parts,3,parts.length)))));
            }else{System.out.println("Dublikat in Pakete!");}

        }else if(mode == 3){

            if(DB.getPlattform(parts[2]) == null){
                DB.getPlattformen().put(parts[2],new Plattform(Integer.parseInt(parts[1]),Integer.parseInt(parts[0]),parts[2], new ArrayList<String>(Arrays.asList(Arrays.copyOfRange(parts,3,parts.length)))));
            }else{System.out.println("Dublikat in Plattformen!");}

        }else{
            throw new IOException("Fehler beim einlesen der Datei!");
        }
    }
}
