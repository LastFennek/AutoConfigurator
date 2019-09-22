package com.company;

import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class a_Main {

    public static void main(String[] args) {
	// write your code here
        b_DB DB = new b_DB();
        c_Auto auto = new c_Auto();
        Scanner scan = new Scanner(System.in);

        int x = 0;
        while(x != -1){
            switch(x){
                case 0:
                    System.out.println("Bitte wählen Sie eine Plattform:");
                    HashMap<Integer,String> ignoreThatShitICantThinkOfABetterSolutionATM = new HashMap<>();
                    int counter = 0;
                    for (Map.Entry<String,Plattform> pf: DB.getPlattformen().entrySet()) {
                        System.out.print(counter+") \t"+pf.getValue().name);

                        if (auto.plattform == pf.getValue()) {
                            System.out.println("*");
                        } else {
                            System.out.println("");
                        }

                        ignoreThatShitICantThinkOfABetterSolutionATM.put(counter,pf.getValue().name);
                        counter++;
                    }
                    if(auto.plattform != null){
                        System.out.println(counter+")\t weiter");
                    }
                    int input = scan.nextInt();
                    if(input != counter){
                        auto.plattform = DB.getPlattformen().get(ignoreThatShitICantThinkOfABetterSolutionATM.get(input));
                    }

                    x = 1;
                    break;
                case 1:
                    System.out.println("Bitte wählen Sie Pakete:");
                    ignoreThatShitICantThinkOfABetterSolutionATM = new HashMap<>();
                    System.out.println("0)\tzurück");
                    counter = 1;
                    for (String pf: auto.plattform.pakete) {
                        System.out.print(counter+") \t"+pf);

                        if (auto.pakete.contains(pf)) {
                            System.out.println("*");
                        } else {
                            System.out.println("");
                        }

                        ignoreThatShitICantThinkOfABetterSolutionATM.put(counter,pf);
                        counter++;
                    }
                    System.out.println(counter+")\tBestellen");
                    input = scan.nextInt();
                    if(input == 0){
                        x = 0;
                        break;
                    }else if(input == counter){
                        x = -1;
                        break;
                    }else{
                        if(auto.pakete.contains(ignoreThatShitICantThinkOfABetterSolutionATM.get(input))){
                            auto.pakete.remove(ignoreThatShitICantThinkOfABetterSolutionATM.get(input));
                        }else{
                            auto.pakete.add(ignoreThatShitICantThinkOfABetterSolutionATM.get(input));
                        }
                    }
                    break;
                default: x = 0; break;
            }
        }
        Bestellen(auto,DB);

    }

    public static void Bestellen(c_Auto auto, b_DB DB){
        int preis = 0;
        int dauer = 0;

        preis += auto.plattform.basePreis;
        dauer += auto.plattform.deliveryTime;

        HashSet<String> features = new HashSet<>();
        for (String x: auto.pakete) {
            preis += DB.getPakete().get(x).basePrice;
            dauer += DB.getPakete().get(x).deliveryTime;
            for (String s : DB.getPakete().get(x).features) {
                if(features.contains(s)){
                    continue;
                }else{
                    features.add(s);
                    preis += DB.getFeatures().get(s).Preis;
                    dauer += DB.getFeatures().get(s).deliveryTime;
                }

            }
        }

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDate = LocalDate.now();
        //System.out.println(dtf.format(localDate)+1);
        //System.out.println(localDate.plusDays(dauer%8));


        System.out.println("Dein Auto wird bestellt. Es kostet: "+preis+"€, und wird am "+localDate.plusDays(dauer%8)+" geliefert");

    }
}
