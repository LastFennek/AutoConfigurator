package com.GUI;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class UserInput {
    private Scanner scan = new Scanner(System.in);
    private int from = 0;
    private int to = Integer.MAX_VALUE;

    public UserInput(){}

    public UserInput(int from, int to){
        this.from = from;
        this.to = to;
    }

    public int inputInt(){
        int ret = 0;
        Boolean valid = true;
        do{
            valid = true;
            try {
                ret = scan.nextInt();
            }catch (Exception e){
                valid = false;
                scan = new Scanner(System.in);
                System.out.println("Please enter a number!");
            }

            if(ret < this.from || ret > this.to){
                System.out.println("Please enter a number from "+this.from+" to" + this.to);
            }
        }while (ret < this.from || ret > this.to || !valid);

        return ret;
    }

    public int inputInt(int from, int to){
        int ret = 0;

        do{
            try {
                ret = scan.nextInt();
            }catch (Exception e){
                System.out.println("Please enter a number!");
            }

            if(ret < from || ret > to){
                System.out.println("Please enter a number from "+this.from+" to" + this.to);
            }
        }while (ret < from || ret > to);

        return ret;
    }
}
