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

public class Filereader {

    private void read(DB DB, String file){


        try (BufferedReader br = Files.newBufferedReader(Paths.get(Translate.file_paths(file)))) {

            String line;
            while ((line = br.readLine()) != null) {

            }

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

    private void addLineToDB(DB DB, String line){
            String[] parts = line.split(";");

    }


}
