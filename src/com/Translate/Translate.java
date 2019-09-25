package com.Translate;


import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Translate {

    public static String file_paths(String filename){
        try (BufferedReader br = Files.newBufferedReader(Paths.get("C:\\OneDrive\\OneDrive - Bundeshandelsakademie und Bundeshandelsschule Imst\\23_POS_DOBL\\190922\\src\\com\\Translate\\file_paths"))) {

            String[] parts = null;


            String line;
            while ((line = br.readLine()) != null) {
                parts = line.split(";");

                if(parts[0] == filename){
                    return parts[1];
                }
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }


        return null;
    }

}
