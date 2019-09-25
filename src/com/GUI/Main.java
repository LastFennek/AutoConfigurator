


package com.GUI;

import com.IO.DB;
import com.logic.CarOrderStatus;
import com.logic.Plattform;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {//throws everyExeption{
        // write your code here
        DB DB = new DB();
        CarOrderStatus car = new CarOrderStatus();
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

                        if (car.plattform == pf.getValue()) {
                            System.out.println("*");
                        } else {
                            System.out.println("");
                        }

                        ignoreThatShitICantThinkOfABetterSolutionATM.put(counter, pf.getValue().name);
                        counter++;
                    }
                    if (car.plattform != null) {
                        System.out.println(counter + ")\t weiter");
                    }
                    int input = scan.nextInt();
                    if (input != counter) {
                        car.plattform = DB.getPlattformen().get(ignoreThatShitICantThinkOfABetterSolutionATM.get(input));
                    }

                    x = 1;
                    break;


                case 1:
                    System.out.println("Bitte wählen Sie Pakete:");
                    ignoreThatShitICantThinkOfABetterSolutionATM = new HashMap<>();
                    System.out.println("0)\tzurück");
                    System.out.println("");
                    counter = 1;
                    for (String pf : car.plattform.pakete) {
                        System.out.print(counter + ") \t" + pf+ " -> " + car.getPrice(DB,pf)+"€  ");

                        if (car.pakete.contains(pf)) {
                            System.out.println("*");
                        } else {
                            System.out.println("");
                        }

                        ignoreThatShitICantThinkOfABetterSolutionATM.put(counter, pf);
                        counter++;
                    }
                    System.out.println("");
                    System.out.println(counter + ")\tBestellen");
                    System.out.println("Momentan: " + car.getPrice(DB)+"€ -> Lieferdauer(h): " + car.getDauer(DB));
                    input = scan.nextInt();
                    if (input == 0) {
                        x = 0;
                        break;
                    } else if (input == counter) {
                        x = -1;
                        break;
                    } else {
                        if (car.pakete.contains(ignoreThatShitICantThinkOfABetterSolutionATM.get(input))) {
                            car.pakete.remove(ignoreThatShitICantThinkOfABetterSolutionATM.get(input));
                        } else {
                            car.pakete.add(ignoreThatShitICantThinkOfABetterSolutionATM.get(input));
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

        System.out.println("Dein Auto wird bestellt. Es kostet: " + car.getPrice(DB) + "€, und wird am " + localDate.plusDays(car.getDauer(DB) / 8) + " geliefert");
    }
}
