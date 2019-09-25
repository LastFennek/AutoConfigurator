package com.GUI;

import com.IO.DB;
import com.logic.CarOrderStatus;
import com.logic.Plattform;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Sequence {

    public static void main(String[] args) {//throws everyExeption{
        // write your code here
        DB DB = new DB();
        CarOrderStatus car = new CarOrderStatus(DB);
        UserInput input = new UserInput();
        GUIOutput output = new GUIOutput();

        int x = 0;
        while (x != -1) {
            switch (x) {
                case 0:
                    output.choosePlattform();
                    HashMap<Integer, String> mapNumberToPlattform = new HashMap<>();
                    int counter = 0;

                    for (Map.Entry<String, Plattform> pf : DB.getPlattformen().entrySet()) {
                    Boolean selected = false;
                        if (car.getPlattform() == pf.getValue().getName()) {
                            selected = true;
                        }
                        output.printPlattform(pf.getValue().getName(),pf.getValue().getPrice(),selected,counter);
                        mapNumberToPlattform.put(counter, pf.getValue().getName());
                        counter++;
                    }

                    if (car.getPlattform() != null) {
                        output.printNext(counter);
                    }

                    int in = input.inputInt();
                    if (in != counter) {
                        car.setPlattform(DB.getPlattform(mapNumberToPlattform.get(input)).getName());
                    }
                    x = 1;
                    break;


                case 1:
                    output.choosePakets();
                    mapNumberToPlattform = new HashMap<>();
                    output.printPrevious();
                    System.out.println("");
                    counter = 1;
                    for (String pf : DB.getPlattform(car.getPlattform()).getPackages()) {
                        System.out.print(counter + ") \t" + pf+ " -> " + car.getNewPackagePrice(pf)+"€  ");

                        if (car.getPackages().contains(pf)) {
                            System.out.println("*");
                        } else {
                            System.out.println("");
                        }

                        mapNumberToPlattform.put(counter, pf);
                        counter++;
                    }
                    System.out.println("");
                    System.out.println(counter + ")\tBestellen");
                    System.out.println("Momentan: " + car.getPrice()+"€ -> Lieferdauer(h): " + car.getTime());
                    in = input.inputInt();

                    if (in == 0) {
                        x = 0;
                        break;
                    } else if (in == counter) {
                        x = -1;
                        break;
                    } else {
                        if (car.getPackages().contains(mapNumberToPlattform.get(input))) {
                            car.removePackage(mapNumberToPlattform.get(input));
                        } else {
                            car.addPackage(mapNumberToPlattform.get(input));
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

        System.out.println("Dein Auto wird bestellt. Es kostet: " + car.getPrice() + "€, und wird am " + localDate.plusDays(car.getTime() / 8) + " geliefert");
    }
}
