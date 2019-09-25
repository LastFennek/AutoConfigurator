package com.logic;
import com.IO.DB;
import java.util.HashSet;

public class CarOrderStatus {
    private String plattform;
    private HashSet<String> packages = new HashSet<>();
    private DB usedPricesDB;
    private CalculateCost calcPrice = new CalculateCost();
    private CalculateTime calcTime = new CalculateTime();

    public CarOrderStatus(DB DB){
        this.usedPricesDB = DB;
    }

    public int getPrice(){
        return calcPrice.calcPrice(this);
    }

    public int getNewPackagePrice(String pack){
        return calcPrice.calcPrice(this, pack);
    }

    public int getTime(){
        return calcTime.calcTime(this);
    }

    public String getPlattform() {
        return this.plattform;
    }

    public void setPlattform(String plattform){
        this.plattform = plattform;
    }

    public HashSet<String> getPackages() {
        return this.packages;
    }

    public void removePackage(String packet) {
        this.packages.remove(packet);
    }

    public void addPackage(String packet){
        this.packages.add(packet);
    }

    DB getUsedPricesDB() {
        return this.usedPricesDB;
    }
}