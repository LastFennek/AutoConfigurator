


package com.company;

import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class a_Main {

    public static void main(String[] args) {//throws everyExeption{
        // write your code here
        b_DB DB = new b_DB();
        c_Auto auto = new c_Auto();
        Scanner scan = new Scanner(System.in);

        int x = 0;
        while (x != -1) {
            switch (x) {
                case 0:
                    System.out.println("Bitte wählen Sie eine Plattform:");
                    HashMap<Integer, String> ignoreThatShitICantThinkOfABetterSolutionATM = new HashMap<>();
                    int counter = 0;
                    for (Map.Entry<String, Plattform> pf : DB.getPlattformen().entrySet()) {
                        System.out.print(counter + ") \t" + pf.getValue().name);

                        if (auto.plattform == pf.getValue()) {
                            System.out.println("*");
                        } else {
                            System.out.println("");
                        }

                        ignoreThatShitICantThinkOfABetterSolutionATM.put(counter, pf.getValue().name);
                        counter++;
                    }
                    if (auto.plattform != null) {
                        System.out.println(counter + ")\t weiter");
                    }
                    int input = scan.nextInt();
                    if (input != counter) {
                        auto.plattform = DB.getPlattformen().get(ignoreThatShitICantThinkOfABetterSolutionATM.get(input));
                    }

                    x = 1;
                    break;


                case 1:
                    System.out.println("Bitte wählen Sie Pakete:");
                    ignoreThatShitICantThinkOfABetterSolutionATM = new HashMap<>();
                    System.out.println("0)\tzurück");
                    System.out.println("");
                    counter = 1;
                    for (String pf : auto.plattform.pakete) {
                        System.out.print(counter + ") \t" + pf+ " -> " + auto.getPrice(DB,pf)+"€  ");

                        if (auto.pakete.contains(pf)) {
                            System.out.println("*");
                        } else {
                            System.out.println("");
                        }

                        ignoreThatShitICantThinkOfABetterSolutionATM.put(counter, pf);
                        counter++;
                    }
                    System.out.println("");
                    System.out.println(counter + ")\tBestellen");
                    System.out.println("Momentan: " + auto.getPrice(DB)+"€ -> Lieferdauer(h): " + auto.getDauer(DB));
                    input = scan.nextInt();
                    if (input == 0) {
                        x = 0;
                        break;
                    } else if (input == counter) {
                        x = -1;
                        break;
                    } else {
                        if (auto.pakete.contains(ignoreThatShitICantThinkOfABetterSolutionATM.get(input))) {
                            auto.pakete.remove(ignoreThatShitICantThinkOfABetterSolutionATM.get(input));
                        } else {
                            auto.pakete.add(ignoreThatShitICantThinkOfABetterSolutionATM.get(input));
                        }
                    }
                    break;


                default:
                    x = 0;
                    break;
            }
        }

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDate = LocalDate.now();

        System.out.println("Dein Auto wird bestellt. Es kostet: " + auto.getPrice(DB) + "€, und wird am " + localDate.plusDays(auto.getDauer(DB) / 8) + " geliefert");
    }
}
