package com.GUI;

public class GUIOutput {

    public void choosePlattform(){
        System.out.println("Bitte wählen Sie eine Plattform!");
    }

    public void choosePakets(){
        System.out.println("Bitte wählen Sie Pakete!");
    }


    public void printPlattform(String name, int price, boolean selected, int counter){
        System.out.print(counter + ") \t" +name+" -> "+price);

        if(selected){
            System.out.println("*");
        }else {
            System.out.println();
        }

    }

    public void printNext(int num){
        System.out.println(num + ")\t weiter");
    }

    public void printPrevious(){
        System.out.println("0)\t zurueck");
    }
}
