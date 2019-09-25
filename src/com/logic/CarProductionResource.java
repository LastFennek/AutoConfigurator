package com.logic;

public abstract class CarProductionResource {
    private int price = 0;
    private int time = 0;
    private String name = "not set";

    CarProductionResource(int price, int time, String name){
        this.setPrice(price);
        this.setTime(time);
        this.setName(name);
    }

    private void setPrice(int price){
        if(price > 0 && price < 1000001){
            this.price = price;
        }
    }

    private void setTime(int time){
        if(time > 0 && time < 300){
            this.time = time;
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice(){
        return this.price;
    }

    public int getTime() {
        return this.time;
    }

    public String getName() {
        return this.name;
    }
}
